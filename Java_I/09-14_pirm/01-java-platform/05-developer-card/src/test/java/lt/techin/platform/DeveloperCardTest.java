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

class DeveloperCardTest {

    private static final Path SOURCE =
            Path.of("src/main/java/lt/techin/platform/DeveloperCard.java");

    @Test
    void createsAdaDeveloperCard() {
        assertEquals(
                """
                Let's create your developer card.
                What is your name?
                What do you want to build?
                Developer card:
                Name: Ada
                Goal: an accessibility tool
                Java version: 25""",
                runWithInput("Ada\nan accessibility tool\n")
        );
    }

    @Test
    void supportsSpacesInBothAnswers() {
        assertEquals(
                """
                Let's create your developer card.
                What is your name?
                What do you want to build?
                Developer card:
                Name: Grace Hopper
                Goal: a compiler for everyone
                Java version: 25""",
                runWithInput("Grace Hopper\na compiler for everyone\n")
        );
    }

    @Test
    void usesTwoRequiredStringVariablesAndTwoReads() throws Exception {
        String source = JavaSource.codeOnly(SOURCE);

        assertTrue(
                Pattern.compile(
                        "String\\s+name\\s*=\\s*scanner\\s*\\.\\s*nextLine\\s*\\(\\s*\\)"
                ).matcher(source).find(),
                "Store the first nextLine() result in a String variable named name."
        );
        assertTrue(
                Pattern.compile(
                        "String\\s+goal\\s*=\\s*scanner\\s*\\.\\s*nextLine\\s*\\(\\s*\\)"
                ).matcher(source).find(),
                "Store the second nextLine() result in a String variable named goal."
        );

        long reads = Pattern.compile(
                        "scanner\\s*\\.\\s*nextLine\\s*\\(\\s*\\)"
                )
                .matcher(source)
                .results()
                .count();

        assertEquals(2, reads, "Call scanner.nextLine() exactly twice.");
    }

    @Test
    void alternatesPromptsAndReadsBeforePrintingTheCard() throws Exception {
        String source = JavaSource.codeOnly(SOURCE);
        int nameRead = positionOf(
                source,
                "String\\s+name\\s*=\\s*scanner\\s*\\.\\s*nextLine\\s*\\(\\s*\\)"
        );
        int goalRead = positionOf(
                source,
                "String\\s+goal\\s*=\\s*scanner\\s*\\.\\s*nextLine\\s*\\(\\s*\\)"
        );
        List<Integer> prints = positionsOf(
                source,
                "System\\s*\\.\\s*out\\s*\\.\\s*println\\s*\\("
        );

        assertTrue(
                prints.size() >= 4
                        && prints.get(1) < nameRead
                        && prints.get(2) > nameRead
                        && goalRead > prints.get(2)
                        && prints.get(3) > goalRead,
                "Use this order: opening line, name prompt, name read, goal prompt, goal read, card output."
        );
    }

    private List<Integer> positionsOf(String source, String expression) {
        var matcher = Pattern.compile(expression).matcher(source);
        List<Integer> positions = new ArrayList<>();
        while (matcher.find()) {
            positions.add(matcher.start());
        }
        return positions;
    }

    private int positionOf(String source, String expression) {
        var matcher = Pattern.compile(expression).matcher(source);
        return matcher.find() ? matcher.start() : -1;
    }

    private String runWithInput(String input) {
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        try {
            System.setIn(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));
            System.setOut(new PrintStream(output, true, StandardCharsets.UTF_8));
            DeveloperCard.main(new String[0]);
        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }

        return output.toString(StandardCharsets.UTF_8)
                .replace("\r\n", "\n")
                .stripTrailing();
    }
}
