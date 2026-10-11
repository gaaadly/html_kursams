package lt.techin.platform;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CourseGreetingTest {

    private static final Path SOURCE =
            Path.of("src/main/java/lt/techin/platform/CourseGreeting.java");

    @Test
    void greetsMaya() {
        assertEquals(
                """
                What is your name?
                Welcome to the Java course, Maya!""",
                runWithInput("Maya\n")
        );
    }

    @Test
    void greetsANameWithSpaces() {
        assertEquals(
                """
                What is your name?
                Welcome to the Java course, Alex Kim!""",
                runWithInput("Alex Kim\n")
        );
    }

    @Test
    void storesNextLineInTheRequiredNameVariable() throws Exception {
        String source = JavaSource.codeOnly(SOURCE);

        assertTrue(
                Pattern.compile(
                        "String\\s+name\\s*=\\s*scanner\\s*\\.\\s*nextLine\\s*\\(\\s*\\)"
                ).matcher(source).find(),
                "Store scanner.nextLine() in a String variable named name."
        );
    }

    @Test
    void printsThePromptBeforeReadingInput() throws Exception {
        String source = JavaSource.codeOnly(SOURCE);
        int read = positionOf(
                source,
                "scanner\\s*\\.\\s*nextLine\\s*\\("
        );
        List<Integer> prints = positionsOf(
                source,
                "System\\s*\\.\\s*out\\s*\\.\\s*println\\s*\\("
        );

        assertTrue(
                prints.size() >= 2 && prints.get(0) < read && prints.get(1) > read,
                "Print the name prompt before nextLine(), then print the greeting."
        );
    }

    private int positionOf(String source, String expression) {
        var matcher = Pattern.compile(expression).matcher(source);
        return matcher.find() ? matcher.start() : -1;
    }

    private List<Integer> positionsOf(String source, String expression) {
        var matcher = Pattern.compile(expression).matcher(source);
        List<Integer> positions = new ArrayList<>();
        while (matcher.find()) {
            positions.add(matcher.start());
        }
        return positions;
    }

    private String runWithInput(String input) {
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        try {
            System.setIn(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));
            System.setOut(new PrintStream(output, true, StandardCharsets.UTF_8));
            CourseGreeting.main(new String[0]);
        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }

        return output.toString(StandardCharsets.UTF_8)
                .replace("\r\n", "\n")
                .stripTrailing();
    }
}
