package lt.techin.arraylist;

import lt.techin.testing.ConsoleTestSupport;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Timeout(2)
class WordsInReverseOrderTest {
    @Test
    void printsTheLastWordFirst() {
        String output = ConsoleTestSupport.run("Mozart\nSchubert\nBach\n\n",
                () -> WordsInReverseOrder.main(new String[0]));
        assertEquals("Bach\nSchubert\nMozart\n",
                ConsoleTestSupport.after(output, "You typed the following words:"));
    }

    @Test
    void preservesDuplicateWords() {
        String output = ConsoleTestSupport.run("A\nB\nA\n\n",
                () -> WordsInReverseOrder.main(new String[0]));
        assertEquals("A\nB\nA\n",
                ConsoleTestSupport.after(output, "You typed the following words:"));
    }
}
