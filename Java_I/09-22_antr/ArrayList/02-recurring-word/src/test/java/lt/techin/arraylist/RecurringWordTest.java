package lt.techin.arraylist;

import lt.techin.testing.ConsoleTestSupport;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Timeout(2)
class RecurringWordTest {
    @Test
    void reportsTheFirstRepeatedWord() {
        String output = ConsoleTestSupport.run("carrot\ncelery\nturnip\ncelery\n",
                () -> RecurringWord.main(new String[0]));
        assertTrue(output.contains("You gave the word celery twice"));
    }

    @Test
    void alsoDetectsAnImmediateRepetition() {
        String output = ConsoleTestSupport.run("Java\nJava\n",
                () -> RecurringWord.main(new String[0]));
        assertTrue(output.contains("You gave the word Java twice"));
    }
}
