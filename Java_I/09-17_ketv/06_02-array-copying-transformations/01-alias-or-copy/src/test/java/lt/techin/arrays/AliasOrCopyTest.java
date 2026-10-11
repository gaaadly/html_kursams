package lt.techin.arrays;

import com.sun.source.tree.Tree;
import java.util.Arrays;
import lt.techin.testing.ConsoleCheck;
import lt.techin.testing.SourceCheck;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;

@Timeout(2)
class AliasOrCopyTest {
    @Test void aliasReturnsTheSameArray() {
        int[] source = {1, 2, 3};
        int[] alias = AliasOrCopy.alias(source);
        assertSame(source, alias);
        alias[0] = 99;
        assertEquals(99, source[0]);
    }

    @Test void allThreeCopiesHaveIndependentIdentityAndEqualContents() {
        int[] source = {1, 2, 3};
        int[][] copies = {
                AliasOrCopy.manualCopy(source),
                AliasOrCopy.copyWithArraycopy(source),
                AliasOrCopy.copyWithCopyOf(source)
        };
        for (int[] copy : copies) {
            assertArrayEquals(source, copy);
            assertNotSame(source, copy);
            copy[0] = 99;
            assertEquals(1, source[0], "Changing a copy must not change its source.");
        }
    }

    @Test void copiesEmptyArraysIndependently() {
        int[] source = {};
        for (int[] copy : new int[][]{
                AliasOrCopy.manualCopy(source),
                AliasOrCopy.copyWithArraycopy(source),
                AliasOrCopy.copyWithCopyOf(source)}) {
            assertArrayEquals(source, copy);
            assertNotSame(source, copy);
        }
    }

    @Test void describesArrayWithBrackets() {
        assertEquals("[1, 2, 3]", AliasOrCopy.describe(new int[]{1, 2, 3}));
        assertEquals("[]", AliasOrCopy.describe(new int[]{}));
    }

    @Test void usesTheThreeRequiredCopyingApproaches() throws Exception {
        SourceCheck.method("lt.techin.arrays.AliasOrCopy", "manualCopy", 1)
                .require(Tree.Kind.NEW_ARRAY, 1, "Create a new array in manualCopy.")
                .require(Tree.Kind.FOR_LOOP, 1, "Use an indexed for loop in manualCopy.");
        SourceCheck.method("lt.techin.arrays.AliasOrCopy", "copyWithArraycopy", 1)
                .requireCall("arraycopy");
        SourceCheck.method("lt.techin.arrays.AliasOrCopy", "copyWithCopyOf", 1)
                .requireCall("copyOf");
        SourceCheck.method("lt.techin.arrays.AliasOrCopy", "describe", 1)
                .requireCall("toString");
    }
}
