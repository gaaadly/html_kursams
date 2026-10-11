package lt.techin.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;
import static lt.techin.testing.Contract.*;
import lt.techin.testing.Source;
@Timeout(5)
class AssignmentTest {
    @Test void checkpoint01ColoredCircle(){Circle c=new Circle(4,"green");assertEquals(4,c.getRadius());assertEquals("green",c.getColor());}
    @Test void checkpoint02NegativeRadius(){Circle c=new Circle(-2,"blue");assertEquals(0,c.getRadius());assertEquals("blue",c.getColor());}
    @Test void checkpoint03AllOverloads(){assertEquals(1,new Circle().getRadius());assertEquals("red",new Circle().getColor());assertEquals(2.5,new Circle(2.5).getRadius());assertEquals("red",new Circle(2.5).getColor());assertEquals(0,new Circle(-1).getRadius());}
    @Test void checkpoint04Delegation() throws Exception {Source.delegates("lt.techin.oop.Circle",0,2);Source.delegates("lt.techin.oop.Circle",1,2);fields(Circle.class,"radius","color");}
    @Test void checkpoint05EarlierSetters(){Circle a=new Circle(2,"blue"),b=new Circle(4,"green");a.setRadius(3);a.setColor("gold");assertEquals(9*Math.PI,a.getArea(),1e-9);assertEquals("gold",a.getColor());assertEquals(4,b.getRadius());assertEquals("green",b.getColor());a.setRadius(-4);assertEquals(0,a.getRadius());}

}
