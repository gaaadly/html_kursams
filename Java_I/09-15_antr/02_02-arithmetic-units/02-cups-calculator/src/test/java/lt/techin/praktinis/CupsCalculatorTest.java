package lt.techin.praktinis;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceLock;
import lt.techin.testing.ConsoleCheck;
import lt.techin.testing.SourceCheck;
import static org.junit.jupiter.api.Assertions.*;

@ResourceLock("SYSTEM_STREAMS")
class CupsCalculatorTest {
    @Test
    void cups0() {
        ConsoleCheck.lines(ConsoleCheck.run(new String[]{}, new String[]{}, () -> new CupsCalculator().calculateCups(0)),
                "Dėžių: 0",
                "Liko puodelių: 0");
    }
    @Test
    void cups1() {
        ConsoleCheck.lines(ConsoleCheck.run(new String[]{}, new String[]{}, () -> new CupsCalculator().calculateCups(1)),
                "Dėžių: 0",
                "Liko puodelių: 1");
    }
    @Test
    void cups2() {
        ConsoleCheck.lines(ConsoleCheck.run(new String[]{}, new String[]{}, () -> new CupsCalculator().calculateCups(2)),
                "Dėžių: 0",
                "Liko puodelių: 2");
    }
    @Test
    void cups10() {
        ConsoleCheck.lines(ConsoleCheck.run(new String[]{}, new String[]{}, () -> new CupsCalculator().calculateCups(10)),
                "Dėžių: 3",
                "Liko puodelių: 1");
    }
    @Test
    void cups17() {
        ConsoleCheck.lines(ConsoleCheck.run(new String[]{}, new String[]{}, () -> new CupsCalculator().calculateCups(17)),
                "Dėžių: 5",
                "Liko puodelių: 2");
    }
    @Test
    void cups12() {
        ConsoleCheck.lines(ConsoleCheck.run(new String[]{}, new String[]{}, () -> new CupsCalculator().calculateCups(12)),
                "Dėžių: 4",
                "Liko puodelių: 0");
    }

    @Test
    void usesRequiredConstructs() throws Exception {
        SourceCheck check = SourceCheck.method("lt.techin.praktinis.CupsCalculator", "calculateCups").straightLine();
        check.arithmeticOnly();
    }
}
