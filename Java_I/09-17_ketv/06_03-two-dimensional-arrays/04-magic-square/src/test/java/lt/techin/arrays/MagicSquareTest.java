package lt.techin.arrays;

import com.sun.source.tree.Tree;
import java.util.Arrays;
import lt.techin.testing.ConsoleCheck;
import lt.techin.testing.SourceCheck;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;

@Timeout(2)
class MagicSquareTest {
    @Test void recognizesKnownMagicSquares() {
        assertTrue(MagicSquare.isMagic(new int[][]{{2, 7, 6}, {9, 5, 1}, {4, 3, 8}}));
        assertTrue(MagicSquare.isMagic(new int[][]{
                {16, 3, 2, 13}, {5, 10, 11, 8},
                {9, 6, 7, 12}, {4, 15, 14, 1}}));
        assertTrue(MagicSquare.isMagic(new int[][]{{7}}));
    }

    @Test void rejectsEmptyAndNonSquareStructures() {
        assertFalse(MagicSquare.isMagic(new int[][]{}));
        assertFalse(MagicSquare.isMagic(new int[][]{{1, 2, 3}, {4, 5, 6}}));
        assertFalse(MagicSquare.isMagic(new int[][]{{1, 2}, {3}}));
    }

    @Test void rejectsFailuresInRowsColumnsOrDiagonals() {
        assertFalse(MagicSquare.isMagic(new int[][]{{1, 1}, {1, 2}}));
        assertFalse(MagicSquare.isMagic(new int[][]{{1, 2}, {2, 1}}));
        assertFalse(MagicSquare.isMagic(new int[][]{{1, 2, 1}, {1, 1, 2}, {2, 1, 1}}));
    }

    @Test void reusesTheSuppliedHelpers() throws Exception {
        SourceCheck check = SourceCheck.method("lt.techin.arrays.MagicSquare", "isMagic", 1);
        check.requireCall("isSquare");
        check.requireCall("rowSum");
        check.requireCall("columnSum");
    }
}
