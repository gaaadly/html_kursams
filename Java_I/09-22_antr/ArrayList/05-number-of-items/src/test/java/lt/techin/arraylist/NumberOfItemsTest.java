package lt.techin.arraylist;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberOfItemsTest {
    @Test
    void countsEmptySingletonAndLargerLists() {
        assertEquals(0, NumberOfItems.countItems(new ArrayList<>()));
        assertEquals(1, NumberOfItems.countItems(new ArrayList<>(List.of("A"))));
        assertEquals(4, NumberOfItems.countItems(
                new ArrayList<>(List.of("A", "B", "C", "D"))));
    }

    @Test
    void doesNotModifyTheList() {
        var words = new ArrayList<>(List.of("A", "B", "C"));
        NumberOfItems.countItems(words);
        assertEquals(List.of("A", "B", "C"), words);
    }
}
