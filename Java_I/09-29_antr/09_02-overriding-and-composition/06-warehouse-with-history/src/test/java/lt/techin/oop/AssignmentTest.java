package lt.techin.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;
import static lt.techin.testing.Contract.*;
import lt.techin.testing.Source;
@Timeout(5)
class AssignmentTest {
    @Test void recordsResultNotDelta(){ProductWarehouseWithHistory p=new ProductWarehouseWithHistory("Tea",10,5);Warehouse base=p;base.addToWarehouse(9);assertEquals(10,base.takeFromWarehouse(20));assertEquals("[5.0, 10.0, 0.0]",p.history());assertEquals(0,p.getBalance());}
    @Test void initialAndNoChangeBoundaries(){ProductWarehouseWithHistory p=new ProductWarehouseWithHistory("X",3,8);assertEquals("[3.0]",p.history());p.addToWarehouse(0);p.addToWarehouse(-1);assertEquals(0,p.takeFromWarehouse(-2));assertEquals("[3.0, 3.0, 3.0, 3.0]",p.history());assertEquals("[0.0]",new ProductWarehouseWithHistory("Z",-1,9).history());assertEquals("[0.0]",new ProductWarehouseWithHistory("N",5,-2).history());}
    @Test void analysis(){ProductWarehouseWithHistory p=new ProductWarehouseWithHistory("Tea",10,3);p.addToWarehouse(3);p.setName("Coffee");assertEquals("Product: Coffee\nHistory: [3.0, 6.0]\nLargest amount of product: 6.0\nSmallest amount of product: 3.0\nAverage: 4.5\n",output(()->p.printAnalysis()));}
    @Test void reuse() throws Exception {assertEquals(ProductWarehouse.class,ProductWarehouseWithHistory.class.getSuperclass());fields(ProductWarehouseWithHistory.class,"changes");for(String m:java.util.List.of("addToWarehouse","takeFromWarehouse")){Source.calls("lt.techin.oop.ProductWarehouseWithHistory",m,1,"super",m);Source.override("lt.techin.oop.ProductWarehouseWithHistory",m,1);}}

}
