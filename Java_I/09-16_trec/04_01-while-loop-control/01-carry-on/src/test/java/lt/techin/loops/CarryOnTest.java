package lt.techin.loops;

import com.sun.source.tree.Tree;
import lt.techin.testing.ConsoleCheck;
import lt.techin.testing.SourceCheck;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

@Timeout(2)
class CarryOnTest {
    @Test void stopsImmediately() {
        ConsoleCheck.output("no\n", "Shall we carry on?\n", () -> CarryOn.main(new String[0]));
    }
    @Test void ignoresSimilarWordsAndStopsOnExactSentinel() {
        ConsoleCheck.output("nope\nyes\nno\n",
                "Shall we carry on?\nShall we carry on?\nShall we carry on?\n",
                () -> CarryOn.main(new String[0]));
    }
    @Test void usesWhileAndUnlabeledBreak() throws Exception {
        SourceCheck.main("lt.techin.loops.CarryOn")
                .require(Tree.Kind.WHILE_LOOP, Tree.Kind.BREAK)
                .forbid(Tree.Kind.LABELED_STATEMENT);
    }
}
