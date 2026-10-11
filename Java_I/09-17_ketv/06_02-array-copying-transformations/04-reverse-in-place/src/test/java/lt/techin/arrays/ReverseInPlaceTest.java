package lt.techin.arrays;

import com.sun.source.tree.Tree;
import java.util.Arrays;
import lt.techin.testing.ConsoleCheck;
import lt.techin.testing.SourceCheck;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;

@Timeout(2)
class ReverseInPlaceTest {
    @Test void reversesOddAndEvenArrays() {
        int[] odd = {1, 2, 3, 4, 5};
        ReverseInPlace.reverseInPlace(odd);
        assertArrayEquals(new int[]{5, 4, 3, 2, 1}, odd);
        int[] even = {1, 2, 3, 4};
        ReverseInPlace.reverseInPlace(even);
        assertArrayEquals(new int[]{4, 3, 2, 1}, even);
    }

    @Test void supportsSingletonAndEmptyArrays() {
        int[] singleton = {8};
        ReverseInPlace.reverseInPlace(singleton);
        assertArrayEquals(new int[]{8}, singleton);
        int[] empty = {};
        ReverseInPlace.reverseInPlace(empty);
        assertArrayEquals(new int[]{}, empty);
    }

    @Test void doesNotCreateAnotherArray() throws Exception {
        SourceCheck.method("lt.techin.arrays.ReverseInPlace", "reverseInPlace", 1)
                .forbid(Tree.Kind.NEW_ARRAY, "Reverse the supplied array without creating another array.");
    }
}
