package lt.techin.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;
import static lt.techin.testing.Contract.*;
import lt.techin.testing.Source;
@Timeout(5)
class AssignmentTest {
    @Test void nameAndInheritedState(){ProductWarehouse p=new ProductWarehouse("Tea",10);assertEquals("Tea",p.getName());p.addToWarehouse(7);assertEquals(2,p.takeFromWarehouse(2));assertEquals("Tea: balance = 5.0, space left 5.0",p.toString());p.setName("Coffee");assertEquals("Coffee",p.getName());assertEquals("Coffee: balance = 5.0, space left 5.0",p.toString());}
    @Test void boundaries(){ProductWarehouse p=new ProductWarehouse("X",3);p.addToWarehouse(9);assertEquals(3,p.getBalance());p.addToWarehouse(-2);assertEquals(3,p.takeFromWarehouse(8));assertEquals(0,p.getBalance());assertEquals(0,p.takeFromWarehouse(-1));assertEquals(0,new ProductWarehouse("Z",-5).getCapacity());}
    @Test void reuse() throws Exception {assertEquals(Warehouse.class,ProductWarehouse.class.getSuperclass());fields(ProductWarehouse.class,"productName");Source.calls("lt.techin.oop.ProductWarehouse","toString",0,"super","toString");Source.override("lt.techin.oop.ProductWarehouse","toString",0);}

}
