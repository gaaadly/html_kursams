package lt.techin.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;
import static lt.techin.testing.Contract.*;
@Timeout(5)
class AssignmentTest {
    @Test void empty(){Statistics s=new Statistics();assertEquals(0,s.getCount());assertEquals(0,s.sum());assertEquals(0,s.average());}
    @Test void decimalAndMixedSigns(){Statistics s=new Statistics();s.addNumber(2);s.addNumber(5);assertEquals(2,s.getCount());assertEquals(7,s.sum());assertEquals(3.5,s.average(),1e-9);s.addNumber(-4);assertEquals(3,s.getCount());assertEquals(3,s.sum());assertEquals(1,s.average(),1e-9);}
    @Test void independent() throws Exception {Statistics a=new Statistics(),b=new Statistics();a.addNumber(9);b.addNumber(-2);assertEquals(9,a.sum());assertEquals(-2,b.sum());assertEquals(1,a.getCount());fields(Statistics.class,"count","sum");}

}
