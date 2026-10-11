package lt.techin.praktinis;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceLock;
import lt.techin.testing.ConsoleCheck;
import lt.techin.testing.SourceCheck;
import static org.junit.jupiter.api.Assertions.*;

@ResourceLock("SYSTEM_STREAMS")
class NumberReverterTest {
    @Test
    void reverse457() {
        ConsoleCheck.lines(ConsoleCheck.run(new String[]{}, new String[]{}, () -> new NumberReverter().revert(457)),
                "754");
    }
    @Test
    void reverse334() {
        ConsoleCheck.lines(ConsoleCheck.run(new String[]{}, new String[]{}, () -> new NumberReverter().revert(334)),
                "433");
    }
    @Test
    void reverse120() {
        ConsoleCheck.lines(ConsoleCheck.run(new String[]{}, new String[]{}, () -> new NumberReverter().revert(120)),
                "21");
    }
    @Test
    void reverse100() {
        ConsoleCheck.lines(ConsoleCheck.run(new String[]{}, new String[]{}, () -> new NumberReverter().revert(100)),
                "1");
    }
    @Test
    void reverse101() {
        ConsoleCheck.lines(ConsoleCheck.run(new String[]{}, new String[]{}, () -> new NumberReverter().revert(101)),
                "101");
    }

    @Test
    void usesRequiredConstructs() throws Exception {
        SourceCheck check = SourceCheck.method("lt.techin.praktinis.NumberReverter", "revert").straightLine();
        check.arithmeticOnly();
    }
}
