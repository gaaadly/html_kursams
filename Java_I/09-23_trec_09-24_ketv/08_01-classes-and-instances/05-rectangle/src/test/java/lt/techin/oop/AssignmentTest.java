package lt.techin.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;
import static lt.techin.testing.Contract.*;
@Timeout(5)
class AssignmentTest {
    @Test void defaultRectangle() { Rectangle r=new Rectangle(); assertEquals(1f,r.getLength()); assertEquals(1f,r.getWidth()); assertEquals(1,r.getArea(),1e-8); }
    @Test void dimensionsAndMutation() { Rectangle r=new Rectangle(2.5f,4f); assertEquals(10,r.getArea(),1e-8); assertEquals(13,r.getPerimeter(),1e-8); r.setLength(3);r.setWidth(7);assertEquals(21,r.getArea(),1e-8);assertEquals(20,r.getPerimeter(),1e-8); }
    @Test void zeroAndIndependence() { Rectangle a=new Rectangle(0,5),b=new Rectangle(2,3);a.setWidth(8);assertEquals(0,a.getArea());assertEquals(16,a.getPerimeter());assertEquals(6,b.getArea()); }
    @Test void representationIsSilent() { Rectangle r=new Rectangle(3,2);assertEquals("Rectangle[length=3.0,width=2.0]",r.toString());assertEquals("",output(()->r.toString())); }
    @Test void privateFloatFields() throws Exception { fields(Rectangle.class,"length","width");for(String n:new String[]{"length","width"})assertEquals(float.class,field(Rectangle.class,n).getType()); }

}
