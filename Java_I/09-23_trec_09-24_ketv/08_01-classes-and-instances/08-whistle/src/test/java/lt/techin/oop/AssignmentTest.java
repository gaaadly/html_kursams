package lt.techin.oop;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;
import static lt.techin.testing.Contract.*;
@Timeout(5)
class AssignmentTest {
    @Test void separateSounds() { Whistle a = new Whistle("Kvaak"), b = new Whistle("Peef"); assertEquals("Kvaak\nPeef\nKvaak\n", output(() -> { a.sound(); b.sound(); a.sound(); })); }
    @Test void privateFieldAndSilentConstruction() throws Exception { fields(Whistle.class, "sound"); assertEquals("", output(() -> new Whistle("tweet"))); }
}
