package lt.techin.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;
import static lt.techin.testing.Contract.*;
import lt.techin.testing.Source;
@Timeout(5)
class AssignmentTest {
    void laws(Object a,Object b,Object c,Object other){assertNotSame(a,b);assertEquals(a,a);assertEquals(a,b);assertEquals(b,a);assertEquals(b,c);assertEquals(a,c);assertEquals(a,b);assertFalse(a.equals(null));assertFalse(a.equals("unrelated"));assertFalse(a.equals(other));assertFalse(other.equals(a));assertEquals(a.hashCode(),b.hashCode());assertEquals(b.hashCode(),c.hashCode());}

    Person p(String name,int day,int month,int year,int height,int weight){return new Person(name,new SimpleDate(day,month,year),height,weight);}
    @Test void nestedContract(){laws(p("Ada",1,2,2000,170,60),p("Ada",1,2,2000,170,60),p("Ada",1,2,2000,170,60),p("Lin",1,2,2000,170,60));}
    @Test void eachFieldMatters(){Person a=p("Ada",1,2,2000,170,60);assertNotEquals(a,p("Ada",2,2,2000,170,60));assertNotEquals(a,p("Ada",1,3,2000,170,60));assertNotEquals(a,p("Ada",1,2,2001,170,60));assertNotEquals(a,p("Ada",1,2,2000,171,60));assertNotEquals(a,p("Ada",1,2,2000,170,61));}
    @Test void declarations() throws Exception {fields(Person.class,"name","birthday","height","weight");Source.override("lt.techin.oop.Person","equals",1);Source.override("lt.techin.oop.Person","hashCode",0);}

}
