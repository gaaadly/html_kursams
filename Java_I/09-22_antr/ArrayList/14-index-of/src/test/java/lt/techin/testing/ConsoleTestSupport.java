package lt.techin.testing;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public final class ConsoleTestSupport {
    private ConsoleTestSupport() { }

    public static synchronized String run(String input, Runnable program) {
        var oldIn = System.in;
        var oldOut = System.out;
        var output = new ByteArrayOutputStream();
        try {
            System.setIn(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));
            System.setOut(new PrintStream(output, true, StandardCharsets.UTF_8));
            program.run();
            return output.toString(StandardCharsets.UTF_8)
                    .replace("\r\n", "\n")
                    .replace('\r', '\n');
        } finally {
            System.setIn(oldIn);
            System.setOut(oldOut);
        }
    }

    public static String after(String output, String marker) {
        int index = output.indexOf(marker);
        if (index < 0) {
            return "";
        }
        return output.substring(index + marker.length()).stripLeading();
    }
}
