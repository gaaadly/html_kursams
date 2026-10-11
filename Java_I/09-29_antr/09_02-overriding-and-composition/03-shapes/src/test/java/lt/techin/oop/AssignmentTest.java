package lt.techin.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;
import static lt.techin.testing.Contract.*;
import lt.techin.testing.Source;
@Timeout(5)
class AssignmentTest {
    @Test void defaultsAndOverloads(){Shape s=new Shape();assertEquals("red",s.getColor());assertTrue(s.isFilled());Circle c=new Circle();assertEquals(1,c.getRadius());assertEquals(3,new Circle(3).getRadius());Rectangle r=new Rectangle();assertEquals(1,r.getWidth());assertEquals(1,r.getLength());assertEquals(3,new Rectangle(2,3).getLength());}
    @Test void geometryAndMutation(){Circle c=new Circle(2,"blue",false);assertEquals(4*Math.PI,c.getArea(),1e-9);assertEquals(4*Math.PI,c.getPerimeter(),1e-9);assertFalse(c.isFilled());assertEquals("blue",c.getColor());c.setRadius(3);c.setColor("green");c.setFilled(true);assertEquals(9*Math.PI,c.getArea(),1e-9);assertEquals("green",c.getColor());assertTrue(c.isFilled());Rectangle r=new Rectangle(2,5,"gray",false);assertEquals(10,r.getArea());assertEquals(14,r.getPerimeter());r.setWidth(4);r.setLength(3);assertEquals(4,r.getWidth());assertEquals(3,r.getLength());assertEquals(12,r.getArea());assertEquals(14,r.getPerimeter());}
    @Test void descriptionsAndDispatch(){Shape c=new Circle(2,"blue",false),r=new Rectangle(2,3);String a="A Circle with radius=2.0, which is a subclass of A Shape with color of blue and Not filled",b="A Rectangle with width=2.0 and length=3.0, which is a subclass of A Shape with color of red and filled";assertEquals(a,c.toString());assertEquals(b,r.toString());Shape other=new Shape(){@Override public String toString(){return "other";}};assertEquals(a+"\n"+b+"\nother\n",output(()->Gallery.printShapes(java.util.List.of(c,r,other))));assertEquals("",output(()->Gallery.printShapes(java.util.List.of())));}
    @Test void structureAndDelegation() throws Exception {fields(Shape.class,"color","filled");fields(Circle.class,"radius");fields(Rectangle.class,"width","length");Source.delegates("lt.techin.oop.Shape",0,2);Source.delegates("lt.techin.oop.Circle",0,1);Source.delegates("lt.techin.oop.Circle",1,3);Source.delegates("lt.techin.oop.Rectangle",0,2);Source.delegates("lt.techin.oop.Rectangle",2,4);for(String n:java.util.List.of("Circle","Rectangle")){Source.calls("lt.techin.oop."+n,"toString",0,"super","toString");Source.override("lt.techin.oop."+n,"toString",0);}}

}
