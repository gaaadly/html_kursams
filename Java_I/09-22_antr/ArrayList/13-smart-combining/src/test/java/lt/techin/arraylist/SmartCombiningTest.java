package lt.techin.arraylist;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SmartCombiningTest {
    @Test
    void appendsOnlyMissingValuesInEncounterOrder() {
        var first = new ArrayList<>(List.of(4, 3));
        var second = new ArrayList<>(List.of(5, 10, 4, 3, 5, 7));
        SmartCombining.smartCombine(first, second);
        assertEquals(List.of(4, 3, 5, 10, 7), first);
        assertEquals(List.of(5, 10, 4, 3, 5, 7), second);
    }

    @Test
    void keepsDuplicatesThatAlreadyExistInTheFirstList() {
        var first = new ArrayList<>(List.of(1, 1, 2));
        SmartCombining.smartCombine(first, new ArrayList<>(List.of(1, 3, 3)));
        assertEquals(List.of(1, 1, 2, 3), first);
    }
}
