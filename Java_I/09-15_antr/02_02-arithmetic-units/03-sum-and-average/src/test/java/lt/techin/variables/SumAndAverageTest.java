package lt.techin.variables;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceLock;
import lt.techin.testing.ConsoleCheck;
import lt.techin.testing.SourceCheck;
import static org.junit.jupiter.api.Assertions.*;

@ResourceLock("SYSTEM_STREAMS")
class SumAndAverageTest {
    @Test
    void average0() {
        ConsoleCheck.lines(ConsoleCheck.run(new String[]{"8", "3", "3"}, new String[]{"Give the first number:", "Give the second number:", "Give the third number:"}, () -> SumAndAverage.main(new String[0])),
                "Give the first number:",
                "Give the second number:",
                "Give the third number:",
                "The sum of the numbers is 14",
                "~The average is |4.666666666666667");
    }
    @Test
    void average1() {
        ConsoleCheck.lines(ConsoleCheck.run(new String[]{"3", "-1", "2"}, new String[]{"Give the first number:", "Give the second number:", "Give the third number:"}, () -> SumAndAverage.main(new String[0])),
                "Give the first number:",
                "Give the second number:",
                "Give the third number:",
                "The sum of the numbers is 4",
                "~The average is |1.3333333333333333");
    }
    @Test
    void average2() {
        ConsoleCheck.lines(ConsoleCheck.run(new String[]{"8", "2", "3"}, new String[]{"Give the first number:", "Give the second number:", "Give the third number:"}, () -> SumAndAverage.main(new String[0])),
                "Give the first number:",
                "Give the second number:",
                "Give the third number:",
                "The sum of the numbers is 13",
                "~The average is |4.333333333333333");
    }
    @Test
    void average3() {
        ConsoleCheck.lines(ConsoleCheck.run(new String[]{"9", "5", "-1"}, new String[]{"Give the first number:", "Give the second number:", "Give the third number:"}, () -> SumAndAverage.main(new String[0])),
                "Give the first number:",
                "Give the second number:",
                "Give the third number:",
                "The sum of the numbers is 13",
                "~The average is |4.333333333333333");
    }
    @Test
    void average4() {
        ConsoleCheck.lines(ConsoleCheck.run(new String[]{"1", "2", "3"}, new String[]{"Give the first number:", "Give the second number:", "Give the third number:"}, () -> SumAndAverage.main(new String[0])),
                "Give the first number:",
                "Give the second number:",
                "Give the third number:",
                "The sum of the numbers is 6",
                "~The average is |2.0");
    }
    @Test
    void average5() {
        ConsoleCheck.lines(ConsoleCheck.run(new String[]{"0", "0", "1"}, new String[]{"Give the first number:", "Give the second number:", "Give the third number:"}, () -> SumAndAverage.main(new String[0])),
                "Give the first number:",
                "Give the second number:",
                "Give the third number:",
                "The sum of the numbers is 1",
                "~The average is |0.3333333333333333");
    }
    @Test
    void average6() {
        ConsoleCheck.lines(ConsoleCheck.run(new String[]{"-3", "0", "0"}, new String[]{"Give the first number:", "Give the second number:", "Give the third number:"}, () -> SumAndAverage.main(new String[0])),
                "Give the first number:",
                "Give the second number:",
                "Give the third number:",
                "The sum of the numbers is -3",
                "~The average is |-1.0");
    }
    @Test
    void average7() {
        ConsoleCheck.lines(ConsoleCheck.run(new String[]{"0", "0", "0"}, new String[]{"Give the first number:", "Give the second number:", "Give the third number:"}, () -> SumAndAverage.main(new String[0])),
                "Give the first number:",
                "Give the second number:",
                "Give the third number:",
                "The sum of the numbers is 0",
                "~The average is |0.0");
    }

    @Test
    void usesRequiredConstructs() throws Exception {
        SourceCheck check = SourceCheck.method("lt.techin.variables.SumAndAverage", "main").straightLine();
        check.local("sum", "int", false);
        check.local("average", "double", false);
        check.calls("*.nextLine", "Integer.parseInt");
        check.dependsOn("average", "sum");
    }
}
