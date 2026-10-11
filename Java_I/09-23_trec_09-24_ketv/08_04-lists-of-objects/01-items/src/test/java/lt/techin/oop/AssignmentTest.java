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
    @Test void twoItemsInOrderWithCreationTimes() {
        String output = run("Hammer\nCollar\n\n", () -> Items.main(new String[0]));
        assertTrue(output.startsWith("Name: Name: Name: "), output);
        assertTrue(output.contains("Hammer (created at: "), output);
        assertTrue(output.contains("Collar (created at: "), output);
        assertTrue(output.endsWith(")\n"), output);
        assertTrue(output.indexOf("Hammer (created at:") < output.indexOf("Collar (created at:"), output);
    }
    @Test void emptyInputCreatesNoItemAndNextRunIsIndependent() {
        assertEquals("Name: ", run("\n", () -> Items.main(new String[0])));
        String output = run("Mug\n\n", () -> Items.main(new String[0]));
        assertTrue(output.contains("Mug (created at: "), output);
        assertFalse(output.contains("Hammer"), output);
    }
}
