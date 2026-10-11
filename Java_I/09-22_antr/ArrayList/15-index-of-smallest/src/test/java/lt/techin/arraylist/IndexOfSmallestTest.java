package lt.techin.arraylist;

import lt.techin.testing.ConsoleTestSupport;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Timeout(2)
class IndexOfSmallestTest {
    @Test
    void printsTheSmallestValueAndEveryMatchingIndex() {
        String output = ConsoleTestSupport.run("72\n44\n8\n8\n11\n9999\n",
                () -> IndexOfSmallest.main(new String[0]));
        assertTrue(output.contains("Smallest number: 8"));
        assertTrue(output.contains("Found at index: 2"));
        assertTrue(output.contains("Found at index: 3"));
        assertEquals(2, output.split("Found at index:", -1).length - 1);
    }

    @Test
    void handlesNegativeValuesAndASingleMinimum() {
        String output = ConsoleTestSupport.run("51\n-11\n-140\n-18\n9999\n",
                () -> IndexOfSmallest.main(new String[0]));
        assertTrue(output.contains("Smallest number: -140"));
        assertTrue(output.contains("Found at index: 2"));
        assertEquals(1, output.split("Found at index:", -1).length - 1);
    }
}
