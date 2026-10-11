package lt.techin.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;
import static lt.techin.testing.Contract.*;
@Timeout(5)
class AssignmentTest {
    @Test void organismCoordinatesAndIndependentState() {
        Organism a=new Organism(20,30),b=new Organism(1,9);assertEquals("x: 20; y: 30",a.toString());
        a.move(-10,5);assertEquals("x: 10; y: 35",a.toString());a.move(50,20);assertEquals("x: 60; y: 55",a.toString());
        a.move(0,0);assertEquals("x: 60; y: 55",a.toString());assertEquals("x: 1; y: 9",b.toString());
    }
    @Test void herdOrderAndAllMembersMove() {
        Herd h=new Herd();assertEquals("",h.toString());h.move(5,-2);
        h.addToHerd(new Organism(5,10));h.addToHerd(new Organism(2,8));
        assertEquals("x: 5; y: 10\nx: 2; y: 8",h.toString());
        h.move(1,-2);assertEquals("x: 6; y: 8\nx: 3; y: 6",h.toString());
        h.move(-8,4);assertEquals("x: -2; y: 12\nx: -5; y: 10",h.toString());assertEquals("",new Herd().toString());
    }
    @Test void delegatesToUnrelatedMovableExactlyOnce() {
        class Cart implements Movable { int calls,dx,dy; public void move(int x,int y){calls++;dx=x;dy=y;}public String toString(){return "cart";} }
        Cart c=new Cart();Herd h=new Herd();h.addToHerd(c);h.addToHerd(new Organism(0,0));
        assertDoesNotThrow(()->h.move(7,-3));assertEquals(1,c.calls);assertEquals(7,c.dx);assertEquals(-3,c.dy);
        assertEquals("cart\nx: 7; y: -3",h.toString());h.addToHerd(c);h.move(0,0);assertEquals(3,c.calls);
    }
    @Test void privateInterfaceCollection() {
        assertTrue(Movable.class.isAssignableFrom(Organism.class));assertTrue(Movable.class.isAssignableFrom(Herd.class));
        boolean list=false;
        for(var f:Herd.class.getDeclaredFields()) {
            assertTrue(java.lang.reflect.Modifier.isPrivate(f.getModifiers()));
            if(f.getGenericType().getTypeName().equals("java.util.List<lt.techin.oop.Movable>"))list=true;
        }
        assertTrue(list,"Store members using List<Movable>.");
        for(var f:Organism.class.getDeclaredFields())assertTrue(java.lang.reflect.Modifier.isPrivate(f.getModifiers()));
    }

}
