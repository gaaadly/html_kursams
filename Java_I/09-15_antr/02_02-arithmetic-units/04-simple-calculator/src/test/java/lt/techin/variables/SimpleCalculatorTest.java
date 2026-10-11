package lt.techin.variables;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceLock;
import lt.techin.testing.ConsoleCheck;
import lt.techin.testing.SourceCheck;
import static org.junit.jupiter.api.Assertions.*;

@ResourceLock("SYSTEM_STREAMS")
class SimpleCalculatorTest {
    @Test
    void equations0() {
        ConsoleCheck.lines(ConsoleCheck.run(new String[]{"8", "2"}, new String[]{"Give the first number:", "Give the second number:"}, () -> SimpleCalculator.main(new String[0])),
                "Give the first number:",
                "Give the second number:",
                "8 + 2 = 10",
                "8 - 2 = 6",
                "8 * 2 = 16",
                "~8 / 2 = |4.0");
    }
    @Test
    void equations1() {
        ConsoleCheck.lines(ConsoleCheck.run(new String[]{"9", "5"}, new String[]{"Give the first number:", "Give the second number:"}, () -> SimpleCalculator.main(new String[0])),
                "Give the first number:",
                "Give the second number:",
                "9 + 5 = 14",
                "9 - 5 = 4",
                "9 * 5 = 45",
                "~9 / 5 = |1.8");
    }
    @Test
    void equations2() {
        ConsoleCheck.lines(ConsoleCheck.run(new String[]{"9", "2"}, new String[]{"Give the first number:", "Give the second number:"}, () -> SimpleCalculator.main(new String[0])),
                "Give the first number:",
                "Give the second number:",
                "9 + 2 = 11",
                "9 - 2 = 7",
                "9 * 2 = 18",
                "~9 / 2 = |4.5");
    }
    @Test
    void equations3() {
        ConsoleCheck.lines(ConsoleCheck.run(new String[]{"2", "8"}, new String[]{"Give the first number:", "Give the second number:"}, () -> SimpleCalculator.main(new String[0])),
                "Give the first number:",
                "Give the second number:",
                "2 + 8 = 10",
                "2 - 8 = -6",
                "2 * 8 = 16",
                "~2 / 8 = |0.25");
    }
    @Test
    void equations4() {
        ConsoleCheck.lines(ConsoleCheck.run(new String[]{"277", "111"}, new String[]{"Give the first number:", "Give the second number:"}, () -> SimpleCalculator.main(new String[0])),
                "Give the first number:",
                "Give the second number:",
                "277 + 111 = 388",
                "277 - 111 = 166",
                "277 * 111 = 30747",
                "~277 / 111 = |2.4954954954954953");
    }
    @Test
    void equations5() {
        ConsoleCheck.lines(ConsoleCheck.run(new String[]{"0", "3"}, new String[]{"Give the first number:", "Give the second number:"}, () -> SimpleCalculator.main(new String[0])),
                "Give the first number:",
                "Give the second number:",
                "0 + 3 = 3",
                "0 - 3 = -3",
                "0 * 3 = 0",
                "~0 / 3 = |0.0");
    }
    @Test
    void equations6() {
        ConsoleCheck.lines(ConsoleCheck.run(new String[]{"-9", "2"}, new String[]{"Give the first number:", "Give the second number:"}, () -> SimpleCalculator.main(new String[0])),
                "Give the first number:",
                "Give the second number:",
                "-9 + 2 = -7",
                "-9 - 2 = -11",
                "-9 * 2 = -18",
                "~-9 / 2 = |-4.5");
    }
    @Test
    void equations7() {
        ConsoleCheck.lines(ConsoleCheck.run(new String[]{"9", "-2"}, new String[]{"Give the first number:", "Give the second number:"}, () -> SimpleCalculator.main(new String[0])),
                "Give the first number:",
                "Give the second number:",
                "9 + -2 = 7",
                "9 - -2 = 11",
                "9 * -2 = -18",
                "~9 / -2 = |-4.5");
    }

    @Test
    void usesRequiredConstructs() throws Exception {
        SourceCheck check = SourceCheck.method("lt.techin.variables.SimpleCalculator", "main").straightLine();
        check.local("first", "int", false);
        check.local("second", "int", false);
        check.calls("*.nextLine", "Integer.parseInt");
    }
}
