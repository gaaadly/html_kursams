package lt.techin.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;
import static lt.techin.testing.Contract.*;
@Timeout(5)
class AssignmentTest {
    @Test void areaNotRooms(){Apartment a=new Apartment(1,50,100),b=new Apartment(3,40,200);assertTrue(a.largerThan(b));assertFalse(b.largerThan(a));assertFalse(a.largerThan(a));}
    @Test void totalPriceAndSymmetry(){Apartment a=new Apartment(1,16,5500),b=new Apartment(2,38,4200);assertEquals(71600,a.priceDifference(b));assertEquals(71600,b.priceDifference(a));assertTrue(b.moreExpensiveThan(a));assertFalse(a.moreExpensiveThan(b));}
    @Test void equalityAndDifferentAreaSamePrice() throws Exception {Apartment a=new Apartment(1,20,100),b=new Apartment(2,40,50);assertEquals(0,a.priceDifference(b));assertFalse(a.moreExpensiveThan(b));assertFalse(b.moreExpensiveThan(a));fields(Apartment.class,"rooms","squares","pricePerSquare");}

}
