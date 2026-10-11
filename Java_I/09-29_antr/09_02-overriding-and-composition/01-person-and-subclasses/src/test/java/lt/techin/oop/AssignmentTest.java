package lt.techin.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;
import static lt.techin.testing.Contract.*;
import lt.techin.testing.Source;
@Timeout(5)
class AssignmentTest {
    @Test void stateAndDescriptions(){assertEquals("Ada\n  V",new Person("Ada","V").toString());Student s=new Student("Lin","K");assertEquals(0,s.credits());for(int i=0;i<25;i++)s.study();assertEquals(25,s.credits());assertEquals("Lin\n  K\n  Study credits 25",s.toString());assertEquals(0,new Student("Other","R").credits());assertEquals("T\n  X\n  salary 5400 euro/month",new Teacher("T","X",5400).toString());}
    @Test void listDispatch(){Person x=new Person("x","y"){@Override public String toString(){return "guest";}};assertEquals("A\n  B\n  Study credits 0\nT\n  V\n  salary 1200 euro/month\nguest\n",output(()->Main.printPersons(java.util.List.of(new Student("A","B"),new Teacher("T","V",1200),x))));assertEquals("",output(()->Main.printPersons(java.util.List.of())));}
    @Test void structureAndReuse() throws Exception {assertEquals(Person.class,Student.class.getSuperclass());assertEquals(Person.class,Teacher.class.getSuperclass());fields(Person.class,"name","address");fields(Student.class,"credits");fields(Teacher.class,"salary");for(String n:java.util.List.of("Student","Teacher")){Source.calls("lt.techin.oop."+n,"toString",0,"super","toString");Source.override("lt.techin.oop."+n,"toString",0);}}

}
