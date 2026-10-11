package lt.techin.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;

@Timeout(5)
class AssignmentTest {
    @Test void suppliedPetAppearsInText() {
        Pet lucy = new Pet("Lucy", "golden retriever");
        Person leo = new Person("Leo", lucy);
        assertEquals("Leo, has a friend called Lucy (golden retriever)", leo.toString());
        assertEquals("Mira, has a friend called Pip (cat)", new Person("Mira", new Pet("Pip", "cat")).toString());
    }
    @Test void defaultsUseTheirStoredPet() {
        assertEquals("Ada, has a friend called Toothless (dragon)", new Person("Ada").toString());
        assertEquals("Lilo, has a friend called Stitch (blue alien)", new Person().toString());
    }
    @Test void returnsWithoutPrinting() {
        java.io.PrintStream previous = System.out;
        java.io.ByteArrayOutputStream bytes = new java.io.ByteArrayOutputStream();
        try {
            System.setOut(new java.io.PrintStream(bytes));
            assertTrue(new Person("Leo", new Pet("Lucy", "dog")).toString().contains("Lucy"));
            assertEquals("", bytes.toString());
        } finally { System.setOut(previous); }
    }
}
