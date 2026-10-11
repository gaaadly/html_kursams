package lt.techin.conditionals;

import com.sun.source.tree.Tree;
import lt.techin.testing.ConsoleCheck;
import lt.techin.testing.SourceCheck;
import org.junit.jupiter.api.Test;

class ThreeNumberMaximumTest {
    private void check(int a, int b, int c, int maximum) {
        String out = ConsoleCheck.run(new String[]{String.valueOf(a), String.valueOf(b), String.valueOf(c)},
                new String[]{"Give the first number:", "Give the second number:", "Give the third number:"},
                () -> ThreeNumberMaximum.main(new String[0]));
        ConsoleCheck.lines(out, "Give the first number:", "Give the second number:", "Give the third number:", "Maximum: " + maximum);
    }

    @Test void eachPositionCanWin() { check(9, 4, 2, 9); check(4, 9, 2, 9); check(4, 2, 9, 9); }
    @Test void equalAndNegativeValues() { check(7, 7, 7, 7); check(-4, -9, -2, -2); }

    @Test void usesTwoIndependentChecks() throws Exception {
        SourceCheck.method("lt.techin.conditionals.ThreeNumberMaximum", "main")
                .requireKinds(Tree.Kind.GREATER_THAN)
                .bracedIfsAtLeast(2)
                .independentTopLevelIfs(2)
                ;
    }
}
