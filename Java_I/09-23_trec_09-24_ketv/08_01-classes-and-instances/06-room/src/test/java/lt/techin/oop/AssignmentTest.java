package lt.techin.oop;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;
import static lt.techin.testing.Contract.*;
@Timeout(5)
class AssignmentTest {
    @Test void storesBothArguments() throws Exception {
        Room r = new Room("JAVA26", 24);
        fields(Room.class, "code", "seats");
        var code = field(Room.class, "code"); code.setAccessible(true);
        var seats = field(Room.class, "seats"); seats.setAccessible(true);
        assertEquals("JAVA26", code.get(r)); assertEquals(24, seats.getInt(r));
    }
    @Test void separateRoomsAndSilence() throws Exception {
        Room a = new Room("A", 12), b = new Room("B", 30);
        var code = field(Room.class, "code"); code.setAccessible(true);
        var seats = field(Room.class, "seats"); seats.setAccessible(true);
        assertEquals("A", code.get(a)); assertEquals(12, seats.getInt(a));
        assertEquals("B", code.get(b)); assertEquals(30, seats.getInt(b));
        assertEquals("", output(() -> new Room("C", 8)));
    }
}
