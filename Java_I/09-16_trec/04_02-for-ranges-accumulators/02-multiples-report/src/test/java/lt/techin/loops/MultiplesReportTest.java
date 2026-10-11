package lt.techin.loops;

import com.sun.source.tree.Tree;
import lt.techin.testing.ConsoleCheck;
import lt.techin.testing.SourceCheck;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

@Timeout(2)
class MultiplesReportTest {
    @Test void printsTheCompleteReport() {
        ConsoleCheck.output("", "12 18 24 30 36 42 48 54 60 66 72 78 84 90 96\nCount: 15\nSum: 810\n",
                () -> MultiplesReport.main(new String[0]));
    }
    @Test void usesForIfAndAccumulators() throws Exception {
        SourceCheck.main("lt.techin.loops.MultiplesReport")
                .require(Tree.Kind.FOR_LOOP, Tree.Kind.IF, Tree.Kind.PLUS_ASSIGNMENT)
                .forbid(Tree.Kind.WHILE_LOOP, Tree.Kind.DO_WHILE_LOOP, Tree.Kind.LABELED_STATEMENT);
    }
}
