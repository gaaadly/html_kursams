package lt.techin.arraylist;

import lt.techin.testing.ConsoleTestSupport;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Timeout(2)
class WordsTest {
    @Test
    void printsWordsInTheOriginalOrder() {
        String output = ConsoleTestSupport.run("Mozart\nSchubert\nBach\n\n",
                () -> Words.main(new String[0]));
        assertTrue(output.contains("You typed the following words:"));
        assertEquals("Mozart\nSchubert\nBach\n",
                ConsoleTestSupport.after(output, "You typed the following words:"));
    }

    @Test
    void handlesAnImmediateEmptyString() {
        String output = ConsoleTestSupport.run("\n", () -> Words.main(new String[0]));
        assertEquals("", ConsoleTestSupport.after(output, "You typed the following words:"));
    }
}
