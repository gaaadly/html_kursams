package lt.techin.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;
import static lt.techin.testing.Contract.*;
@Timeout(5)
class AssignmentTest {
    @Test void empty(){Room r=new Room();assertTrue(r.isEmpty());assertNull(r.shortest());assertNull(r.take());assertTrue(r.getPersons().isEmpty());}
    @Test void stableReferenceSearchAndRemoval(){Room r=new Room();Person a=new Person("A",180),b=new Person("B",160),c=new Person("C",160);r.add(a);r.add(b);r.add(c);assertFalse(r.isEmpty());assertSame(b,r.shortest());assertEquals(java.util.List.of(a,b,c),r.getPersons());assertSame(b,r.take());assertSame(c,r.take());assertSame(a,r.take());assertTrue(r.isEmpty());assertNull(r.take());}
    @Test void copyAndDuplicateReferences() throws Exception {Room r=new Room();Person a=new Person("A",170),equal=new Person("A",170);r.add(a);r.add(equal);r.getPersons().clear();assertSame(a,r.take());assertSame(equal,r.take());fields(Room.class,"persons");}

}
