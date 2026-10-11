package lt.techin.loops;

import com.sun.source.tree.Tree;
import lt.techin.testing.ConsoleCheck;
import lt.techin.testing.SourceCheck;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

@Timeout(2)
class HollowRectangleTest {
    @Test void printsHollowRectangle() {
        ConsoleCheck.output("4\n6\n", "Rows:\nColumns:\n######\n#    #\n#    #\n######\n",
                () -> HollowRectangle.main(new String[0]));
    }
    @Test void handlesMinimumDimensions() {
        ConsoleCheck.output("2\n3\n", "Rows:\nColumns:\n###\n###\n",
                () -> HollowRectangle.main(new String[0]));
    }
    @Test void keepsRowsAndColumnsInTheirRoles() {
        ConsoleCheck.output("3\n2\n", "Rows:\nColumns:\n##\n##\n##\n",
                () -> HollowRectangle.main(new String[0]));
    }
    @Test void usesNestedForLoopsAndIf() throws Exception {
        SourceCheck.main("lt.techin.loops.HollowRectangle")
                .nestedForDepthAtLeast(2).require(Tree.Kind.IF)
                .forbid(Tree.Kind.WHILE_LOOP, Tree.Kind.DO_WHILE_LOOP, Tree.Kind.LABELED_STATEMENT);
    }
}
