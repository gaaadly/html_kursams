package lt.techin.arrays;

import com.sun.source.tree.Tree;
import java.util.Arrays;
import lt.techin.testing.ConsoleCheck;
import lt.techin.testing.SourceCheck;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;

@Timeout(2)
class SwapElementsTest {
    @Test void swapsTwoDifferentPositionsInTheOriginalArray() {
        int[] values = {1, 3, 5, 7, 9};
        SwapElements.swap(values, 2, 4);
        assertArrayEquals(new int[]{1, 3, 9, 7, 5}, values);
        SwapElements.swap(values, 0, 1);
        assertArrayEquals(new int[]{3, 1, 9, 7, 5}, values);
    }

    @Test void swappingAPositionWithItselfKeepsTheArray() {
        int[] values = {-2, 4, 8};
        SwapElements.swap(values, 1, 1);
        assertArrayEquals(new int[]{-2, 4, 8}, values);
    }
}
