package lt.techin.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;
import static lt.techin.testing.Contract.*;
import lt.techin.testing.Source;
@Timeout(5)
class AssignmentTest {
    @Test void emptyAndClear(){ChangeHistory h=new ChangeHistory();assertEquals("[]",h.toString());assertEquals(0,h.minValue());assertEquals(0,h.maxValue());assertEquals(0,h.average());h.add(3);h.clear();assertEquals("[]",h.toString());assertEquals(0,h.average());h.add(2);assertEquals(2,h.average());}
    @Test void statisticsPreserveOrder(){ChangeHistory h=new ChangeHistory();h.add(3);h.add(-2);h.add(8);assertEquals(-2,h.minValue());assertEquals(8,h.maxValue());assertEquals(3,h.average(),1e-9);assertEquals("[3.0, -2.0, 8.0]",h.toString());h.clear();h.add(-5);h.add(-1);assertEquals(-1,h.maxValue());assertEquals(-5,h.minValue());assertEquals(-3,h.average());}
    @Test void privateListAndSilence() throws Exception {fields(ChangeHistory.class,"values");assertTrue(java.util.List.class.isAssignableFrom(field(ChangeHistory.class,"values").getType()));assertEquals("",output(()->new ChangeHistory().toString()));Source.override("lt.techin.oop.ChangeHistory","toString",0);}

}
