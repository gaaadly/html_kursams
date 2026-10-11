package lt.techin.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;
import static lt.techin.testing.Contract.*;
@Timeout(5)
class AssignmentTest {
    @Test void itemEqualityAndHashContract() {
        Item a=new Item("Tea",1),b=new Item("Tea",99),c=new Item("Tea");
        assertEquals(a,b);assertEquals(b,a);assertEquals(b,c);assertEquals(a,c);assertEquals(a,a);
        assertEquals(a.hashCode(),b.hashCode());assertEquals(b.hashCode(),c.hashCode());
        assertNotEquals(a,new Item("Coffee",1));assertNotEquals(a,null);assertNotEquals(a,"Tea");
        assertEquals(0,c.getWeight());assertEquals("Tea",a.getName());
    }
    @Test void abstractApi() {
        assertTrue(java.lang.reflect.Modifier.isAbstract(Box.class.getModifiers()),"Make Box abstract.");
        for(String name:new String[]{"add","isInBox"}) {
            var m=assertDoesNotThrow(()->Box.class.getDeclaredMethod(name,Item.class));
            assertTrue(java.lang.reflect.Modifier.isAbstract(m.getModifiers()),name+" must be abstract.");
        }
        for(Class<?> c:new Class<?>[]{BoxWithMaxWeight.class,OneItemBox.class,MisplacingBox.class})assertEquals(Box.class,c.getSuperclass());
    }
    @Test void capacityBoundariesAndRejection() {
        Box b=new BoxWithMaxWeight(5);assertFalse(b.isInBox(new Item("missing")));
        b.add(new Item("large",6));b.add(new Item("a",2));b.add(new Item("b",3));b.add(new Item("over",1));b.add(new Item("zero",0));
        assertFalse(b.isInBox(new Item("large")));assertTrue(b.isInBox(new Item("a")));assertTrue(b.isInBox(new Item("b",50)));
        assertFalse(b.isInBox(new Item("over")));assertTrue(b.isInBox(new Item("zero")));
        Box zero=new BoxWithMaxWeight(0);zero.add(new Item("z",0));zero.add(new Item("n",1));assertTrue(zero.isInBox(new Item("z")));assertFalse(zero.isInBox(new Item("n")));
        Box duplicates=new BoxWithMaxWeight(4);duplicates.add(new Item("x",2));duplicates.add(new Item("x",2));duplicates.add(new Item("y",1));assertFalse(duplicates.isInBox(new Item("y")));
    }
    @Test void firstItemAndMisplacingPolicies() {
        Box b=new OneItemBox();assertFalse(b.isInBox(new Item("a")));b.add(new Item("a",99));b.add(new Item("b"));assertTrue(b.isInBox(new Item("a")));assertFalse(b.isInBox(new Item("b")));
        Box lost=new MisplacingBox();assertFalse(lost.isInBox(new Item("a")));lost.add(new Item("a"));assertFalse(lost.isInBox(new Item("a")));
        assertFalse(new OneItemBox().isInBox(new Item("a")));assertFalse(new BoxWithMaxWeight(5).isInBox(new Item("a")));
    }
    @Test void inheritedBulkMethodDispatchesInOrder() {
        var items=new java.util.ArrayList<Item>(java.util.List.of(new Item("a",2),new Item("b",3),new Item("c",1)));
        Box capacity=new BoxWithMaxWeight(5),one=new OneItemBox(),lost=new MisplacingBox();
        for(Box b:new Box[]{capacity,one,lost})b.add(items);
        assertTrue(capacity.isInBox(new Item("b")));assertFalse(capacity.isInBox(new Item("c")));
        assertTrue(one.isInBox(new Item("a")));assertFalse(one.isInBox(new Item("b")));assertFalse(lost.isInBox(new Item("a")));
        class Probe extends Box { java.util.List<Item> seen=new java.util.ArrayList<>(); public void add(Item i){seen.add(i);}public boolean isInBox(Item i){return false;} }
        Probe p=new Probe();p.add(items);assertEquals(items,p.seen);p.add(new java.util.ArrayList<>());assertEquals(items,p.seen);
    }
    @Test void stateIsPrivateAndPerObject() {
        for(Class<?> c:new Class<?>[]{BoxWithMaxWeight.class,OneItemBox.class,MisplacingBox.class})for(var f:c.getDeclaredFields())if(!f.isSynthetic()) {
            assertTrue(java.lang.reflect.Modifier.isPrivate(f.getModifiers()));
            assertFalse(java.lang.reflect.Modifier.isStatic(f.getModifiers())&&!java.lang.reflect.Modifier.isFinal(f.getModifiers()));
        }
    }

}
