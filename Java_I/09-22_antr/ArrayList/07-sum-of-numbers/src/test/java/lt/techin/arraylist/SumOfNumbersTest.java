package lt.techin.arraylist;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SumOfNumbersTest {
    @Test
    void sumsEmptyPositiveAndMixedLists() {
        assertEquals(0, SumOfNumbers.sum(new ArrayList<>()));
        assertEquals(14, SumOfNumbers.sum(new ArrayList<>(List.of(3, 2, 7, 2))));
        assertEquals(0, SumOfNumbers.sum(
                new ArrayList<>(List.of(-1, 1, -2, 2, -3, 3))));
        assertEquals(-9, SumOfNumbers.sum(new ArrayList<>(List.of(-4, -5))));
    }
}
