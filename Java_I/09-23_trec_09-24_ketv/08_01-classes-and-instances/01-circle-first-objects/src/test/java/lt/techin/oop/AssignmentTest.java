package lt.techin.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;
import static lt.techin.testing.Contract.*;
@Timeout(5)
class AssignmentTest {
    private double radius(Circle c) throws Exception { fields(Circle.class,"radius","color");var f=field(Circle.class,"radius");f.setAccessible(true);return (double)f.get(c); }
    private String color(Circle c) throws Exception { fields(Circle.class,"radius","color");var f=field(Circle.class,"color");f.setAccessible(true);return (String)f.get(c); }
    @Test void checkpoint01DefaultCircle() throws Exception {Circle c=new Circle();assertEquals(1,radius(c));assertEquals("red",color(c));}
    @Test void checkpoint02RadiusConstructor() throws Exception {Circle c=new Circle(2.5);assertEquals(2.5,radius(c));assertEquals("red",color(c));}
    @Test void checkpoint03Values(){assertEquals(3,new Circle(3).getRadius());assertEquals(9*Math.PI,new Circle(3).getArea(),1e-9);assertEquals(0,new Circle(0).getArea());}
    @Test void checkpoint04Client(){assertEquals("First: radius=3.0, area="+(9*Math.PI)+"\nSecond: radius=0.5, area="+(.25*Math.PI),CircleDemo.describe(3,.5));assertEquals("First: radius=1.0, area="+Math.PI+"\nSecond: radius=2.0, area="+(4*Math.PI)+"\n",output(()->CircleDemo.main(new String[0])));}
    @Test void checkpoint05IndependentObjects(){Circle a=new Circle(4),b=new Circle(2);assertEquals(4,a.getRadius());assertEquals(2,b.getRadius());assertEquals("",output(()->{new Circle(7).getArea();}));}

}
