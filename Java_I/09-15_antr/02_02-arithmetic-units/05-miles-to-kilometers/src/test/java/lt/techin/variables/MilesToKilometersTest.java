package lt.techin.variables;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceLock;
import lt.techin.testing.ConsoleCheck;
import lt.techin.testing.SourceCheck;
import static org.junit.jupiter.api.Assertions.*;

@ResourceLock("SYSTEM_STREAMS")
class MilesToKilometersTest {
    @Test
    void miles0() {
        ConsoleCheck.lines(ConsoleCheck.run(new String[]{"0"}, new String[]{"Enter miles:"}, () -> MilesToKilometers.main(new String[0])),
                "Enter miles:",
                "~Kilometers: |0.0");
    }
    @Test
    void miles1() {
        ConsoleCheck.lines(ConsoleCheck.run(new String[]{"1"}, new String[]{"Enter miles:"}, () -> MilesToKilometers.main(new String[0])),
                "Enter miles:",
                "~Kilometers: |1.6");
    }
    @Test
    void miles2() {
        ConsoleCheck.lines(ConsoleCheck.run(new String[]{"2.5"}, new String[]{"Enter miles:"}, () -> MilesToKilometers.main(new String[0])),
                "Enter miles:",
                "~Kilometers: |4.0");
    }
    @Test
    void miles3() {
        ConsoleCheck.lines(ConsoleCheck.run(new String[]{"96"}, new String[]{"Enter miles:"}, () -> MilesToKilometers.main(new String[0])),
                "Enter miles:",
                "~Kilometers: |153.60000000000002");
    }

    @Test
    void usesRequiredConstructs() throws Exception {
        SourceCheck check = SourceCheck.method("lt.techin.variables.MilesToKilometers", "main").straightLine();
        check.local("miles", "double", false);
        check.local("KILOMETERS_PER_MILE", "double", true);
        check.calls("*.nextLine", "Double.parseDouble");
    }
}
