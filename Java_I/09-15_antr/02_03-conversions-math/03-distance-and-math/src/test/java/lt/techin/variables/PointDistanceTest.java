package lt.techin.variables;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceLock;
import lt.techin.testing.ConsoleCheck;
import lt.techin.testing.SourceCheck;
import static org.junit.jupiter.api.Assertions.*;

@ResourceLock("SYSTEM_STREAMS")
class PointDistanceTest {
    @Test
    void points0() {
        ConsoleCheck.lines(ConsoleCheck.run(new String[]{"1.5", "-3.4", "4", "5"}, new String[]{"Enter x1:", "Enter y1:", "Enter x2:", "Enter y2:"}, () -> PointDistance.main(new String[0])),
                "Enter x1:",
                "Enter y1:",
                "Enter x2:",
                "Enter y2:",
                "~The distance between the two points is |8.764131445842194");
    }
    @Test
    void points1() {
        ConsoleCheck.lines(ConsoleCheck.run(new String[]{"0", "0", "3", "4"}, new String[]{"Enter x1:", "Enter y1:", "Enter x2:", "Enter y2:"}, () -> PointDistance.main(new String[0])),
                "Enter x1:",
                "Enter y1:",
                "Enter x2:",
                "Enter y2:",
                "~The distance between the two points is |5.0");
    }
    @Test
    void points2() {
        ConsoleCheck.lines(ConsoleCheck.run(new String[]{"2", "2", "2", "2"}, new String[]{"Enter x1:", "Enter y1:", "Enter x2:", "Enter y2:"}, () -> PointDistance.main(new String[0])),
                "Enter x1:",
                "Enter y1:",
                "Enter x2:",
                "Enter y2:",
                "~The distance between the two points is |0.0");
    }
    @Test
    void points3() {
        ConsoleCheck.lines(ConsoleCheck.run(new String[]{"-3", "-4", "0", "0"}, new String[]{"Enter x1:", "Enter y1:", "Enter x2:", "Enter y2:"}, () -> PointDistance.main(new String[0])),
                "Enter x1:",
                "Enter y1:",
                "Enter x2:",
                "Enter y2:",
                "~The distance between the two points is |5.0");
    }
    @Test
    void points4() {
        ConsoleCheck.lines(ConsoleCheck.run(new String[]{"1", "2", "1", "-2"}, new String[]{"Enter x1:", "Enter y1:", "Enter x2:", "Enter y2:"}, () -> PointDistance.main(new String[0])),
                "Enter x1:",
                "Enter y1:",
                "Enter x2:",
                "Enter y2:",
                "~The distance between the two points is |4.0");
    }

    @Test
    void usesRequiredConstructs() throws Exception {
        SourceCheck check = SourceCheck.method("lt.techin.variables.PointDistance", "main").straightLine();
        check.calls("*.nextLine", "Double.parseDouble", "Math.sqrt");
    }
}
