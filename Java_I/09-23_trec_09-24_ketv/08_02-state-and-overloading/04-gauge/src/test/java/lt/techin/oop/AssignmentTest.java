package lt.techin.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;
import static lt.techin.testing.Contract.*;
@Timeout(5)
class AssignmentTest {
    @Test void boundariesAndFull(){Gauge g=new Gauge();g.decrease();assertEquals(0,g.value());assertFalse(g.full());for(int i=1;i<=5;i++){g.increase();assertEquals(i,g.value());assertEquals(i==5,g.full());}g.increase();assertEquals(5,g.value());g.decrease();assertEquals(4,g.value());assertFalse(g.full());for(int i=0;i<8;i++)g.decrease();assertEquals(0,g.value());}
    @Test void separateGauges() throws Exception {Gauge a=new Gauge(),b=new Gauge();a.increase();assertEquals(0,b.value());assertEquals(1,a.value());fields(Gauge.class,"value");}

}
