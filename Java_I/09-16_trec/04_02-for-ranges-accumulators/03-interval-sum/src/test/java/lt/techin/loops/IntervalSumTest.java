package lt.techin.loops;

import com.sun.source.tree.Tree;
import lt.techin.testing.ConsoleCheck;
import lt.techin.testing.SourceCheck;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

@Timeout(2)
class IntervalSumTest {
    private void check(long first, long last, long sum) {
        ConsoleCheck.output(first + "\n" + last + "\n", "First number:\nLast number:\nSum: " + sum + "\n",
                () -> IntervalSum.main(new String[0]));
    }
    @Test void sumsOrdinaryInterval() { check(3, 5, 12); }
    @Test void sumsAcrossZero() { check(-2, 2, 0); }
    @Test void includesEqualEndpoint() { check(7, 7, 7); }
    @Test void usesForAndSumAssignment() throws Exception {
        SourceCheck.main("lt.techin.loops.IntervalSum")
                .require(Tree.Kind.FOR_LOOP, Tree.Kind.PLUS_ASSIGNMENT)
                .forbid(Tree.Kind.WHILE_LOOP, Tree.Kind.DO_WHILE_LOOP, Tree.Kind.LABELED_STATEMENT);
    }
}
