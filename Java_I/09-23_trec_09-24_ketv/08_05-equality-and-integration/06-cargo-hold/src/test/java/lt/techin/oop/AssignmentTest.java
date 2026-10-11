package lt.techin.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;
import static lt.techin.testing.Contract.*;
@Timeout(5)
class AssignmentTest {
    @Test void item(){Item i=new Item("Book",2);assertEquals("Book",i.getName());assertEquals(2,i.getWeight());assertEquals("Book (2 kg)",i.toString());}
    @Test void suitcaseCapacityFormattingAndHeaviest(){Suitcase s=new Suitcase(3);assertEquals("no items (0 kg)",s.toString());assertNull(s.heaviestItem());Item book=new Item("Book",2),phone=new Item("Phone",1);s.addItem(book);assertEquals("1 item (2 kg)",s.toString());s.addItem(phone);s.addItem(new Item("Brick",4));assertEquals(3,s.totalWeight());assertEquals("2 items (3 kg)",s.toString());assertSame(book,s.heaviestItem());assertEquals("Book (2 kg)\nPhone (1 kg)\n",output(s::printItems));}
    @Test void holdCapacityAndNestedPrinting(){Hold h=new Hold(3);assertEquals("0 suitcases (0 kg)",h.toString());assertEquals("",output(h::printItems));Suitcase a=new Suitcase(2),b=new Suitcase(1),c=new Suitcase(1);a.addItem(new Item("A",2));b.addItem(new Item("B",1));c.addItem(new Item("C",1));h.addSuitcase(a);assertEquals("1 suitcases (2 kg)",h.toString());h.addSuitcase(b);h.addSuitcase(c);assertEquals("2 suitcases (3 kg)",h.toString());assertEquals("A (2 kg)\nB (1 kg)\n",output(h::printItems));}
    @Test void zeroWeightsDuplicatesAndTies(){Suitcase s=new Suitcase(0);s.addItem(new Item("Air",0));s.addItem(new Item("Heavy",1));assertEquals("1 item (0 kg)",s.toString());Hold h=new Hold(0);h.addSuitcase(s);assertEquals("1 suitcases (0 kg)",h.toString());Suitcase t=new Suitcase(6);Item a=new Item("A",2),b=new Item("B",2);t.addItem(a);t.addItem(b);t.addItem(a);assertEquals(6,t.totalWeight());assertTrue(t.heaviestItem()==a||t.heaviestItem()==b);}
    @Test void compositionFields() throws Exception {fields(Item.class,"name","weight");fields(Suitcase.class,"maximumWeight","items");fields(Hold.class,"maximumWeight","suitcases");}

}
