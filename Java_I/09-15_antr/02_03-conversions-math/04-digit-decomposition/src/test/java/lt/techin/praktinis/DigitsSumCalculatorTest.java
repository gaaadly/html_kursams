package lt.techin.praktinis;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceLock;
import lt.techin.testing.ConsoleCheck;
import lt.techin.testing.SourceCheck;
import static org.junit.jupiter.api.Assertions.*;

@ResourceLock("SYSTEM_STREAMS")
class DigitsSumCalculatorTest {
    @Test
    void sum1111() {
        ConsoleCheck.lines(ConsoleCheck.run(new String[]{}, new String[]{}, () -> new DigitsSumCalculator().calculateSum(1111)),
                "4");
    }
    @Test
    void sum4567() {
        ConsoleCheck.lines(ConsoleCheck.run(new String[]{}, new String[]{}, () -> new DigitsSumCalculator().calculateSum(4567)),
                "22");
    }
    @Test
    void sum1000() {
        ConsoleCheck.lines(ConsoleCheck.run(new String[]{}, new String[]{}, () -> new DigitsSumCalculator().calculateSum(1000)),
                "1");
    }
    @Test
    void sum1009() {
        ConsoleCheck.lines(ConsoleCheck.run(new String[]{}, new String[]{}, () -> new DigitsSumCalculator().calculateSum(1009)),
                "10");
    }
    @Test
    void sum9999() {
        ConsoleCheck.lines(ConsoleCheck.run(new String[]{}, new String[]{}, () -> new DigitsSumCalculator().calculateSum(9999)),
                "36");
    }

    @Test
    void usesRequiredConstructs() throws Exception {
        SourceCheck check = SourceCheck.method("lt.techin.praktinis.DigitsSumCalculator", "calculateSum").straightLine();
        check.arithmeticOnly();
    }
}
