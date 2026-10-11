package lt.techin.loops;

import com.sun.source.tree.Tree;
import lt.techin.testing.ConsoleCheck;
import lt.techin.testing.SourceCheck;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

@Timeout(2)
class MultiplicationTableTest {
    @Test void printsThreeByThreeTable() {
        ConsoleCheck.output("3\n", "Size:\n1 2 3\n2 4 6\n3 6 9\n",
                () -> MultiplicationTable.main(new String[0]));
    }
    @Test void printsOneCellTable() {
        ConsoleCheck.output("1\n", "Size:\n1\n", () -> MultiplicationTable.main(new String[0]));
    }
    @Test void usesNestedForLoops() throws Exception {
        SourceCheck.main("lt.techin.loops.MultiplicationTable")
                .nestedForDepthAtLeast(2).forbid(Tree.Kind.WHILE_LOOP, Tree.Kind.DO_WHILE_LOOP, Tree.Kind.LABELED_STATEMENT);
    }
}
