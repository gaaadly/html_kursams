package lt.techin.platform;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JavaReadyTest {

    private static final Path SOURCE =
            Path.of("src/main/java/lt/techin/platform/JavaReady.java");

    @Test
    void printsTheReadinessMessage() {
        assertEquals("Java 25 is ready!", captureOutput());
    }

    @Test
    void usesExactlyOnePrintlnStatement() throws Exception {
        String source = JavaSource.codeOnly(SOURCE);
        long calls = Pattern.compile(
                        "System\\s*\\.\\s*out\\s*\\.\\s*println\\s*\\("
                )
                .matcher(source)
                .results()
                .count();

        assertEquals(
                1,
                calls,
                "Use exactly one System.out.println(...) statement."
        );
    }

    private String captureOutput() {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        try {
            System.setOut(new PrintStream(output, true, StandardCharsets.UTF_8));
            JavaReady.main(new String[0]);
        } finally {
            System.setOut(originalOut);
        }

        return output.toString(StandardCharsets.UTF_8)
                .replace("\r\n", "\n")
                .stripTrailing();
    }
}
