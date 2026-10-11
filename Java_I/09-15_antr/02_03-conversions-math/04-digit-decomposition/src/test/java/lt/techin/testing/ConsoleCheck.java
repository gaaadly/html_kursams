package lt.techin.testing;

import java.io.*;
import java.nio.charset.StandardCharsets;
import static org.junit.jupiter.api.Assertions.*;

/** Test infrastructure. Students edit only the task's main source files. */
public final class ConsoleCheck {
    private ConsoleCheck() {}

    public static String run(String[] lines, String[] prompts, Runnable action) {
        InputStream savedIn = System.in;
        PrintStream savedOut = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        class LineInput extends InputStream {
            int line = 0;
            int offset = 0;
            byte[] bytes;
            private boolean prepare() {
                if (bytes != null && offset < bytes.length) return true;
                if (line == lines.length) return false;
                StringBuilder required = new StringBuilder();
                for (int i = 0; i <= line; i++) required.append(prompts[i]).append("\n");
                assertEquals(required.toString(), normalize(output.toString(StandardCharsets.UTF_8)),
                        "Print each required prompt before reading its line; print results after all inputs.");
                bytes = (lines[line++] + "\n").getBytes(StandardCharsets.UTF_8);
                offset = 0;
                return true;
            }
            @Override public int read() {
                return prepare() ? bytes[offset++] & 255 : -1;
            }
            @Override public int read(byte[] target, int start, int length) {
                if (length == 0) return 0;
                if (!prepare()) return -1;
                int count = Math.min(length, bytes.length - offset);
                System.arraycopy(bytes, offset, target, start, count);
                offset += count;
                return count;
            }
        }
        LineInput input = new LineInput();
        try {
            System.setIn(input);
            System.setOut(new PrintStream(output, true, StandardCharsets.UTF_8));
            action.run();
            assertEquals(lines.length, input.line, "Read every required input line.");
        } finally {
            System.setIn(savedIn);
            System.setOut(savedOut);
        }
        return normalize(output.toString(StandardCharsets.UTF_8));
    }

    public static void lines(String actual, String... expected) {
        assertTrue(actual.endsWith("\n"), "End each output line with println.");
        String[] rows = actual.substring(0, actual.length() - 1).split("\n", -1);
        assertEquals(expected.length, rows.length, "Use exactly the required number of output lines.");
        for (int i = 0; i < expected.length; i++) {
            String e = expected[i];
            if (!e.startsWith("~")) {
                assertEquals(e, rows[i], "Output line " + (i + 1));
            } else {
                int separator = e.lastIndexOf('|');
                String prefix = e.substring(1, separator);
                assertTrue(rows[i].startsWith(prefix), "Required label on line " + (i + 1) + ": " + prefix);
                double value = 0;
                try { value = Double.parseDouble(rows[i].substring(prefix.length())); }
                catch (NumberFormatException error) { fail("Print a numeric result on line " + (i + 1)); }
                assertTrue(Double.isFinite(value), "Use a finite numeric result.");
                assertEquals(Double.parseDouble(e.substring(separator + 1)), value, 1e-9,
                        "Numeric result on line " + (i + 1));
            }
        }
    }

    private static String normalize(String text) {
        return text.replace("\r\n", "\n").replace('\r', '\n');
    }
}
