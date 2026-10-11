package lt.techin.conditionals;

import com.sun.source.tree.Tree;
import lt.techin.testing.SourceCheck;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TextComparisonTest {
    @Test void equalDistinctObjects() { assertTrue(TextComparison.sameText(new String("Java"), new String("Java"))); }
    @Test void differentText() { assertFalse(TextComparison.sameText("Java", "java")); }
    @Test void nullFirstIsSafe() { assertDoesNotThrow(() -> assertFalse(TextComparison.sameText(null, "Java"))); }
    @Test void nullSecondIsDifferentFromText() { assertFalse(TextComparison.sameText("Java", null)); }
    @Test void bothNullAreNotText() { assertFalse(TextComparison.sameText(null, null)); }

    @Test void usesShortCircuitAndContentComparison() throws Exception {
        SourceCheck.method("lt.techin.conditionals.TextComparison", "sameText")
                .requireKinds(Tree.Kind.NOT_EQUAL_TO, Tree.Kind.CONDITIONAL_AND)
                .forbidKinds(Tree.Kind.EQUAL_TO)
                .callEnding(".equals");
    }
}
