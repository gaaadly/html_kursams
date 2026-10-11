package lt.techin.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;
import static lt.techin.testing.Contract.*;
@Timeout(5)
class AssignmentTest {
    @Test void twoNames() { assertEquals("My name is Bond, James Bond",new Agent("James","Bond").toString());assertEquals("My name is Doe, Alex Doe",new Agent("Alex","Doe").toString()); }
    @Test void noSideEffects() { assertEquals("",output(()->{Agent a=new Agent("Ionic","Bond");a.toString();})); }
    @Test void printingUsesRepresentation() {assertEquals("My name is Li, Mei Li\n",output(()->System.out.println(new Agent("Mei","Li"))));}
    @Test void refactoredApi() throws Exception {fields(Agent.class,"firstName","lastName");assertThrows(NoSuchMethodException.class,()->Agent.class.getDeclaredMethod("print"));assertEquals(Agent.class,Agent.class.getMethod("toString").getDeclaringClass());}

}
