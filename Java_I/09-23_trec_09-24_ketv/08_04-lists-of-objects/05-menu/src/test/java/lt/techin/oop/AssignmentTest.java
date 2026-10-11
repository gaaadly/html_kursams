package lt.techin.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;
import static lt.techin.testing.Contract.*;
@Timeout(5)
class AssignmentTest {
    @Test void uniqueOrderedMeals(){Menu m=new Menu();m.addMeal("Soup");m.addMeal("Salad");m.addMeal(new String("Soup"));m.addMeal("soup");assertEquals("Soup\nSalad\nsoup\n",output(m::printMeals));}
    @Test void clearAndIndependent(){Menu a=new Menu(),b=new Menu();assertEquals("",output(a::printMeals));a.addMeal("A");b.addMeal("B");a.clearMenu();assertEquals("",output(a::printMeals));assertEquals("B\n",output(b::printMeals));a.addMeal("A");assertEquals("A\n",output(a::printMeals));}
    @Test void fieldAndSilentChanges() throws Exception {fields(Menu.class,"meals");Menu m=new Menu();assertEquals("",output(()->{m.addMeal("X");m.clearMenu();}));}

}
