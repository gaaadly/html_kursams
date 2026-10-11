package lt.techin.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;
import static lt.techin.testing.Contract.*;
@Timeout(5)
class AssignmentTest {
    @Test void gift(){Gift g=new Gift("Book",2);assertEquals("Book",g.getName());assertEquals(2,g.getWeight());assertEquals("Book (2 kg)",g.toString());assertEquals("Air (0 kg)",new Gift("Air",0).toString());}
    @Test void packageTotals(){Package p=new Package();assertEquals(0,p.totalWeight());Gift g=new Gift("Book",2);p.addGift(g);p.addGift(new Gift("Pen",1));p.addGift(g);assertEquals(5,p.totalWeight());assertEquals(0,new Package().totalWeight());}
    @Test void privateComposition() throws Exception {fields(Gift.class,"name","weight");fields(Package.class,"gifts");assertEquals(Object.class,Package.class.getSuperclass());}

}
