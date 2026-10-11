package lt.techin.arraylist;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

class LengthsOfStringsTest {
    @Test
    void returnsLengthsInTheSameOrder() {
        var source = new ArrayList<>(List.of("Hallo", "Moi", "Benvenuto!", ""));
        assertEquals(List.of(5, 3, 10, 0), LengthsOfStrings.lengths(source));
        assertEquals(List.of("Hallo", "Moi", "Benvenuto!", ""), source);
    }

    @Test
    void returnsAFreshEmptyList() {
        var source = new ArrayList<String>();
        var result = LengthsOfStrings.lengths(source);
        assertEquals(List.of(), result);
        assertNotSame(source, result);
        result.add(1);
    }
}
