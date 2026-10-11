package lt.techin.arraylist;

import lt.techin.testing.ConsoleTestSupport;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Timeout(2)
class WordsInAlphabeticalOrderTest {
    @Test
    void printsNaturalStringOrder() {
        String output = ConsoleTestSupport.run("Mozart\nSchubert\nBach\nLiszt\n\n",
                () -> WordsInAlphabeticalOrder.main(new String[0]));
        assertEquals("Bach\nLiszt\nMozart\nSchubert\n",
                ConsoleTestSupport.after(output, "You typed the following words:"));
    }

    @Test
    void keepsDuplicates() {
        String output = ConsoleTestSupport.run("Tea\nCoffee\nTea\n\n",
                () -> WordsInAlphabeticalOrder.main(new String[0]));
        assertEquals("Coffee\nTea\nTea\n",
                ConsoleTestSupport.after(output, "You typed the following words:"));
    }
}
