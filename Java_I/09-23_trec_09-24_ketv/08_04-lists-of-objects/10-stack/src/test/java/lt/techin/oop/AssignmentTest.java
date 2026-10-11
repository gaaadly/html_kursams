package lt.techin.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;
import static lt.techin.testing.Contract.*;
@Timeout(5)
class AssignmentTest {
    @Test void emptyAndLifo(){Stack s=new Stack();assertTrue(s.isEmpty());assertNull(s.take());s.add("a");s.add("b");s.add("a");assertFalse(s.isEmpty());assertEquals(java.util.List.of("a","b","a"),s.values());assertEquals("a",s.take());assertEquals("b",s.take());assertEquals("a",s.take());assertTrue(s.isEmpty());assertNull(s.take());}
    @Test void distinctValuesDistinguishLifo(){Stack s=new Stack();s.add("first");s.add("second");s.add("third");assertEquals("third",s.take());assertEquals("second",s.take());assertEquals("first",s.take());}
    @Test void snapshotsAndIndependent() throws Exception {Stack a=new Stack(),b=new Stack();a.add("x");a.values().clear();assertEquals(java.util.List.of("x"),a.values());assertTrue(b.isEmpty());fields(Stack.class,"values");}

}
