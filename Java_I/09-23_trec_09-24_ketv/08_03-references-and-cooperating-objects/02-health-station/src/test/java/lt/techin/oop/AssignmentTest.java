package lt.techin.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;
import static lt.techin.testing.Contract.*;
@Timeout(5)
class AssignmentTest {
    @Test void countsWeighingsOnly(){HealthStation s=new HealthStation();Person p=new Person("Ada",60);assertEquals(0,s.weighings());assertEquals(60,s.weigh(p));s.feed(p);assertEquals(1,s.weighings());assertEquals(61,s.weigh(p));assertEquals(2,s.weighings());}
    @Test void suppliedPersonChanges(){HealthStation s=new HealthStation();Person a=new Person("A",10),b=new Person("B",20);s.feed(a);s.feed(a);assertEquals(12,a.getWeight());assertEquals(20,b.getWeight());assertEquals(0,s.weighings());}
    @Test void stationsAreIndependent() throws Exception {HealthStation a=new HealthStation(),b=new HealthStation();Person p=new Person("P",30);a.weigh(p);a.weigh(p);b.weigh(p);assertEquals(2,a.weighings());assertEquals(1,b.weighings());fields(HealthStation.class,"count");}

}
