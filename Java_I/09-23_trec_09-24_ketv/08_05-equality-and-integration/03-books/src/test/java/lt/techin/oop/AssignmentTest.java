package lt.techin.oop;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
class AssignmentTest {
    @Test void equalityUsesNameAndYear() {
        Book a = new Book("book", 1990), b = new Book("book", 1990);
        assertEquals(a, b); assertEquals(a.hashCode(), b.hashCode());
        assertNotEquals(a, new Book("book", 1991));
        assertNotEquals(a, new Book("other", 1990));
        assertNotEquals(a, null); assertNotEquals(a, "book");
    }
    @Test void duplicateSession() {
        String output = run("Bossypants\n2013\nSeriously...I'm Kidding\n2012\nSeriously...I'm Kidding\n2012\n\n");
        assertTrue(output.contains("The book is already on the list. Let's not add the same book again."));
        assertTrue(output.endsWith("Thank you! Books added: 2\n"));
        assertEquals(4, output.split("Name \\(empty will stop\\):", -1).length - 1);
    }
    @Test void distinctBooksAndMultipleDuplicates() {
        String output = run("book\n1990\nbook\n1990\nbook\n1991\nother\n1991\nbook\n1990\n\n");
        assertTrue(output.endsWith("Thank you! Books added: 3\n"));
        assertEquals(2, output.split("The book is already on the list", -1).length - 1);
    }
    private String run(String input) {
        InputStream oldIn = System.in; PrintStream oldOut = System.out;
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        try {
            System.setIn(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));
            System.setOut(new PrintStream(bytes, true, StandardCharsets.UTF_8));
            Main.main(new String[0]);
            return bytes.toString(StandardCharsets.UTF_8).replace("\r\n", "\n");
        } finally { System.setIn(oldIn); System.setOut(oldOut); }
    }
}
