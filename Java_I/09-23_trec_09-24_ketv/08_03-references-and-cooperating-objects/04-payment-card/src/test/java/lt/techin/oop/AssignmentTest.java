package lt.techin.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;
import static lt.techin.testing.Contract.*;
import lt.techin.testing.Source;
@Timeout(5)
class AssignmentTest {
    @Test void pricesAndExactFunds(){PaymentCard a=new PaymentCard(2.6),b=new PaymentCard(4.6);a.eatAffordably();b.eatHeartily();assertEquals(0,a.getBalance(),1e-9);assertEquals(0,b.getBalance(),1e-9);}
    @Test void insufficientAndTopups(){PaymentCard c=new PaymentCard(5);c.eatHeartily();c.eatHeartily();c.eatAffordably();assertEquals(.4,c.getBalance(),1e-9);c.addMoney(-10);assertEquals(.4,c.getBalance(),1e-9);c.addMoney(10);assertEquals(10.4,c.getBalance(),1e-9);c.addMoney(200);assertEquals(150,c.getBalance());c.addMoney(0);assertEquals(150,c.getBalance());}
    @Test void independentAndFormatted(){PaymentCard a=new PaymentCard(20),b=new PaymentCard(30);a.eatHeartily();assertEquals(30,b.getBalance());assertEquals("The card has a balance of 15.40 euros",a.toString());assertEquals("",output(()->a.toString()));}
    @Test void sixLineScenario(){assertEquals("Paul: The card has a balance of 15.40 euros\nMatt: The card has a balance of 27.40 euros\nPaul: The card has a balance of 35.40 euros\nMatt: The card has a balance of 22.80 euros\nPaul: The card has a balance of 30.20 euros\nMatt: The card has a balance of 72.80 euros",CardDemo.scenario());}
    @Test void fieldsAndConstants() throws Exception {fields(PaymentCard.class,"balance");String[] names={"AFFORDABLE_PRICE","HEARTY_PRICE","MAX_BALANCE"};double[] values={2.6,4.6,150};for(int i=0;i<3;i++){var f=field(PaymentCard.class,names[i]);assertTrue(java.lang.reflect.Modifier.isPublic(f.getModifiers()));assertTrue(java.lang.reflect.Modifier.isStatic(f.getModifiers()));assertTrue(java.lang.reflect.Modifier.isFinal(f.getModifiers()));assertEquals(double.class,f.getType());assertEquals(values[i],f.getDouble(null),1e-9);}assertTrue(Source.usesIdentifier("lt.techin.oop.PaymentCard","eatAffordably",0,"AFFORDABLE_PRICE"));assertTrue(Source.usesIdentifier("lt.techin.oop.PaymentCard","eatHeartily",0,"HEARTY_PRICE"));assertTrue(Source.usesIdentifier("lt.techin.oop.PaymentCard","addMoney",1,"MAX_BALANCE"));}

}
