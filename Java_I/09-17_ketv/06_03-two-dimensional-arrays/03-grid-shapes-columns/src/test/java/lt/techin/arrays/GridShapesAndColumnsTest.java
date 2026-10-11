package lt.techin.arrays;

import com.sun.source.tree.Tree;
import java.util.Arrays;
import lt.techin.testing.ConsoleCheck;
import lt.techin.testing.SourceCheck;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;

@Timeout(2)
class GridShapesAndColumnsTest {
    @Test void recognizesRectangularAndRaggedShapes() {
        assertTrue(GridShapesAndColumns.isRectangular(new int[][]{{1, 2}, {3, 4}, {5, 6}}));
        assertTrue(GridShapesAndColumns.isRectangular(new int[][]{{}, {}}));
        assertTrue(GridShapesAndColumns.isRectangular(new int[][]{}));
        assertFalse(GridShapesAndColumns.isRectangular(new int[][]{{1, 2}, {3}, {4, 5}}));
    }

    @Test void recognizesSquareIncludingRaggedNegativeCases() {
        assertTrue(GridShapesAndColumns.isSquare(new int[][]{{1, 2}, {3, 4}}));
        assertTrue(GridShapesAndColumns.isSquare(new int[][]{{7}}));
        assertTrue(GridShapesAndColumns.isSquare(new int[][]{}));
        assertFalse(GridShapesAndColumns.isSquare(new int[][]{{1, 2, 3}, {4, 5, 6}}));
        assertFalse(GridShapesAndColumns.isSquare(new int[][]{{1, 2, 3}, {4, 5}, {6, 7, 8}}));
    }

    @Test void sumsColumnsInRectangularGrids() {
        int[][] grid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        assertEquals(12, GridShapesAndColumns.columnSum(grid, 0));
        assertEquals(15, GridShapesAndColumns.columnSum(grid, 1));
        assertEquals(18, GridShapesAndColumns.columnSum(grid, 2));
        assertEquals(-3, GridShapesAndColumns.columnSum(new int[][]{{-1}, {-2}}, 0));
    }
}
