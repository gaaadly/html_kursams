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
    @Test void printsOnlyNamesInInputOrder() {
        String output = run("Jean\nBartik\n271224\nBetty\nHolberton\n070317\n\n", () -> PersonalInformationCollection.main(new String[0]));
        assertTrue(output.startsWith("First name: Last name: Identification number: First name: Last name: Identification number: First name: "), output);
        assertTrue(output.endsWith("Jean Bartik\nBetty Holberton\n"), output);
        assertFalse(output.contains("271224"));
        assertFalse(output.contains("070317"));
    }
    @Test void emptyFirstNameEndsImmediately() {
        assertEquals("First name: ", run("\n", () -> PersonalInformationCollection.main(new String[0])));
        String output = run("Lin\nChen\n123\n\n", () -> PersonalInformationCollection.main(new String[0]));
        assertTrue(output.endsWith("Lin Chen\n"), output);
    }
}
