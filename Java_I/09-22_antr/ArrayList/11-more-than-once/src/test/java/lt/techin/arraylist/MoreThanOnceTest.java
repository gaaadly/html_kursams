package lt.techin.arraylist;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MoreThanOnceTest {
    @Test
    void returnsFalseForEmptyMissingAndSingleOccurrences() {
        assertFalse(MoreThanOnce.moreThanOnce(new ArrayList<>(), 1));
        assertFalse(MoreThanOnce.moreThanOnce(
                new ArrayList<>(List.of(1, 2, 3)), 4));
        assertFalse(MoreThanOnce.moreThanOnce(
                new ArrayList<>(List.of(1, 2, 3)), 2));
    }

    @Test
    void returnsTrueForTwoOrMoreOccurrences() {
        assertTrue(MoreThanOnce.moreThanOnce(
                new ArrayList<>(List.of(1, 2, 3, 2)), 2));
        assertTrue(MoreThanOnce.moreThanOnce(
                new ArrayList<>(List.of(-1, 7, -1, -1)), -1));
    }
}
