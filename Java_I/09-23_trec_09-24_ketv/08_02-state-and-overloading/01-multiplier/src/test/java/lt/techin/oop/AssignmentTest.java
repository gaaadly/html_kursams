package lt.techin.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;
import static lt.techin.testing.Contract.*;
@Timeout(5)
class AssignmentTest {
    @Test void factorsBelongToObjects(){Multiplier a=new Multiplier(3),b=new Multiplier(4);assertEquals(6,a.multiply(2));assertEquals(8,b.multiply(2));assertEquals(3,a.multiply(1));}
    @Test void signsAndZero(){assertEquals(-15,new Multiplier(-3).multiply(5));assertEquals(12,new Multiplier(-3).multiply(-4));assertEquals(0,new Multiplier(9).multiply(0));}
    @Test void silentAndPrivate() throws Exception {fields(Multiplier.class,"factor");assertEquals("",output(()->new Multiplier(3).multiply(9)));}

}
