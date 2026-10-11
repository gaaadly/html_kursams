package lt.techin.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;
import static lt.techin.testing.Contract.*;
import lt.techin.testing.Source;
@Timeout(5)
class AssignmentTest {
    @Test void emptySingularPlural(){SimpleCollection c=new SimpleCollection("letters");assertEquals("The collection letters is empty.",c.toString());c.add("a");assertEquals("The collection letters has 1 element:\na",c.toString());c.add("b");c.add("a");assertEquals("The collection letters has 3 elements:\na\nb\na",c.toString());}
    @Test void returnsWithoutPrinting() throws Exception {SimpleCollection c=new SimpleCollection("names");c.add("Ada");assertEquals("",output(c::toString));assertEquals("The collection names has 1 element:\nAda",c.toString());assertEquals(java.util.List.of("Ada"),c.getElements());Source.override("lt.techin.oop.SimpleCollection","toString",0);}

}
