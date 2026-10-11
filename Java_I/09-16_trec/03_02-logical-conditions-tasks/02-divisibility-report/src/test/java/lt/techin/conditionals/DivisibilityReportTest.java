package lt.techin.conditionals;

import com.sun.source.tree.Tree;
import lt.techin.testing.ConsoleCheck;
import lt.techin.testing.SourceCheck;
import org.junit.jupiter.api.Test;

class DivisibilityReportTest {
    private void check(int number, boolean both, boolean either, boolean exactlyOne) {
        String out = ConsoleCheck.run(new String[]{"" + number}, new String[]{"Enter an integer:"},
                () -> DivisibilityReport.main(new String[0]));
        ConsoleCheck.lines(out, "Enter an integer:", "Divisible by 4 and 5: " + both,
                "Divisible by 4 or 5: " + either,
                "Divisible by 4 or 5 but not both: " + exactlyOne);
    }

    @Test void neither() { check(7, false, false, false); }
    @Test void onlyFour() { check(8, false, true, true); }
    @Test void onlyFive() { check(10, false, true, true); }
    @Test void both() { check(20, true, true, false); }
    @Test void zeroIsDivisibleByBoth() { check(0, true, true, false); }

    @Test void usesEachLogicalOperator() throws Exception {
        SourceCheck.method("lt.techin.conditionals.DivisibilityReport", "main")
                .requireKinds(Tree.Kind.CONDITIONAL_AND, Tree.Kind.CONDITIONAL_OR, Tree.Kind.XOR);
    }
}
