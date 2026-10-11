package lt.techin.variables;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceLock;
import lt.techin.testing.ConsoleCheck;
import lt.techin.testing.SourceCheck;
import static org.junit.jupiter.api.Assertions.*;

@ResourceLock("SYSTEM_STREAMS")
class NumericInputTest {
    @Test
    void parses0() {
        ConsoleCheck.lines(ConsoleCheck.run(new String[]{"8", "3.140"}, new String[]{"Give source line count:", "Give execution time in milliseconds:"}, () -> NumericInput.main(new String[0])),
                "Give source line count:",
                "Give execution time in milliseconds:",
                "Source line count: 8",
                "~Execution time (ms): |3.14");
    }
    @Test
    void parses1() {
        ConsoleCheck.lines(ConsoleCheck.run(new String[]{"300", "2.92"}, new String[]{"Give source line count:", "Give execution time in milliseconds:"}, () -> NumericInput.main(new String[0])),
                "Give source line count:",
                "Give execution time in milliseconds:",
                "Source line count: 300",
                "~Execution time (ms): |2.92");
    }
    @Test
    void parses2() {
        ConsoleCheck.lines(ConsoleCheck.run(new String[]{"-4", "-0.5"}, new String[]{"Give source line count:", "Give execution time in milliseconds:"}, () -> NumericInput.main(new String[0])),
                "Give source line count:",
                "Give execution time in milliseconds:",
                "Source line count: -4",
                "~Execution time (ms): |-0.5");
    }
    @Test
    void parses3() {
        ConsoleCheck.lines(ConsoleCheck.run(new String[]{"0", "0"}, new String[]{"Give source line count:", "Give execution time in milliseconds:"}, () -> NumericInput.main(new String[0])),
                "Give source line count:",
                "Give execution time in milliseconds:",
                "Source line count: 0",
                "~Execution time (ms): |0.0");
    }
    @Test
    void rejectsInvalidInteger() {
        assertThrows(NumberFormatException.class, () -> ConsoleCheck.run(new String[]{"labas"}, new String[]{"Give source line count:"}, () -> NumericInput.main(new String[0])));
    }
    @Test
    void rejectsInvalidDouble() {
        assertThrows(NumberFormatException.class, () -> ConsoleCheck.run(new String[]{"1", "labas"}, new String[]{"Give source line count:", "Give execution time in milliseconds:"}, () -> NumericInput.main(new String[0])));
    }

    @Test
    void usesRequiredConstructs() throws Exception {
        SourceCheck check = SourceCheck.method("lt.techin.variables.NumericInput", "main").straightLine();
        check.local("sourceLines", "int", false);
        check.local("executionTimeMillis", "double", false);
        check.calls("*.nextLine", "Integer.parseInt", "Double.parseDouble");
    }
}
