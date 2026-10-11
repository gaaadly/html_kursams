package lt.techin.loops;

import com.sun.source.tree.Tree;
import lt.techin.testing.ConsoleCheck;
import lt.techin.testing.SourceCheck;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

@Timeout(2)
class NumberStreamReportTest {
    @Test void reportsMixedValues() {
        ConsoleCheck.output("5\n2\n-3\n0\n",
                "Give a number:\nGive a number:\nGive a number:\nGive a number:\nNumbers: 3\nSum: 4\nAverage: 1.3333333333333333\nNegative: 1\nMaximum: 5\nPositive average: 3.5\nEven: 1\nOdd: 2\n",
                () -> NumberStreamReport.main(new String[0]));
    }
    @Test void definesTheEmptyReport() {
        ConsoleCheck.output("0\n",
                "Give a number:\nNumbers: 0\nSum: 0\nAverage: cannot calculate\nNegative: 0\nMaximum: no numbers\nPositive average: cannot calculate\nEven: 0\nOdd: 0\n",
                () -> NumberStreamReport.main(new String[0]));
    }
    @Test void handlesAllNegativeEvenValues() {
        ConsoleCheck.output("-2\n-4\n0\n",
                "Give a number:\nGive a number:\nGive a number:\nNumbers: 2\nSum: -6\nAverage: -3.0\nNegative: 2\nMaximum: -2\nPositive average: cannot calculate\nEven: 2\nOdd: 0\n",
                () -> NumberStreamReport.main(new String[0]));
    }
    @Test void usesWhileAndBreak() throws Exception {
        SourceCheck.main("lt.techin.loops.NumberStreamReport")
                .require(Tree.Kind.WHILE_LOOP, Tree.Kind.BREAK, Tree.Kind.PLUS_ASSIGNMENT)
                .forbid(Tree.Kind.LABELED_STATEMENT);
    }
}
