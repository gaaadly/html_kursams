package lt.techin;

import java.util.*;
import java.lang.reflect.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AssignmentTest {
    private HashMap<String, String> data() {
        HashMap<String, String> map = new HashMap<>();
        map.put("abcd", "jkl"); map.put("def", "mno"); map.put("ghi", "pqr"); return map;
    }
    @Test void printsAllKeysAndLeavesTheMapUnchanged() {
        HashMap<String, String> map = data(); HashMap<String, String> before = new HashMap<>(map);
        outputLines(capture(() -> Program.printKeys(map)), "abcd", "def", "ghi");
        assertEquals(before, map, "Printing must not remove or replace entries.");
    }
    @Test void filtersKeysBySubstringRatherThanEqualityOrValue() {
        HashMap<String, String> map = data();
        outputLines(capture(() -> Program.printKeysWhere(map, "d")), "abcd", "def");
        outputLines(capture(() -> Program.printKeysWhere(map, "a")), "abcd");
        outputLines(capture(() -> Program.printKeysWhere(map, "jkl")));
    }
    @Test void printsValuesSelectedByTheMatchingKeys() {
        HashMap<String, String> map = data();
        outputLines(capture(() -> Program.printValuesOfKeysWhere(map, "d")), "jkl", "mno");
        outputLines(capture(() -> Program.printValuesOfKeysWhere(map, "a")), "jkl");
        assertEquals(data(), map);
    }
    @Test void supportsEmptyMapsEmptySearchAndCaseSensitiveMatching() {
        HashMap<String, String> map = data();
        outputLines(capture(() -> Program.printKeys(new HashMap<>())));
        outputLines(capture(() -> Program.printKeysWhere(new HashMap<>(), "x")));
        outputLines(capture(() -> Program.printValuesOfKeysWhere(new HashMap<>(), "x")));
        outputLines(capture(() -> Program.printKeysWhere(map, "")), "abcd", "def", "ghi");
        outputLines(capture(() -> Program.printValuesOfKeysWhere(map, "")), "jkl", "mno", "pqr");
        outputLines(capture(() -> Program.printKeysWhere(map, "D")));
        outputLines(capture(() -> Program.printValuesOfKeysWhere(map, "none")));
    }
    @Test void doesNotDeduplicateValuesBelongingToDifferentKeys() {
        HashMap<String, String> map = new HashMap<>(); map.put("ax", "same"); map.put("bx", "same");
        outputLines(capture(() -> Program.printValuesOfKeysWhere(map, "x")), "same", "same");
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
