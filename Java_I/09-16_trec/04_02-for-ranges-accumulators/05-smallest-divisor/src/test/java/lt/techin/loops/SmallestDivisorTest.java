package lt.techin.loops;

import com.sun.source.tree.Tree;
import lt.techin.testing.ConsoleCheck;
import lt.techin.testing.SourceCheck;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

@Timeout(2)
class SmallestDivisorTest {
    private void check(int number, int expected) {
        ConsoleCheck.output(number + "\n", "Give a number:\nSmallest divisor: " + expected + "\n",
                () -> SmallestDivisor.main(new String[0]));
    }
    @Test void findsEvenDivisor() { check(42, 2); }
    @Test void findsLaterDivisor() { check(91, 7); }
    @Test void returnsPrimeItself() { check(97, 97); }
    @Test void handlesSmallestAllowedInput() { check(2, 2); }
    @Test void usesForSearchAndUnlabeledBreak() throws Exception {
        SourceCheck.main("lt.techin.loops.SmallestDivisor")
                .require(Tree.Kind.FOR_LOOP, Tree.Kind.IF, Tree.Kind.BREAK)
                .forbid(Tree.Kind.WHILE_LOOP, Tree.Kind.DO_WHILE_LOOP, Tree.Kind.LABELED_STATEMENT);
    }
}
