package lt.techin.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;
import static lt.techin.testing.Contract.*;
@Timeout(5)
class AssignmentTest {
    @Test void packableContractAndLeaves() {
        assertTrue(Packable.class.isInterface());var m=assertDoesNotThrow(()->Packable.class.getMethod("weight"),"Declare weight in Packable.");assertEquals(double.class,m.getReturnType());
        assertTrue(java.lang.reflect.Modifier.isAbstract(m.getModifiers()));
        for(Class<?> c:new Class<?>[]{Book.class,CD.class,Box.class})assertTrue(Packable.class.isAssignableFrom(c));
        assertEquals(2.25,new Book("A","Java",2.25).weight(),1e-9);assertEquals(0,new Book("B","Empty",0).weight(),1e-9);
        assertEquals("A: Java",new Book("A","Java",2.25).toString());
        assertEquals(0.1,new CD("Band","Album",2000).weight(),1e-9);assertEquals("Band: Album (2000)",new CD("Band","Album",2000).toString());
    }
    @Test void capacityRejectionAndZero() {
        Box b=new Box(5);assertEquals(0,b.weight(),1e-9);assertEquals("Box: 0 items, total weight 0.0 kg",b.toString());
        b.add(new Book("A","large",6));b.add(new Book("A","one",2));b.add(new Book("B","two",3));b.add(new Book("C","over",1));
        assertEquals(5,b.weight(),1e-9);assertEquals("Box: 2 items, total weight 5.0 kg",b.toString());
        b.add(new Book("D","zero",0));assertEquals("Box: 3 items, total weight 5.0 kg",b.toString());
        Box z=new Box(0);z.add(new Book("A","zero",0));assertEquals("Box: 1 items, total weight 0.0 kg",z.toString());
        assertEquals(0,new Box(5).weight(),1e-9);
    }
    @Test void nestingRecalculatesAndCapacityIsLocal() {
        Box outer=new Box(2),middle=new Box(10),inner=new Box(10);middle.add(inner);outer.add(middle);
        inner.add(new Book("A","First",1.25));assertEquals(1.25,outer.weight(),1e-9);
        inner.add(new Book("B","Second",2));assertEquals(3.25,outer.weight(),1e-9);
        assertEquals("Box: 1 items, total weight 3.3 kg",outer.toString());
        outer.add(new CD("A","B",2020));assertEquals(3.25,outer.weight(),1e-9);
    }
    @Test void arbitraryImplementationAndFormatting() {
        class Stone implements Packable { public double weight(){return 0.375;} }
        Box b=new Box(1);b.add(new Stone());b.add(new Stone());assertEquals(0.75,b.weight(),1e-9);
        java.util.Locale old=java.util.Locale.getDefault();try {java.util.Locale.setDefault(java.util.Locale.GERMANY);assertEquals("Box: 2 items, total weight 0.8 kg",b.toString());}finally{java.util.Locale.setDefault(old);}
    }
    @Test void stateIsPrivate() {
        for(Class<?> c:new Class<?>[]{Book.class,CD.class,Box.class})for(var f:c.getDeclaredFields())if(!f.isSynthetic())assertTrue(java.lang.reflect.Modifier.isPrivate(f.getModifiers()));
    }

}
