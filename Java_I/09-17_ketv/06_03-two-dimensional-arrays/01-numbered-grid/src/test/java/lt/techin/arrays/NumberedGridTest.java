package lt.techin.arrays;

import com.sun.source.tree.Tree;
import java.util.Arrays;
import lt.techin.testing.ConsoleCheck;
import lt.techin.testing.SourceCheck;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;

@Timeout(2)
class NumberedGridTest {
    @Test void createsNumberedRectangularGrids() {
        assertArrayEquals(new int[][]{{1, 2, 3}, {4, 5, 6}}, NumberedGrid.create(2, 3));
        assertArrayEquals(new int[][]{{1}, {2}, {3}}, NumberedGrid.create(3, 1));
        assertArrayEquals(new int[0][4], NumberedGrid.create(0, 4));
        assertArrayEquals(new int[][]{{}, {}, {}}, NumberedGrid.create(3, 0));
    }

    @Test void changesOnlyTheSelectedCell() {
        int[][] grid = {{1, 2, 3}, {4, 5, 6}};
        NumberedGrid.setCell(grid, 1, 2, 99);
        assertArrayEquals(new int[][]{{1, 2, 3}, {4, 5, 99}}, grid);
    }

    @Test void describesNestedContents() {
        assertEquals("[[1, 2, 3], [4, 5, 6]]", NumberedGrid.describe(new int[][]{{1, 2, 3}, {4, 5, 6}}));
        assertEquals("[[], [7, 8]]", NumberedGrid.describe(new int[][]{{}, {7, 8}}));
    }

    @Test void usesNestedLoopsAndDeepToString() throws Exception {
        SourceCheck.method("lt.techin.arrays.NumberedGrid", "create", 2)
                .require(Tree.Kind.FOR_LOOP, 2, "Use nested for loops to fill the grid.");
        SourceCheck.method("lt.techin.arrays.NumberedGrid", "describe", 1)
                .requireCall("deepToString");
    }
}
