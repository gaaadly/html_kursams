package lt.techin.oop;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;
import static lt.techin.testing.Contract.*;
@Timeout(5)
class AssignmentTest {
    @Test void gettersReturnStoredValues() { Song s = new Song("In The Garden", 10910); assertEquals("In The Garden", s.getName()); assertEquals(10910, s.getLength()); }
    @Test void independentAndSilent() throws Exception { Song a = new Song("A", 1), b = new Song("B", 200); assertEquals("A", a.getName()); assertEquals(200, b.getLength()); fields(Song.class, "name", "length"); assertEquals("", output(() -> { new Song("C", 3).getName(); })); }
}
