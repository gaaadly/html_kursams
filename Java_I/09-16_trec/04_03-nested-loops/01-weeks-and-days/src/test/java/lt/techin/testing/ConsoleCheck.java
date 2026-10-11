package lt.techin.testing;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import static org.junit.jupiter.api.Assertions.assertEquals;

/** Test infrastructure. Students edit only the task's main source file. */
public final class ConsoleCheck {
    private ConsoleCheck() {}

    public static String run(String input, Runnable action) {
        InputStream savedIn = System.in;
        PrintStream savedOut = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        try {
            System.setIn(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));
            System.setOut(new PrintStream(output, true, StandardCharsets.UTF_8));
            action.run();
        } finally {
            System.setIn(savedIn);
            System.setOut(savedOut);
        }
        return normalize(output.toString(StandardCharsets.UTF_8));
    }

    public static void output(String input, String expected, Runnable action) {
        assertEquals(normalize(expected), run(input, action),
                "Match the described prompts, values, spaces, and line breaks.");
    }

    private static String normalize(String text) {
        return text.replace("\r\n", "\n").replace('\r', '\n');
    }
}
