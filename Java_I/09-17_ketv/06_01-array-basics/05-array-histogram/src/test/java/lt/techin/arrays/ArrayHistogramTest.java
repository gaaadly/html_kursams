package lt.techin.arrays;

import com.sun.source.tree.Tree;
import java.util.Arrays;
import lt.techin.testing.ConsoleCheck;
import lt.techin.testing.SourceCheck;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;

@Timeout(2)
class ArrayHistogramTest {
    @Test void printsOneRowForEveryValue() {
        assertEquals("*****\n*\n***\n",
                ConsoleCheck.run(() -> ArrayHistogram.printHistogram(new int[]{5, 1, 3})));
        assertEquals("\n**\n",
                ConsoleCheck.run(() -> ArrayHistogram.printHistogram(new int[]{0, 2})));
    }

    @Test void printsNothingForAnEmptyArray() {
        assertEquals("", ConsoleCheck.run(() -> ArrayHistogram.printHistogram(new int[]{})));
    }

    @Test void usesForEachForTheOuterTraversal() throws Exception {
        SourceCheck.method("lt.techin.arrays.ArrayHistogram", "printHistogram", 1)
                .require(Tree.Kind.ENHANCED_FOR_LOOP, 1,
                        "Use a for-each loop to visit the array values.");
    }
}
