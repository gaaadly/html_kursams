package lt.techin.arrays;

import com.sun.source.tree.Tree;
import java.util.Arrays;
import lt.techin.testing.ConsoleCheck;
import lt.techin.testing.SourceCheck;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;

@Timeout(2)
class ResizeByCopyingTest {
    @Test void removesFirstMiddleLastAndOnlyElements() {
        assertArrayEquals(new int[]{2, 3}, ResizeByCopying.removeAt(new int[]{1, 2, 3}, 0));
        assertArrayEquals(new int[]{1, 3}, ResizeByCopying.removeAt(new int[]{1, 2, 3}, 1));
        assertArrayEquals(new int[]{1, 2}, ResizeByCopying.removeAt(new int[]{1, 2, 3}, 2));
        assertArrayEquals(new int[]{}, ResizeByCopying.removeAt(new int[]{9}, 0));
    }

    @Test void insertsAtStartMiddleEndAndIntoEmptyArray() {
        assertArrayEquals(new int[]{9, 1, 2}, ResizeByCopying.insertAt(new int[]{1, 2}, 0, 9));
        assertArrayEquals(new int[]{1, 9, 2}, ResizeByCopying.insertAt(new int[]{1, 2}, 1, 9));
        assertArrayEquals(new int[]{1, 2, 9}, ResizeByCopying.insertAt(new int[]{1, 2}, 2, 9));
        assertArrayEquals(new int[]{9}, ResizeByCopying.insertAt(new int[]{}, 0, 9));
    }

    @Test void rejectsInvalidPositions() {
        assertNull(ResizeByCopying.removeAt(new int[]{1, 2}, -1));
        assertNull(ResizeByCopying.removeAt(new int[]{1, 2}, 2));
        assertNull(ResizeByCopying.insertAt(new int[]{1, 2}, -1, 9));
        assertNull(ResizeByCopying.insertAt(new int[]{1, 2}, 3, 9));
    }

    @Test void leavesSourcesUnchangedAndReturnsIndependentArrays() {
        int[] source = {1, 2, 3};
        int[] removed = ResizeByCopying.removeAt(source, 1);
        int[] inserted = ResizeByCopying.insertAt(source, 1, 9);
        assertArrayEquals(new int[]{1, 2, 3}, source);
        assertNotSame(source, removed);
        assertNotSame(source, inserted);
    }
}
