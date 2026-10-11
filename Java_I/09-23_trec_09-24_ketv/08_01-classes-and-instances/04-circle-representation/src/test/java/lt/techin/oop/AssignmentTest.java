package lt.techin.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;
import static lt.techin.testing.Contract.*;
@Timeout(5)
class AssignmentTest {
    @Test void checkpoint01Representation(){assertEquals("Circle[radius=2.0,color=blue]",new Circle(2,"blue").toString());assertEquals("Circle[radius=1.0,color=red]",new Circle().toString());}
    @Test void checkpoint02SilentAndCurrent(){Circle c=new Circle(2,"blue");assertEquals("",output(()->c.toString()));c.setRadius(3);c.setColor("gold");assertEquals("Circle[radius=3.0,color=gold]",c.toString());assertEquals("Circle[radius=3.0,color=gold]\n",output(()->System.out.println(c)));}
    @Test void checkpoint03Client(){assertEquals("Circle[radius=4.0,color=green]\nCircle[radius=4.0,color=green]",CircleDemo.describe(4,"green"));assertEquals("Circle[radius=2.0,color=blue]\nCircle[radius=2.0,color=blue]\n",output(()->CircleDemo.main(new String[0])));}
    @Test void checkpoint04Circumference(){Circle c=new Circle(1);assertEquals(2*Math.PI,c.getCircumference(),1e-9);c.setRadius(2.5);assertEquals(5*Math.PI,c.getCircumference(),1e-9);c.setRadius(-3);assertEquals(0,c.getCircumference());}
    @Test void checkpoint05EarlierBehavior() throws Exception {Circle a=new Circle(3,"green"),b=new Circle();a.setRadius(0);assertEquals(1,b.getRadius());assertEquals("red",b.getColor());assertEquals(9*Math.PI,new Circle(3).getArea(),1e-9);assertEquals(0,new Circle(-3,"blue").getRadius());fields(Circle.class,"radius","color");}

}
