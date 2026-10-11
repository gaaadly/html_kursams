package lt.techin.loops;

import com.sun.source.tree.Tree;
import lt.techin.testing.ConsoleCheck;
import lt.techin.testing.SourceCheck;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

@Timeout(2)
class CoordinateGridTest {
    @Test void printsEveryCoordinateInRowMajorOrder() {
        ConsoleCheck.output("2\n3\n", "Rows:\nColumns:\n(1,1) (1,2) (1,3)\n(2,1) (2,2) (2,3)\n",
                () -> CoordinateGrid.main(new String[0]));
    }
    @Test void distinguishesRowsFromColumns() {
        ConsoleCheck.output("3\n1\n", "Rows:\nColumns:\n(1,1)\n(2,1)\n(3,1)\n",
                () -> CoordinateGrid.main(new String[0]));
    }
    @Test void usesNestedForLoops() throws Exception {
        SourceCheck.main("lt.techin.loops.CoordinateGrid")
                .nestedForDepthAtLeast(2).forbid(Tree.Kind.WHILE_LOOP, Tree.Kind.DO_WHILE_LOOP, Tree.Kind.LABELED_STATEMENT);
    }
}
