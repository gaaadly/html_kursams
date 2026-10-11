package lt.techin.oop;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;

@Timeout(5)
class AssignmentTest {
    private String run(String input, Runnable program) {
        var originalIn = System.in;
        var originalOut = System.out;
        var bytes = new ByteArrayOutputStream();
        try {
            System.setIn(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));
            System.setOut(new PrintStream(bytes, true, StandardCharsets.UTF_8));
            program.run();
            return bytes.toString(StandardCharsets.UTF_8).replace("\r\n", "\n");
        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }
    }
    @Test void bookKeepsAllFieldsAndFormatsThem() {
        Book book = new Book("Winnie-the-Pooh", 50, 1926);
        assertEquals("Winnie-the-Pooh", book.getTitle());
        assertEquals(50, book.getPages());
        assertEquals(1926, book.getPublicationYear());
        assertEquals("Winnie-the-Pooh, 50 pages, 1926", book.toString());
    }
    @Test void everythingPrintsAllBooksInOrderIncludingDuplicates() {
        String output = run("A\n10\n2001\nA\n12\n2002\n\neverything\n", () -> Main.main(new String[0]));
        assertTrue(output.endsWith("A, 10 pages, 2001\nA, 12 pages, 2002\n"), output);
    }
    @Test void nameChoiceHidesOtherFieldsAndEmptyInputWorks() {
        String output = run("Book X\n99\n1988\nBook Y\n101\n1990\n\nname\n", () -> Main.main(new String[0]));
        assertTrue(output.endsWith("Book X\nBook Y\n"), output);
        assertFalse(output.contains("99"));
        assertFalse(output.contains("1988"));
        assertEquals("Title: What information will be printed? ", run("\nname\n", () -> Main.main(new String[0])));
    }
}
