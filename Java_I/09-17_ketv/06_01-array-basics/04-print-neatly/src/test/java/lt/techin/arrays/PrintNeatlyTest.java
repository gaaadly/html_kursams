package lt.techin.arrays;

import com.sun.source.tree.Tree;
import java.util.Arrays;
import lt.techin.testing.ConsoleCheck;
import lt.techin.testing.SourceCheck;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;

@Timeout(2)
class PrintNeatlyTest {
    @Test void printsSeveralValuesWithoutTrailingSeparator() {
        assertEquals("5, 1, 3, 4, 2\n",
                ConsoleCheck.run(() -> PrintNeatly.printNeatly(new int[]{5, 1, 3, 4, 2})));
        assertEquals("-2, 0, 11\n",
                ConsoleCheck.run(() -> PrintNeatly.printNeatly(new int[]{-2, 0, 11})));
    }

    @Test void printsSingletonAndEmptyArrays() {
        assertEquals("8\n", ConsoleCheck.run(() -> PrintNeatly.printNeatly(new int[]{8})));
        assertEquals("\n", ConsoleCheck.run(() -> PrintNeatly.printNeatly(new int[]{})));
    }
}
