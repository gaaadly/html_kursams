package lt.techin.oop;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;
import static lt.techin.testing.Contract.*;
@Timeout(5)
class AssignmentTest {
    @Test void knocksTwice() { Door d = new Door(); assertEquals("Who's there?\nWho's there?\n", output(() -> { d.knock(); d.knock(); })); }
    @Test void noStateOrConstructorOutput() throws Exception { fields(Door.class); assertEquals("", output(Door::new)); }
}
