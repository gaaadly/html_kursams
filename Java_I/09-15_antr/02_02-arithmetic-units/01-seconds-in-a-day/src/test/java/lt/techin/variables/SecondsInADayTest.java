package lt.techin.variables;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceLock;
import lt.techin.testing.ConsoleCheck;
import lt.techin.testing.SourceCheck;
import static org.junit.jupiter.api.Assertions.*;

@ResourceLock("SYSTEM_STREAMS")
class SecondsInADayTest {
    @Test
    void days0() {
        ConsoleCheck.lines(ConsoleCheck.run(new String[]{"0"}, new String[]{"How many days would you like to convert to seconds?"}, () -> SecondsInADay.main(new String[0])),
                "How many days would you like to convert to seconds?",
                "0");
    }
    @Test
    void days1() {
        ConsoleCheck.lines(ConsoleCheck.run(new String[]{"1"}, new String[]{"How many days would you like to convert to seconds?"}, () -> SecondsInADay.main(new String[0])),
                "How many days would you like to convert to seconds?",
                "86400");
    }
    @Test
    void days3() {
        ConsoleCheck.lines(ConsoleCheck.run(new String[]{"3"}, new String[]{"How many days would you like to convert to seconds?"}, () -> SecondsInADay.main(new String[0])),
                "How many days would you like to convert to seconds?",
                "259200");
    }
    @Test
    void days8() {
        ConsoleCheck.lines(ConsoleCheck.run(new String[]{"8"}, new String[]{"How many days would you like to convert to seconds?"}, () -> SecondsInADay.main(new String[0])),
                "How many days would you like to convert to seconds?",
                "691200");
    }
    @Test
    void days30000() {
        ConsoleCheck.lines(ConsoleCheck.run(new String[]{"30000"}, new String[]{"How many days would you like to convert to seconds?"}, () -> SecondsInADay.main(new String[0])),
                "How many days would you like to convert to seconds?",
                "2592000000");
    }
    @Test
    void days1000000() {
        ConsoleCheck.lines(ConsoleCheck.run(new String[]{"1000000"}, new String[]{"How many days would you like to convert to seconds?"}, () -> SecondsInADay.main(new String[0])),
                "How many days would you like to convert to seconds?",
                "86400000000");
    }

    @Test
    void usesRequiredConstructs() throws Exception {
        SourceCheck check = SourceCheck.method("lt.techin.variables.SecondsInADay", "main").straightLine();
        check.local("days", "int", false);
        check.local("HOURS_PER_DAY", "long", true);
        check.local("MINUTES_PER_HOUR", "int", true);
        check.local("SECONDS_PER_MINUTE", "int", true);
        check.local("seconds", "long", false);
        check.calls("*.nextLine", "Integer.parseInt");
    }
}
