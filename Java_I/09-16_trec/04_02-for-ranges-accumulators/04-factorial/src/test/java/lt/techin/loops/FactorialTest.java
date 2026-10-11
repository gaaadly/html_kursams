package lt.techin.loops;

import com.sun.source.tree.Tree;
import lt.techin.testing.ConsoleCheck;
import lt.techin.testing.SourceCheck;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

@Timeout(2)
class FactorialTest {
    private void check(long number, long expected) {
        ConsoleCheck.output(number + "\n", "Give a number:\nFactorial: " + expected + "\n",
                () -> Factorial.main(new String[0]));
    }
    @Test void definesZeroFactorial() { check(0, 1); }
    @Test void definesOneFactorial() { check(1, 1); }
    @Test void calculatesOrdinaryFactorial() { check(7, 5040); }
    @Test void usesLongRange() { check(20, 2432902008176640000L); }
    @Test void usesForAndProductAssignment() throws Exception {
        SourceCheck.main("lt.techin.loops.Factorial")
                .require(Tree.Kind.FOR_LOOP, Tree.Kind.MULTIPLY_ASSIGNMENT)
                .forbid(Tree.Kind.WHILE_LOOP, Tree.Kind.DO_WHILE_LOOP, Tree.Kind.LABELED_STATEMENT);
    }
}
