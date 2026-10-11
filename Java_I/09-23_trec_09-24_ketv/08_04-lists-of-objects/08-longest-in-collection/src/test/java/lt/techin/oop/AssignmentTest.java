package lt.techin.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;
import static lt.techin.testing.Contract.*;
@Timeout(5)
class AssignmentTest {
    @Test void emptyAndSingle(){SimpleCollection c=new SimpleCollection("x");assertNull(c.longest());c.add("");assertEquals("",c.longest());c.add("a");assertEquals("a",c.longest());}
    @Test void longestFirstTieAndOrder(){SimpleCollection c=new SimpleCollection("x");c.add("Ada");c.add("Grace");c.add("Linus");assertEquals("Grace",c.longest());assertEquals(java.util.List.of("Ada","Grace","Linus"),c.getElements());c.add("Alexandra");assertEquals("Alexandra",c.longest());assertEquals("",output(c::longest));}

}
