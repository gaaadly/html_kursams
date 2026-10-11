package lt.techin.testing;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import static org.junit.jupiter.api.Assertions.*;

/** Test infrastructure. Students edit only the task's main source file. */
public final class ConsoleCheck {
    private ConsoleCheck() {}

    public static String run(String[] inputs, String[] prompts, Runnable action) {
        InputStream savedIn = System.in;
        PrintStream savedOut = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        class PromptAwareInput extends InputStream {
            int line;
            int offset;
            byte[] current;

            private boolean prepare() {
                if (current != null && offset < current.length) return true;
                if (line == inputs.length) return false;
                StringBuilder required = new StringBuilder();
                for (int i = 0; i <= line; i++) required.append(prompts[i]).append("\n");
                assertEquals(required.toString(), normalize(output.toString(StandardCharsets.UTF_8)),
                        "Print each prompt with println before reading its input line.");
                current = (inputs[line++] + "\n").getBytes(StandardCharsets.UTF_8);
                offset = 0;
                return true;
            }

            @Override public int read() {
                return prepare() ? current[offset++] & 255 : -1;
            }

            @Override public int read(byte[] target, int start, int length) {
                if (length == 0) return 0;
                if (!prepare()) return -1;
                int count = Math.min(length, current.length - offset);
                System.arraycopy(current, offset, target, start, count);
                offset += count;
                return count;
            }
        }

        PromptAwareInput input = new PromptAwareInput();
        try {
            System.setIn(input);
            System.setOut(new PrintStream(output, true, StandardCharsets.UTF_8));
            action.run();
            assertEquals(inputs.length, input.line, "Read every required input line.");
        } finally {
            System.setIn(savedIn);
            System.setOut(savedOut);
        }
        return normalize(output.toString(StandardCharsets.UTF_8));
    }

    public static void lines(String actual, String... expected) {
        assertTrue(actual.endsWith("\n"), "End every output line with println.");
        assertArrayEquals(expected, actual.substring(0, actual.length() - 1).split("\n", -1));
    }

    private static String normalize(String text) {
        return text.replace("\r\n", "\n").replace('\r', '\n');
    }
}
