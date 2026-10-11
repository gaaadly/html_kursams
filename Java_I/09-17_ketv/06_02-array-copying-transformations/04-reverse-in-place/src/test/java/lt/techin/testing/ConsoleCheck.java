package lt.techin.testing;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/** Test infrastructure. Students edit only the task's main source file. */
public final class ConsoleCheck {
    private ConsoleCheck() {}

    public static String run(Runnable action) {
        PrintStream savedOut = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        try {
            System.setOut(new PrintStream(output, true, StandardCharsets.UTF_8));
            action.run();
        } finally {
            System.setOut(savedOut);
        }
        return output.toString(StandardCharsets.UTF_8).replace("\r\n", "\n").replace('\r', '\n');
    }
}
