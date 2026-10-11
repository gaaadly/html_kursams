package lt.techin.loops;

import com.sun.source.tree.Tree;
import lt.techin.testing.ConsoleCheck;
import lt.techin.testing.SourceCheck;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

@Timeout(2)
class UntilFourTest {
    @Test void stopsAfterFirstRead() {
        ConsoleCheck.output("4\n", "Give a number:\n", () -> UntilFour.main(new String[0]));
    }
    @Test void repeatsUntilFour() {
        ConsoleCheck.output("5\n-2\n4\n", "Give a number:\nGive a number:\nGive a number:\n",
                () -> UntilFour.main(new String[0]));
    }
    @Test void usesDoWhile() throws Exception {
        SourceCheck.main("lt.techin.loops.UntilFour")
                .require(Tree.Kind.DO_WHILE_LOOP)
                .forbid(Tree.Kind.WHILE_LOOP, Tree.Kind.FOR_LOOP, Tree.Kind.LABELED_STATEMENT);
    }
}
