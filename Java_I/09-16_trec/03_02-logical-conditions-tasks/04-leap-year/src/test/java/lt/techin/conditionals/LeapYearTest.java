package lt.techin.conditionals;

import com.sun.source.tree.Tree;
import lt.techin.testing.ConsoleCheck;
import lt.techin.testing.SourceCheck;
import org.junit.jupiter.api.Test;

class LeapYearTest {
    private void check(int year, boolean leap) {
        String out = ConsoleCheck.run(new String[]{"" + year}, new String[]{"Give a year:"},
                () -> LeapYear.main(new String[0]));
        ConsoleCheck.lines(out, "Give a year:", leap ? "The year is a leap year." : "The year is not a leap year.");
    }

    @Test void ordinaryYears() { check(2011, false); check(2012, true); }
    @Test void centuries() { check(1800, false); check(1900, false); check(2000, true); }
    @Test void nearbyBoundaries() { check(1999, false); check(2004, true); check(2100, false); }

    @Test void combinesTheRules() throws Exception {
        SourceCheck.method("lt.techin.conditionals.LeapYear", "main")
                .requireKinds(Tree.Kind.CONDITIONAL_OR, Tree.Kind.CONDITIONAL_AND, Tree.Kind.REMAINDER)
                .parenthesized()
                .bracedIfsAtLeast(1)
                .hasElse();
    }
}
