package lt.techin.loops;

import com.sun.source.tree.Tree;
import lt.techin.testing.ConsoleCheck;
import lt.techin.testing.SourceCheck;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

@Timeout(2)
class PositiveSquaresTest {
    @Test void handlesMixedValues() {
        ConsoleCheck.output("5\n-3\n2\n0\n",
                "Give a number:\n25\nGive a number:\nUnsuitable number\nGive a number:\n4\nGive a number:\n",
                () -> PositiveSquares.main(new String[0]));
    }
    @Test void zeroStopsWithoutAResult() {
        ConsoleCheck.output("0\n", "Give a number:\n", () -> PositiveSquares.main(new String[0]));
    }
    @Test void usesTheRequiredLoopControl() throws Exception {
        SourceCheck.main("lt.techin.loops.PositiveSquares")
                .require(Tree.Kind.WHILE_LOOP, Tree.Kind.BREAK, Tree.Kind.CONTINUE)
                .forbid(Tree.Kind.LABELED_STATEMENT);
    }
}
