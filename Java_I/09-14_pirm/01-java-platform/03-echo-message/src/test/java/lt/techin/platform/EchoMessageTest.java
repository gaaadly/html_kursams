package lt.techin.platform;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EchoMessageTest {

    private static final Path SOURCE =
            Path.of("src/main/java/lt/techin/platform/EchoMessage.java");

    @Test
    void echoesAShortMessage() {
        assertEquals(
                """
                Enter a message:
                Hello!""",
                runWithInput("Hello!\n")
        );
    }

    @Test
    void readsTheCompleteLine() {
        assertEquals(
                """
                Enter a message:
                Learning Java one step at a time.""",
                runWithInput("Learning Java one step at a time.\n")
        );
    }

    @Test
    void usesTheRequiredScannerAndMessageVariable() throws Exception {
        String source = JavaSource.codeOnly(SOURCE);

        assertTrue(
                Pattern.compile(
                        "new\\s+Scanner\\s*\\(\\s*System\\s*\\.\\s*in\\s*\\)"
                ).matcher(source).find(),
                "Create the Scanner with System.in."
        );
        assertTrue(
                Pattern.compile(
                        "String\\s+message\\s*=\\s*scanner\\s*\\.\\s*nextLine\\s*\\(\\s*\\)"
                ).matcher(source).find(),
                "Store scanner.nextLine() in a String variable named message."
        );
    }

    private String runWithInput(String input) {
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        try {
            System.setIn(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));
            System.setOut(new PrintStream(output, true, StandardCharsets.UTF_8));
            EchoMessage.main(new String[0]);
        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }

        return output.toString(StandardCharsets.UTF_8)
                .replace("\r\n", "\n")
                .stripTrailing();
    }
}
