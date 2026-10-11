package lt.techin.conditionals;

import com.sun.source.tree.Tree;
import lt.techin.testing.ConsoleCheck;
import lt.techin.testing.SourceCheck;
import org.junit.jupiter.api.Test;

class SpeedingTicketTest {
    private void check(int speed, String... expected) {
        String out = ConsoleCheck.run(new String[]{String.valueOf(speed)}, new String[]{"Give speed:"},
                () -> SpeedingTicket.main(new String[0]));
        ConsoleCheck.lines(out, expected);
    }

    @Test void belowBoundary() { check(119, "Give speed:"); }
    @Test void atBoundary() { check(120, "Give speed:"); }
    @Test void aboveBoundary() { check(121, "Give speed:", "Speeding ticket!"); }
    @Test void farAboveBoundary() { check(180, "Give speed:", "Speeding ticket!"); }

    @Test void usesTheTaughtConstruct() throws Exception {
        SourceCheck.method("lt.techin.conditionals.SpeedingTicket", "main")
                .requireKinds(Tree.Kind.GREATER_THAN)
                .bracedIfsAtLeast(1);
    }
}
