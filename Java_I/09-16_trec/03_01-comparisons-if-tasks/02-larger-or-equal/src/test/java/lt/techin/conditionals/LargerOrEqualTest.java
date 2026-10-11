package lt.techin.conditionals;

import com.sun.source.tree.Tree;
import lt.techin.testing.ConsoleCheck;
import lt.techin.testing.SourceCheck;
import org.junit.jupiter.api.Test;

class LargerOrEqualTest {
    private void check(int first, int second, String result) {
        String out = ConsoleCheck.run(new String[]{String.valueOf(first), String.valueOf(second)},
                new String[]{"Give the first number:", "Give the second number:"},
                () -> LargerOrEqual.main(new String[0]));
        ConsoleCheck.lines(out, "Give the first number:", "Give the second number:", result);
    }

    @Test void firstIsLarger() { check(5, 3, "Larger number: 5"); }
    @Test void secondIsLarger() { check(-4, 2, "Larger number: 2"); }
    @Test void positiveEquals() { check(7, 7, "The numbers are equal."); }
    @Test void negativeEquals() { check(-3, -3, "The numbers are equal."); }

    @Test void usesACompleteBranchChain() throws Exception {
        SourceCheck.method("lt.techin.conditionals.LargerOrEqual", "main")
                .requireKinds(Tree.Kind.GREATER_THAN)
                .bracedIfsAtLeast(2)
                .hasElse();
    }
}
