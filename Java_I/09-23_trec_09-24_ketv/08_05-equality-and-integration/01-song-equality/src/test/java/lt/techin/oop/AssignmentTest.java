package lt.techin.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;
import static lt.techin.testing.Contract.*;
import lt.techin.testing.Source;
@Timeout(5)
class AssignmentTest {
    void laws(Object a,Object b,Object c,Object other){assertNotSame(a,b);assertEquals(a,a);assertEquals(a,b);assertEquals(b,a);assertEquals(b,c);assertEquals(a,c);assertEquals(a,b);assertFalse(a.equals(null));assertFalse(a.equals("unrelated"));assertFalse(a.equals(other));assertFalse(other.equals(a));assertEquals(a.hashCode(),b.hashCode());assertEquals(b.hashCode(),c.hashCode());}

    @Test void contract(){laws(new Song("A","Road",180),new Song("A","Road",180),new Song("A","Road",180),new Song("B","Road",180));}
    @Test void eachFieldMatters(){Song a=new Song("A","Road",180);assertNotEquals(a,new Song("A","Sea",180));assertNotEquals(a,new Song("A","Road",181));assertNotEquals(new Song("X","Y",0),new Song("Z","Q",1));}
    @Test void overridesAndState() throws Exception {fields(Song.class,"artist","name","durationInSeconds");for(String m:java.util.List.of("equals","hashCode"))Source.override("lt.techin.oop.Song",m,m.equals("equals")?1:0);assertEquals("A: Road (180 s)",new Song("A","Road",180).toString());}

}
