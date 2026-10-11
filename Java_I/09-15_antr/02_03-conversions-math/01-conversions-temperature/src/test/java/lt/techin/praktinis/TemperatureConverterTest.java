package lt.techin.praktinis;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceLock;
import lt.techin.testing.ConsoleCheck;
import lt.techin.testing.SourceCheck;
import static org.junit.jupiter.api.Assertions.*;

@ResourceLock("SYSTEM_STREAMS")
class TemperatureConverterTest {
    @Test
    void temperature0() {
        ConsoleCheck.lines(ConsoleCheck.run(new String[]{}, new String[]{}, () -> new TemperatureConverter().toFahrenheit(1)),
                "~|33.8");
    }
    @Test
    void temperature1() {
        ConsoleCheck.lines(ConsoleCheck.run(new String[]{}, new String[]{}, () -> new TemperatureConverter().toFahrenheit(5)),
                "~|41.0");
    }
    @Test
    void temperature2() {
        ConsoleCheck.lines(ConsoleCheck.run(new String[]{}, new String[]{}, () -> new TemperatureConverter().toFahrenheit(0)),
                "~|32.0");
    }
    @Test
    void temperature3() {
        ConsoleCheck.lines(ConsoleCheck.run(new String[]{}, new String[]{}, () -> new TemperatureConverter().toFahrenheit(-40)),
                "~|-40.0");
    }
    @Test
    void temperature4() {
        ConsoleCheck.lines(ConsoleCheck.run(new String[]{}, new String[]{}, () -> new TemperatureConverter().toFahrenheit(100)),
                "~|212.0");
    }
    @Test
    void temperature5() {
        ConsoleCheck.lines(ConsoleCheck.run(new String[]{}, new String[]{}, () -> new TemperatureConverter().toFahrenheit(-100)),
                "~|-148.0");
    }

    @Test
    void usesRequiredConstructs() throws Exception {
        SourceCheck check = SourceCheck.method("lt.techin.praktinis.TemperatureConverter", "toFahrenheit").straightLine();
    }
}
