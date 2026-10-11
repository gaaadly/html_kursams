package lt.techin.oop;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;

@Timeout(5)
class AssignmentTest {
    private String run(String input, Runnable program) {
        var originalIn = System.in;
        var originalOut = System.out;
        var bytes = new ByteArrayOutputStream();
        try {
            System.setIn(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));
            System.setOut(new PrintStream(bytes, true, StandardCharsets.UTF_8));
            program.run();
            return bytes.toString(StandardCharsets.UTF_8).replace("\r\n", "\n");
        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }
    }
    @Test void includesEqualDurationAndKeepsOrder() {
        String output = run("Rick and Morty\n25\nHouse\n60\nNews\n30\n\n30\n", () -> Main.main(new String[0]));
        assertTrue(output.endsWith("Rick and Morty, 25 minutes\nNews, 30 minutes\n"), output);
        assertFalse(output.contains("House, 60 minutes"), output);
    }
    @Test void emptyAndZeroMaximumProduceNoResults() {
        assertEquals("Name: Program's maximum duration? ", run("\n0\n", () -> Main.main(new String[0])));
        String output = run("House\n60\n\n0\n", () -> Main.main(new String[0]));
        assertFalse(output.contains("House, 60 minutes"), output);
    }
}
