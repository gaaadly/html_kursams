package lt.techin.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;
import static lt.techin.testing.Contract.*;
@Timeout(5)
class AssignmentTest {
    @Test void depletionAndZeroFloor() {
        for(int initial:new int[]{0,1,5,10,100}) {
            TacoBox box=new CustomTacoBox(initial);
            for(int i=0;i<initial+3;i++) { assertEquals(Math.max(0,initial-i),box.tacosRemaining());box.eat(); }
        }
        TacoBox box=new TripleTacoBox();assertEquals(3,box.tacosRemaining());box.eat();assertEquals(2,box.tacosRemaining());
    }
    @Test void instancesAreIndependent() {
        TacoBox a=new TripleTacoBox(),b=new TripleTacoBox();a.eat();assertEquals(3,b.tacosRemaining());
        TacoBox c=new CustomTacoBox(7),d=new CustomTacoBox(2);c.eat();assertEquals(6,c.tacosRemaining());assertEquals(2,d.tacosRemaining());
    }
    @Test void lunchUsesAnyImplementation() {
        class Probe implements TacoBox { int count=2,calls=0;public int tacosRemaining(){return count;}public void eat(){count--;calls++;} }
        Probe p=new Probe();TacoBox empty=new CustomTacoBox(0),one=new CustomTacoBox(1);
        assertEquals(2,TacoLunch.eatFromEach(new TacoBox[]{p,empty,one}));assertEquals(1,p.calls);
        assertEquals(1,TacoLunch.eatFromEach(new TacoBox[]{p,empty,one}));assertEquals(2,p.calls);
        assertEquals(0,TacoLunch.eatFromEach(new TacoBox[0]));
    }
    @Test void privatePerObjectState() {
        for(Class<?> type:new Class<?>[]{TripleTacoBox.class,CustomTacoBox.class}) for(var f:type.getDeclaredFields()) {
            if(f.isSynthetic())continue;
            assertTrue(java.lang.reflect.Modifier.isPrivate(f.getModifiers()),"Keep state private.");
            assertFalse(java.lang.reflect.Modifier.isStatic(f.getModifiers())&&!java.lang.reflect.Modifier.isFinal(f.getModifiers()),"Counts belong to each box.");
        }
    }

}
