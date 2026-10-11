package lt.techin.arrays;

import com.sun.source.tree.Tree;
import java.util.Arrays;
import lt.techin.testing.ConsoleCheck;
import lt.techin.testing.SourceCheck;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;

@Timeout(2)
class ArrayStatisticsTest {
    @Test void sumsArraysIncludingEmptyAndNegativeValues() {
        assertEquals(0, ArrayStatistics.sum(new int[]{}));
        assertEquals(15, ArrayStatistics.sum(new int[]{5, 1, 3, 4, 2}));
        assertEquals(-7, ArrayStatistics.sum(new int[]{-2, 4, -9}));
    }

    @Test void findsMinimumAndMaximumIncludingAllNegativeValues() {
        assertEquals(1, ArrayStatistics.min(new int[]{5, 1, 3, 4, 2}));
        assertEquals(5, ArrayStatistics.max(new int[]{5, 1, 3, 4, 2}));
        assertEquals(-12, ArrayStatistics.min(new int[]{-4, -12, -7}));
        assertEquals(-4, ArrayStatistics.max(new int[]{-4, -12, -7}));
        assertEquals(8, ArrayStatistics.min(new int[]{8}));
        assertEquals(8, ArrayStatistics.max(new int[]{8}));
    }

    @Test void calculatesDecimalAverage() {
        assertEquals(5.3, ArrayStatistics.average(new int[]{5, 4, 5, 4, 9, 4, 9, 4, 5, 4}), 0.000001);
        assertEquals(2.5, ArrayStatistics.average(new int[]{1, 2, 3, 4}), 0.000001);
        assertEquals(-1.5, ArrayStatistics.average(new int[]{-1, -2}), 0.000001);
    }
}
