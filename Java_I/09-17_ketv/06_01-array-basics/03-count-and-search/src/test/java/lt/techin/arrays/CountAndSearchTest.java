package lt.techin.arrays;

import com.sun.source.tree.Tree;
import java.util.Arrays;
import lt.techin.testing.ConsoleCheck;
import lt.techin.testing.SourceCheck;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;

@Timeout(2)
class CountAndSearchTest {
    @Test void countsOnlyValuesStrictlyGreaterThanTheLimit() {
        assertEquals(4, CountAndSearch.countGreaterThan(new int[]{4, 7, 4, 9}, 3));
        assertEquals(2, CountAndSearch.countGreaterThan(new int[]{4, 7, 4, 9}, 4));
        assertEquals(0, CountAndSearch.countGreaterThan(new int[]{}, 4));
        assertEquals(1, CountAndSearch.countGreaterThan(new int[]{-5, -2, -8}, -4));
    }

    @Test void findsFirstAndLastDuplicatePositions() {
        int[] values = {4, 7, 4, 9, 4};
        assertEquals(0, CountAndSearch.firstIndexOf(values, 4));
        assertEquals(4, CountAndSearch.lastIndexOf(values, 4));
        assertEquals(3, CountAndSearch.firstIndexOf(values, 9));
        assertEquals(3, CountAndSearch.lastIndexOf(values, 9));
    }

    @Test void returnsMinusOneAndFalseWhenMissing() {
        int[] values = {4, 7, 4, 9};
        assertEquals(-1, CountAndSearch.firstIndexOf(values, 3));
        assertEquals(-1, CountAndSearch.lastIndexOf(values, 3));
        assertEquals(-1, CountAndSearch.firstIndexOf(new int[]{}, 3));
        assertFalse(CountAndSearch.contains(values, 3));
        assertTrue(CountAndSearch.contains(values, 7));
    }

    @Test void containsReusesFirstIndexOf() throws Exception {
        SourceCheck.method("lt.techin.arrays.CountAndSearch", "contains", 2)
                .requireCall("firstIndexOf");
    }
}
