package lt.techin.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;
import static lt.techin.testing.Contract.*;
import lt.techin.testing.Source;
@Timeout(5)
class AssignmentTest {
    @Test void allOverloads(){Product a=new Product("Tape"),b=new Product("Plaster","tools"),c=new Product("Tyre",5),d=new Product("Box","floor",8);assertEquals("Tape",a.getName());assertEquals("shelf",a.getLocation());assertEquals(1,a.getWeight());assertEquals("Plaster",b.getName());assertEquals("tools",b.getLocation());assertEquals(1,b.getWeight());assertEquals("Tyre",c.getName());assertEquals("shelf",c.getLocation());assertEquals(5,c.getWeight());assertEquals(8,d.getWeight());assertEquals("floor",d.getLocation());}
    @Test void delegatesToCanonical() throws Exception {
    Source.delegates("lt.techin.oop.Product",1,3);
    // Both two-parameter overloads must delegate, not just the first one.
    for(var tree:Source.type("lt.techin.oop.Product").getMembers())if(tree instanceof com.sun.source.tree.MethodTree m && m.getName().contentEquals("<init>") && m.getParameters().size()==2){assertFalse(m.getBody().getStatements().isEmpty(),"Delegate using this(...).");var first=m.getBody().getStatements().getFirst();assertTrue(first instanceof com.sun.source.tree.ExpressionStatementTree);var expr=((com.sun.source.tree.ExpressionStatementTree)first).getExpression();assertTrue(expr instanceof com.sun.source.tree.MethodInvocationTree);var call=(com.sun.source.tree.MethodInvocationTree)expr;assertEquals("this",call.getMethodSelect().toString());assertEquals(3,call.getArguments().size());}
    fields(Product.class,"name","location","weight");}

}
