package lt.techin.arrays;

import com.sun.source.tree.Tree;
import java.util.Arrays;
import lt.techin.testing.ConsoleCheck;
import lt.techin.testing.SourceCheck;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;

@Timeout(2)
class RaggedStatisticsTest {
    @Test void findsMaximumAcrossRaggedAndEmptyRows() {
        assertEquals(9, RaggedStatistics.max(new int[][]{{5, 4}, {}, {9, 1, 3}}));
        assertEquals(-1, RaggedStatistics.max(new int[][]{{}, {-4, -1}, {-8}}));
        assertEquals(7, RaggedStatistics.max(new int[][]{{7}}));
    }

    @Test void sumsSelectedRowsIncludingEmptyRows() {
        int[][] values = {{1, 2, 3}, {}, {4, 5}};
        assertEquals(6, RaggedStatistics.rowSum(values, 0));
        assertEquals(0, RaggedStatistics.rowSum(values, 1));
        assertEquals(9, RaggedStatistics.rowSum(values, 2));
    }

    @Test void returnsOneSumPerRaggedRow() {
        assertArrayEquals(new int[]{6, 0, 9},
                RaggedStatistics.allRowSums(new int[][]{{1, 2, 3}, {}, {4, 5}}));
        assertArrayEquals(new int[]{}, RaggedStatistics.allRowSums(new int[][]{}));
    }

    @Test void allRowSumsReusesRowSum() throws Exception {
        SourceCheck.method("lt.techin.arrays.RaggedStatistics", "allRowSums", 1)
                .requireCall("rowSum");
    }
}
