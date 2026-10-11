package lt.techin.variables;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceLock;
import lt.techin.testing.ConsoleCheck;
import lt.techin.testing.SourceCheck;
import static org.junit.jupiter.api.Assertions.*;

@ResourceLock("SYSTEM_STREAMS")
class NumberOfYearsTest {
    @Test
    void minutes0() {
        ConsoleCheck.lines(ConsoleCheck.run(new String[]{"0"}, new String[]{"Enter the number of minutes:"}, () -> NumberOfYears.main(new String[0])),
                "Enter the number of minutes:",
                "0 minutes is approximately 0 years and 0 days");
    }
    @Test
    void minutes1439() {
        ConsoleCheck.lines(ConsoleCheck.run(new String[]{"1439"}, new String[]{"Enter the number of minutes:"}, () -> NumberOfYears.main(new String[0])),
                "Enter the number of minutes:",
                "1439 minutes is approximately 0 years and 0 days");
    }
    @Test
    void minutes1440() {
        ConsoleCheck.lines(ConsoleCheck.run(new String[]{"1440"}, new String[]{"Enter the number of minutes:"}, () -> NumberOfYears.main(new String[0])),
                "Enter the number of minutes:",
                "1440 minutes is approximately 0 years and 1 days");
    }
    @Test
    void minutes525600() {
        ConsoleCheck.lines(ConsoleCheck.run(new String[]{"525600"}, new String[]{"Enter the number of minutes:"}, () -> NumberOfYears.main(new String[0])),
                "Enter the number of minutes:",
                "525600 minutes is approximately 1 years and 0 days");
    }
    @Test
    void minutes527040() {
        ConsoleCheck.lines(ConsoleCheck.run(new String[]{"527040"}, new String[]{"Enter the number of minutes:"}, () -> NumberOfYears.main(new String[0])),
                "Enter the number of minutes:",
                "527040 minutes is approximately 1 years and 1 days");
    }
    @Test
    void minutes1000000000() {
        ConsoleCheck.lines(ConsoleCheck.run(new String[]{"1000000000"}, new String[]{"Enter the number of minutes:"}, () -> NumberOfYears.main(new String[0])),
                "Enter the number of minutes:",
                "1000000000 minutes is approximately 1902 years and 214 days");
    }
    @Test
    void minutes10000000000() {
        ConsoleCheck.lines(ConsoleCheck.run(new String[]{"10000000000"}, new String[]{"Enter the number of minutes:"}, () -> NumberOfYears.main(new String[0])),
                "Enter the number of minutes:",
                "10000000000 minutes is approximately 19025 years and 319 days");
    }

    @Test
    void usesRequiredConstructs() throws Exception {
        SourceCheck check = SourceCheck.method("lt.techin.variables.NumberOfYears", "main").straightLine();
        check.local("MINUTES_PER_DAY", "long", true);
        check.local("DAYS_PER_YEAR", "long", true);
        check.calls("*.nextLine", "Long.parseLong");
    }
}
