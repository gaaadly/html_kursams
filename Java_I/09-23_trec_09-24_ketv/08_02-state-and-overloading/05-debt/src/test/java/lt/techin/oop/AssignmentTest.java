package lt.techin.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;
import static lt.techin.testing.Contract.*;
@Timeout(5)
class AssignmentTest {
    @Test void compounds(){Debt d=new Debt(1000,1.05);assertEquals(1000,d.getBalance());d.waitOneYear();assertEquals(1050,d.getBalance(),1e-8);d.waitOneYear();assertEquals(1102.5,d.getBalance(),1e-8);}
    @Test void multiplierOneAndZero(){Debt a=new Debt(90,1),b=new Debt(0,1.2);for(int i=0;i<5;i++){a.waitOneYear();b.waitOneYear();}assertEquals(90,a.getBalance());assertEquals(0,b.getBalance());}
    @Test void printingAndSilence() throws Exception {Debt d=new Debt(12,2);assertEquals("",output(()->d.waitOneYear()));assertEquals("24.0\n",output(()->d.printBalance()));assertEquals("",output(()->new Debt(9,1.1)));fields(Debt.class,"balance","interestRate");}

}
