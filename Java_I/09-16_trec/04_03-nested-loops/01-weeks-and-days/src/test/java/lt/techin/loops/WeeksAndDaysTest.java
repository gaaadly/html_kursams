package lt.techin.loops;

import com.sun.source.tree.Tree;
import lt.techin.testing.ConsoleCheck;
import lt.techin.testing.SourceCheck;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

@Timeout(2)
class WeeksAndDaysTest {
    @Test void restartsDaysForEveryWeek() {
        ConsoleCheck.output("2\n3\n",
                "Weeks:\nDays per week:\nWeek 1\n  Day 1\n  Day 2\n  Day 3\nWeek 2\n  Day 1\n  Day 2\n  Day 3\n",
                () -> WeeksAndDays.main(new String[0]));
    }
    @Test void handlesSingleCell() {
        ConsoleCheck.output("1\n1\n", "Weeks:\nDays per week:\nWeek 1\n  Day 1\n",
                () -> WeeksAndDays.main(new String[0]));
    }
    @Test void usesNestedForLoops() throws Exception {
        SourceCheck.main("lt.techin.loops.WeeksAndDays")
                .nestedForDepthAtLeast(2).forbid(Tree.Kind.WHILE_LOOP, Tree.Kind.DO_WHILE_LOOP, Tree.Kind.LABELED_STATEMENT);
    }
}
