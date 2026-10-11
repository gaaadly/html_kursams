package lt.techin.arraylist;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CombiningArrayListsTest {
    @Test
    void appendsAllValuesInOrderIncludingDuplicates() {
        var first = new ArrayList<>(List.of(4, 3));
        var second = new ArrayList<>(List.of(5, 10, 5, 7));
        CombiningArrayLists.combine(first, second);
        assertEquals(List.of(4, 3, 5, 10, 5, 7), first);
        assertEquals(List.of(5, 10, 5, 7), second);
    }

    @Test
    void handlesEmptyLists() {
        var first = new ArrayList<>(List.of(1, 2));
        CombiningArrayLists.combine(first, new ArrayList<>());
        assertEquals(List.of(1, 2), first);
        var empty = new ArrayList<Integer>();
        CombiningArrayLists.combine(empty, new ArrayList<>(List.of(3)));
        assertEquals(List.of(3), empty);
    }
}
