package lt.techin.arrays;

import com.sun.source.tree.Tree;
import java.util.Arrays;
import lt.techin.testing.ConsoleCheck;
import lt.techin.testing.SourceCheck;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;

@Timeout(2)
class ReversedCopyTest {
    @Test void returnsReversedIndependentCopyWithoutChangingSource() {
        int[] source = {1, 2, 3, 4, 5};
        int[] original = Arrays.copyOf(source, source.length);
        int[] result = ReversedCopy.reversedCopy(source);
        assertArrayEquals(new int[]{5, 4, 3, 2, 1}, result);
        assertArrayEquals(original, source);
        assertNotSame(source, result);
    }

    @Test void supportsEvenSingletonAndEmptyArrays() {
        assertArrayEquals(new int[]{4, 3, 2, 1}, ReversedCopy.reversedCopy(new int[]{1, 2, 3, 4}));
        assertArrayEquals(new int[]{7}, ReversedCopy.reversedCopy(new int[]{7}));
        int[] empty = {};
        int[] result = ReversedCopy.reversedCopy(empty);
        assertArrayEquals(new int[]{}, result);
        assertNotSame(empty, result);
    }
}
