package lt.techin.arrays;

import com.sun.source.tree.Tree;
import java.util.Arrays;
import lt.techin.testing.ConsoleCheck;
import lt.techin.testing.SourceCheck;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;

@Timeout(2)
class ConstructAndInspectTest {
    @Test void createsEmptyAndSingletonArrays() {
        assertArrayEquals(new int[0], ConstructAndInspect.createWithEdges(0, 7, 9));
        assertArrayEquals(new int[]{7}, ConstructAndInspect.createWithEdges(1, 7, 9));
    }

    @Test void createsLongerArrayWithDefaultMiddleValues() {
        assertArrayEquals(new int[]{7, 0, 0, 0, 9},
                ConstructAndInspect.createWithEdges(5, 7, 9));
        assertArrayEquals(new int[]{-3, 11},
                ConstructAndInspect.createWithEdges(2, -3, 11));
    }

    @Test void returnsFirstAndLastElements() {
        assertEquals(4, ConstructAndInspect.first(new int[]{4, 8, 12}));
        assertEquals(12, ConstructAndInspect.last(new int[]{4, 8, 12}));
        assertEquals(-6, ConstructAndInspect.first(new int[]{-6}));
        assertEquals(-6, ConstructAndInspect.last(new int[]{-6}));
    }

    @Test void createsAnArrayInCreateWithEdges() throws Exception {
        SourceCheck.method("lt.techin.arrays.ConstructAndInspect", "createWithEdges", 3)
                .require(Tree.Kind.NEW_ARRAY, 1, "Create a new array whose length is size.");
    }
}
