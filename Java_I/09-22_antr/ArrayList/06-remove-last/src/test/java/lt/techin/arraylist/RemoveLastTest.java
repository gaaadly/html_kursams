package lt.techin.arraylist;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RemoveLastTest {
    @Test
    void doesNothingToAnEmptyList() {
        var words = new ArrayList<String>();
        RemoveLast.removeLast(words);
        assertEquals(List.of(), words);
    }

    @Test
    void removesExactlyTheLastItem() {
        var words = new ArrayList<>(List.of("First", "Second", "Third"));
        RemoveLast.removeLast(words);
        assertEquals(List.of("First", "Second"), words);
    }

    @Test
    void keepsAnEqualEarlierValue() {
        var words = new ArrayList<>(List.of("A", "B", "A"));
        RemoveLast.removeLast(words);
        assertEquals(List.of("A", "B"), words);
    }
}
