package lt.techin.loops;

import com.sun.source.tree.Tree;
import lt.techin.testing.ConsoleCheck;
import lt.techin.testing.SourceCheck;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

@Timeout(2)
class InclusiveRangeTest {
    private void check(int start, int end, String expected) {
        ConsoleCheck.output(start + "\n" + end + "\n", expected, () -> InclusiveRange.main(new String[0]));
    }
    @Test void includesBothBounds() { check(-2, 2, "Start:\nEnd:\n-2\n-1\n0\n1\n2\n"); }
    @Test void equalBoundsPrintOnce() { check(7, 7, "Start:\nEnd:\n7\n"); }
    @Test void reversedBoundsPrintNothing() { check(5, 3, "Start:\nEnd:\n"); }
    @Test void usesForWithProgress() throws Exception {
        SourceCheck.main("lt.techin.loops.InclusiveRange")
                .require(Tree.Kind.FOR_LOOP).incrementOrDecrement()
                .forbid(Tree.Kind.WHILE_LOOP, Tree.Kind.DO_WHILE_LOOP, Tree.Kind.LABELED_STATEMENT);
    }
}
