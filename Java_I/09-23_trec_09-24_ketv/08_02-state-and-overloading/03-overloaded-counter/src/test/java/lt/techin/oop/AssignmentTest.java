package lt.techin.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;
import static lt.techin.testing.Contract.*;
@Timeout(5)
class AssignmentTest {
    @Test void constructors(){assertEquals(0,new Counter().value());assertEquals(-7,new Counter(-7).value());}
    @Test void singleSteps(){Counter c=new Counter(1);c.increase();assertEquals(2,c.value());c.decrease();c.decrease();c.decrease();assertEquals(-1,c.value());}
    @Test void amounts(){Counter c=new Counter(2);c.decrease(5);assertEquals(-3,c.value());c.increase(8);assertEquals(5,c.value());c.increase(-2);c.decrease(-9);c.increase(0);c.decrease(0);assertEquals(5,c.value());}
    @Test void resetAndIndependence() throws Exception {Counter a=new Counter(8),b=new Counter(4);a.reset();assertEquals(0,a.value());assertEquals(4,b.value());fields(Counter.class,"value");}

}
