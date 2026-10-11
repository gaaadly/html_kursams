package lt.techin.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;
import static lt.techin.testing.Contract.*;
import lt.techin.testing.Source;
@Timeout(5)
class AssignmentTest {
    @Test void routesIntoSuppliedInstances(){Statistics all=new Statistics(),even=new Statistics(),odd=new Statistics();StatisticsClient.record(4,all,even,odd);StatisticsClient.record(-3,all,even,odd);StatisticsClient.record(-1,all,even,odd);assertEquals(3,all.getCount());assertEquals(0,all.sum());assertEquals(1,even.getCount());assertEquals(4,even.sum());assertEquals(2,odd.getCount());assertEquals(-4,odd.sum());}
    @Test void summaryUsesGivenObjects(){Statistics a=new Statistics(),e=new Statistics(),o=new Statistics();a.addNumber(99);e.addNumber(8);o.addNumber(91);assertEquals("Sum: 99\nSum of even numbers: 8\nSum of odd numbers: 91",StatisticsClient.summary(a,e,o));}
    @Test void consoleMixed(){assertEquals("Enter numbers:\nSum: 13\nSum of even numbers: 8\nSum of odd numbers: 5\n",console("4\n2\n5\n2\n-1\n",()->StatisticsClient.main(new String[0])));}
    @Test void consoleEmptyAndNegatives(){assertEquals("Enter numbers:\nSum: 0\nSum of even numbers: 0\nSum of odd numbers: 0\n",console("-1\n",()->StatisticsClient.main(new String[0])));assertEquals("Enter numbers:\nSum: -5\nSum of even numbers: -2\nSum of odd numbers: -3\n",console("-3\n-2\n-1\n",()->StatisticsClient.main(new String[0])));}
    @Test void mainUsesHelpers() throws Exception {assertTrue(Source.usesIdentifier("lt.techin.oop.StatisticsClient","main",1,"record"));assertTrue(Source.usesIdentifier("lt.techin.oop.StatisticsClient","main",1,"summary"));}

}
