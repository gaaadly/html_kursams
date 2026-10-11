package lt.techin.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;
import static lt.techin.testing.Contract.*;
import lt.techin.testing.Source;
@Timeout(5)
class AssignmentTest {
    void laws(Object a,Object b,Object c,Object other){assertNotSame(a,b);assertEquals(a,a);assertEquals(a,b);assertEquals(b,a);assertEquals(b,c);assertEquals(a,c);assertEquals(a,b);assertFalse(a.equals(null));assertFalse(a.equals("unrelated"));assertFalse(a.equals(other));assertFalse(other.equals(a));assertEquals(a.hashCode(),b.hashCode());assertEquals(b.hashCode(),c.hashCode());}

    @Test void identifierEquality(){laws(new Item("A","First"),new Item("A","Second"),new Item("A","Third"),new Item("B","First"));assertEquals("A: First",new Item("A","First").toString());}
    @Test void retainsFirstAndReturnsCopy(){Archive a=new Archive();Item first=new Item("A","First");assertTrue(a.add(first));assertFalse(a.add(new Item("A","Other")));assertTrue(a.add(new Item("B","First")));assertEquals(2,a.getItems().size());assertSame(first,a.getItems().get(0));a.getItems().clear();assertEquals(2,a.getItems().size());}
    String run(String input){return console(input,()->Main.main(new String[0]));}
    @Test void consoleCases(){assertEquals("Identifier? (empty will stop)\n==Items==\n",run("\n"));String one=run("A\nBook\n\n");assertTrue(one.endsWith("==Items==\nA: Book\n"));assertTrue(run("A\nBook\nB\nPen\n\n").endsWith("==Items==\nA: Book\nB: Pen\n"));assertTrue(run("A\nBook\nB\n\n").endsWith("==Items==\nA: Book\n"));assertTrue(run("A\nBook\nA\nBook\n\n").endsWith("==Items==\nA: Book\n"));assertTrue(run("A\nBook\nA\nOther\n\n").endsWith("==Items==\nA: Book\n"));assertTrue(run("A\nBook\nB\nBook\n\n").endsWith("==Items==\nA: Book\nB: Book\n"));}
    @Test void structure() throws Exception {fields(Item.class,"identifier","name");fields(Archive.class,"items");Source.calls("lt.techin.oop.Archive","add",1,"items","contains");Source.override("lt.techin.oop.Item","equals",1);Source.override("lt.techin.oop.Item","hashCode",0);}

}
