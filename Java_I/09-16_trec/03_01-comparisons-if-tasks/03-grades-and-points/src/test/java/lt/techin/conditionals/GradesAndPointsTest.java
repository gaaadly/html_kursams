package lt.techin.conditionals;

import lt.techin.testing.ConsoleCheck;
import lt.techin.testing.SourceCheck;
import org.junit.jupiter.api.Test;

class GradesAndPointsTest {
    private void check(int points, String grade) {
        String out = ConsoleCheck.run(new String[]{String.valueOf(points)}, new String[]{"Give points:"},
                () -> GradesAndPoints.main(new String[0]));
        ConsoleCheck.lines(out, "Give points:", "Grade: " + grade);
    }

    @Test void impossibleBoundary() { check(-1, "impossible!"); check(0, "failed"); }
    @Test void failedBoundary() { check(49, "failed"); check(50, "1"); }
    @Test void middleBoundaries() { check(59, "1"); check(60, "2"); check(69, "2"); check(70, "3"); check(79, "3"); check(80, "4"); }
    @Test void highestBoundaries() { check(89, "4"); check(90, "5"); check(100, "5"); check(101, "incredible!"); }

    @Test void usesAnOrderedChain() throws Exception {
        SourceCheck.method("lt.techin.conditionals.GradesAndPoints", "main")
                .bracedIfsAtLeast(7)
                .elseIfDepthAtLeast(7)
                .hasElse();
    }
}
