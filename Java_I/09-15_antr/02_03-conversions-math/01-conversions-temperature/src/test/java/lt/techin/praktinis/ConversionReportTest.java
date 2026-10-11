package lt.techin.praktinis;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceLock;
import lt.techin.testing.ConsoleCheck;
import lt.techin.testing.SourceCheck;
import static org.junit.jupiter.api.Assertions.*;

@ResourceLock("SYSTEM_STREAMS")
class ConversionReportTest {
    @Test
    void conversions0() {
        ConsoleCheck.lines(ConsoleCheck.run(new String[]{}, new String[]{}, () -> new ConversionReport().convert(19.99, 1200000002L, 'A')),
                "Truncated: 19",
                "Narrowed: 1200000002",
                "Recovered: 1200000000",
                "Code: 65");
    }
    @Test
    void conversions1() {
        ConsoleCheck.lines(ConsoleCheck.run(new String[]{}, new String[]{}, () -> new ConversionReport().convert(-19.99, 100000000000L, 'a')),
                "Truncated: -19",
                "Narrowed: 1215752192",
                "Recovered: 99999997952",
                "Code: 97");
    }
    @Test
    void conversions2() {
        ConsoleCheck.lines(ConsoleCheck.run(new String[]{}, new String[]{}, () -> new ConversionReport().convert(0.0, 100L, 'Z')),
                "Truncated: 0",
                "Narrowed: 100",
                "Recovered: 100",
                "Code: 90");
    }
    @Test
    void conversions3() {
        ConsoleCheck.lines(ConsoleCheck.run(new String[]{}, new String[]{}, () -> new ConversionReport().convert(3.6, -1200000002L, '0')),
                "Truncated: 3",
                "Narrowed: -1200000002",
                "Recovered: -1200000000",
                "Code: 48");
    }

    @Test
    void usesRequiredConstructs() throws Exception {
        SourceCheck check = SourceCheck.method("lt.techin.praktinis.ConversionReport", "convert").straightLine();
        check.local("truncated", "int", false);
        check.local("narrowed", "int", false);
        check.local("approximate", "float", false);
        check.local("recovered", "long", false);
        check.local("code", "int", false);
        check.cast("truncated", "int").cast("narrowed", "int").cast("recovered", "long").from("approximate", "large").from("code", "letter");
    }
}
