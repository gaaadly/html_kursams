package lt.techin.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;
import static lt.techin.testing.Contract.*;
import lt.techin.testing.Source;
@Timeout(5)
class AssignmentTest {
    @Test void checkpoint01ExistingBehavior(){assertEquals(1,new Circle().getRadius());assertEquals(4*Math.PI,new Circle(2).getArea(),1e-9);}
    @Test void checkpoint02ColorGetter(){assertEquals("red",new Circle().getColor());}
    @Test void checkpoint03ColorSetter(){Circle a=new Circle(),b=new Circle();a.setColor("blue");assertEquals("blue",a.getColor());assertEquals("red",b.getColor());}
    @Test void checkpoint04RadiusBoundary(){Circle a=new Circle(2),b=new Circle(3);a.setRadius(5);assertEquals(25*Math.PI,a.getArea(),1e-9);a.setRadius(-7);assertEquals(0,a.getRadius());assertEquals(0,a.getArea());a.setRadius(0);assertEquals(0,a.getRadius());assertEquals(3,b.getRadius());}
    @Test void checkpoint05ConstructorValidation(){assertEquals(0,new Circle(-4).getRadius());assertEquals("red",new Circle(-4).getColor());}
    @Test void checkpoint06ThisAssignments() throws Exception {fields(Circle.class,"radius","color");Source.assignsThis("lt.techin.oop.Circle","setRadius",1,"radius");Source.assignsThis("lt.techin.oop.Circle","setColor",1,"color");assertEquals("",output(()->{Circle c=new Circle();c.setRadius(8);c.setColor("green");}));}

}
