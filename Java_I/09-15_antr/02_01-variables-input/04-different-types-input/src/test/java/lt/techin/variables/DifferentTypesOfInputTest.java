package lt.techin.variables;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceLock;
import lt.techin.testing.ConsoleCheck;
import lt.techin.testing.SourceCheck;
import static org.junit.jupiter.api.Assertions.*;

@ResourceLock("SYSTEM_STREAMS")
class DifferentTypesOfInputTest {
    @Test
    void mixed0() {
        ConsoleCheck.lines(ConsoleCheck.run(new String[]{"HelloWorld", "11", "4.2", "true"}, new String[]{"Give project name:", "Give source line count:", "Give execution time in milliseconds:", "Is compilation successful:"}, () -> DifferentTypesOfInput.main(new String[0])),
                "Give project name:",
                "Give source line count:",
                "Give execution time in milliseconds:",
                "Is compilation successful:",
                "Project name: HelloWorld",
                "Source line count: 11",
                "~Execution time (ms): |4.2",
                "Compilation successful: true");
    }
    @Test
    void mixed1() {
        ConsoleCheck.lines(ConsoleCheck.run(new String[]{"Inventory Manager", "-4", "320.1", "false"}, new String[]{"Give project name:", "Give source line count:", "Give execution time in milliseconds:", "Is compilation successful:"}, () -> DifferentTypesOfInput.main(new String[0])),
                "Give project name:",
                "Give source line count:",
                "Give execution time in milliseconds:",
                "Is compilation successful:",
                "Project name: Inventory Manager",
                "Source line count: -4",
                "~Execution time (ms): |320.1",
                "Compilation successful: false");
    }
    @Test
    void mixed2() {
        ConsoleCheck.lines(ConsoleCheck.run(new String[]{"Java Basics", "0", "0.0", "true"}, new String[]{"Give project name:", "Give source line count:", "Give execution time in milliseconds:", "Is compilation successful:"}, () -> DifferentTypesOfInput.main(new String[0])),
                "Give project name:",
                "Give source line count:",
                "Give execution time in milliseconds:",
                "Is compilation successful:",
                "Project name: Java Basics",
                "Source line count: 0",
                "~Execution time (ms): |0.0",
                "Compilation successful: true");
    }
    @Test
    void rejectsInvalidInteger() {
        assertThrows(NumberFormatException.class, () -> ConsoleCheck.run(new String[]{"Demo", "labas"}, new String[]{"Give project name:", "Give source line count:"}, () -> DifferentTypesOfInput.main(new String[0])));
    }
    @Test
    void rejectsInvalidDouble() {
        assertThrows(NumberFormatException.class, () -> ConsoleCheck.run(new String[]{"Demo", "7", "labas"}, new String[]{"Give project name:", "Give source line count:", "Give execution time in milliseconds:"}, () -> DifferentTypesOfInput.main(new String[0])));
    }

    @Test
    void usesRequiredConstructs() throws Exception {
        SourceCheck check = SourceCheck.method("lt.techin.variables.DifferentTypesOfInput", "main").straightLine();
        check.local("projectName", "String", false);
        check.local("sourceLines", "int", false);
        check.local("executionTimeMillis", "double", false);
        check.local("compilationSuccessful", "boolean", false);
        check.calls("*.nextLine", "Integer.parseInt", "Double.parseDouble", "Boolean.parseBoolean");
    }
}
