package lt.techin.arraylist;

import lt.techin.testing.ConsoleTestSupport;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Timeout(2)
class IndexOfTest {
    @Test
    void printsEveryMatchingIndex() {
        String output = ConsoleTestSupport.run("72\n2\n8\n8\n11\n-1\n8\n",
                () -> IndexOf.main(new String[0]));
        assertTrue(output.contains("Search for?"));
        assertTrue(output.contains("8 is at index 2"));
        assertTrue(output.contains("8 is at index 3"));
        assertEquals(2, output.split("is at index", -1).length - 1);
    }

    @Test
    void printsNoMatchLineWhenTheNumberIsAbsent() {
        String output = ConsoleTestSupport.run("3\n5\n-1\n7\n",
                () -> IndexOf.main(new String[0]));
        assertTrue(output.contains("Search for?"));
        assertEquals(0, output.split("is at index", -1).length - 1);
    }
}
