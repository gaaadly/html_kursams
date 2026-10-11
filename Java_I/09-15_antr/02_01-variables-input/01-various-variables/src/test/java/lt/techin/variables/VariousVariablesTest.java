package lt.techin.variables;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceLock;
import lt.techin.testing.ConsoleCheck;
import lt.techin.testing.SourceCheck;
import static org.junit.jupiter.api.Assertions.*;

@ResourceLock("SYSTEM_STREAMS")
class VariousVariablesTest {
    @Test
    void printsBothStages() {
        ConsoleCheck.lines(ConsoleCheck.run(new String[]{}, new String[]{}, () -> VariousVariables.main(new String[0])),
                "Bytes:",
                "9000",
                "CPU load:",
                "0.1",
                "Compiler:",
                "javac",
                "",
                "And finally, a summary:",
                "9000",
                "0.1",
                "javac",
                "Modules before: 4",
                "Modules after: 6",
                "Drive letter: C",
                "Compiled: true",
                "Developer: Ada",
                "Path: C:\\Java");
    }

    @Test
    void usesRequiredConstructs() throws Exception {
        SourceCheck check = SourceCheck.method("lt.techin.variables.VariousVariables", "main").straightLine();
        check.local("byteCount", "int", false);
        check.local("cpuLoad", "double", false);
        check.local("compiler", "String", false);
        check.local("modules", "int", false);
        check.local("driveLetter", "char", false);
        check.local("compiled", "boolean", false);
        check.local("developer", "String", false);
        check.uninitialized("modules").assignments("modules", 2);
    }
}
