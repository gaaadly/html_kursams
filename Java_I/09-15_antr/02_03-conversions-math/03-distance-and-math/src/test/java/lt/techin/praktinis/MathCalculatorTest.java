package lt.techin.praktinis;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceLock;
import lt.techin.testing.ConsoleCheck;
import lt.techin.testing.SourceCheck;
import static org.junit.jupiter.api.Assertions.*;

@ResourceLock("SYSTEM_STREAMS")
class MathCalculatorTest {
    @Test
    void math0() {
        ConsoleCheck.lines(ConsoleCheck.run(new String[]{}, new String[]{}, () -> new MathCalculator().calculate(3.6, -4, 7, 2.0)),
                "~Square: |12.96",
                "~Root: |1.8973665961010275",
                "Rounded: 4",
                "Smaller: -4",
                "Larger: 7",
                "~Area: |12.566370614359172");
    }
    @Test
    void math1() {
        ConsoleCheck.lines(ConsoleCheck.run(new String[]{}, new String[]{}, () -> new MathCalculator().calculate(0.0, 5, 5, 0.0)),
                "~Square: |0.0",
                "~Root: |0.0",
                "Rounded: 0",
                "Smaller: 5",
                "Larger: 5",
                "~Area: |0.0");
    }
    @Test
    void math2() {
        ConsoleCheck.lines(ConsoleCheck.run(new String[]{}, new String[]{}, () -> new MathCalculator().calculate(2.5, 10, -10, 1.5)),
                "~Square: |6.25",
                "~Root: |1.5811388300841898",
                "Rounded: 3",
                "Smaller: -10",
                "Larger: 10",
                "~Area: |7.0685834705770345");
    }
    @Test
    void math3() {
        ConsoleCheck.lines(ConsoleCheck.run(new String[]{}, new String[]{}, () -> new MathCalculator().calculate(25.0, 0, 9, 1.0)),
                "~Square: |625.0",
                "~Root: |5.0",
                "Rounded: 25",
                "Smaller: 0",
                "Larger: 9",
                "~Area: |3.141592653589793");
    }

    @Test
    void usesRequiredConstructs() throws Exception {
        SourceCheck check = SourceCheck.method("lt.techin.praktinis.MathCalculator", "calculate").straightLine();
        check.calls("Math.pow", "Math.sqrt", "Math.round", "Math.min", "Math.max");
        check.member("Math.PI");
    }
}
