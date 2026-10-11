package lt.techin;

import java.util.*;
import java.lang.reflect.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AssignmentTest {
    private HashMap<String, Book> data() {
        HashMap<String, Book> map = new HashMap<>();
        map.put("sense", new Book("Sensibility", 1811, "..."));
        map.put("prejudice", new Book("pride", 1813, "...."));
        map.put("happy", new Book("Don't let the pigeon drive the bus", 2003, "text")); return map;
    }
    @Test void printsCompleteBookRepresentationsRatherThanKeys() {
        HashMap<String, Book> map = data();
        outputLines(capture(() -> Program.printValues(map)), "Name: Sensibility (1811)", "Contents: ...",
            "Name: pride (1813)", "Contents: ....", "Name: Don't let the pigeon drive the bus (2003)", "Contents: text");
        assertEquals(3, map.size()); assertEquals("pride", map.get("prejudice").getName());
    }
    @Test void filtersByNameAndPrintsOnlyMatchingBooks() {
        HashMap<String, Book> map = data();
        outputLines(capture(() -> Program.printValueIfNameContains(map, "ide")), "Name: pride (1813)", "Contents: ....");
        outputLines(capture(() -> Program.printValueIfNameContains(map, "p")), "Name: pride (1813)", "Contents: ....",
            "Name: Don't let the pigeon drive the bus (2003)", "Contents: text");
        outputLines(capture(() -> Program.printValueIfNameContains(map, "happy")));
        outputLines(capture(() -> Program.printValueIfNameContains(map, "text")));
    }
    @Test void usesProvidedToStringIncludingAnOverriddenRepresentation() {
        HashMap<String, Book> map = new HashMap<>();
        map.put("different-key", new Book("Selected", 2020, "payload") {
            @Override public String toString() { return "custom representation"; }
        });
        outputLines(capture(() -> Program.printValues(map)), "custom representation");
        outputLines(capture(() -> Program.printValueIfNameContains(map, "lect")), "custom representation");
    }
    @Test void handlesEmptyMapsEmptySearchAndCaseSensitiveSearch() {
        HashMap<String, Book> map = new HashMap<>(); map.put("key", new Book("Title", 2025, "body"));
        outputLines(capture(() -> Program.printValues(new HashMap<>())));
        outputLines(capture(() -> Program.printValueIfNameContains(new HashMap<>(), "x")));
        outputLines(capture(() -> Program.printValueIfNameContains(map, "")), "Name: Title (2025)", "Contents: body");
        outputLines(capture(() -> Program.printValueIfNameContains(map, "title")));
    }

    private static String capture(Runnable action) {
        java.io.PrintStream previous = System.out;
        java.io.ByteArrayOutputStream bytes = new java.io.ByteArrayOutputStream();
        try (java.io.PrintStream stream = new java.io.PrintStream(bytes, true, java.nio.charset.StandardCharsets.UTF_8)) {
            System.setOut(stream);
            action.run();
        } finally { System.setOut(previous); }
        return bytes.toString(java.nio.charset.StandardCharsets.UTF_8).replace("\r\n", "\n");
    }
    private static void outputLines(String actual, String... expected) {
        ArrayList<String> lines = new ArrayList<>(actual.lines().toList());
        ArrayList<String> wanted = new ArrayList<>(Arrays.asList(expected));
        Collections.sort(lines); Collections.sort(wanted);
        assertEquals(wanted, lines, "Print each required line once, with no extra text; map order may vary.");
    }

}
