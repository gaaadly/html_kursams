package lt.techin.arraylist;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TheGreatestTest {
    @Test
    void findsTheGreatestPositiveOrRepeatedValue() {
        assertEquals(7, TheGreatest.greatest(new ArrayList<>(List.of(3, 2, 7, 2))));
        assertEquals(2, TheGreatest.greatest(new ArrayList<>(List.of(2, 2, 2))));
        assertEquals(4, TheGreatest.greatest(new ArrayList<>(List.of(4))));
    }

    @Test
    void handlesAllNegativeValues() {
        assertEquals(-1, TheGreatest.greatest(new ArrayList<>(List.of(-2, -1, -3))));
        assertEquals(-9000, TheGreatest.greatest(
                new ArrayList<>(List.of(-9000, -9001))));
    }
}
