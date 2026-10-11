package lt.techin.oop;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class AssignmentTest {
    @Test void cardCanPayExactlyAndRejectOverdraft() {
        PaymentCard card = new PaymentCard(10);
        assertTrue(card.takeMoney(8)); assertEquals(2, card.balance(), 0.00001);
        assertFalse(card.takeMoney(4)); assertEquals(2, card.balance(), 0.00001);
        assertTrue(card.takeMoney(2)); assertEquals(0, card.balance(), 0.00001);
    }
    @Test void cashSalesAndFailures() {
        PaymentTerminal t = new PaymentTerminal();
        assertEquals("money: 1000.0, number of sold affordable meals: 0, number of sold hearty meals: 0", t.toString());
        assertEquals(2, t.eatAffordably(2), 0.00001);
        assertEquals(4, t.eatHeartily(4), 0.00001);
        assertEquals(7.5, t.eatAffordably(10), 0.00001);
        assertEquals(0, t.eatHeartily(4.3), 0.00001);
        assertEquals("money: 1006.8, number of sold affordable meals: 1, number of sold hearty meals: 1", t.toString());
    }
    @Test void cardSalesDoNotAddCashAndTopUpsDo() {
        PaymentTerminal t = new PaymentTerminal(); PaymentCard c = new PaymentCard(7);
        assertTrue(t.eatHeartily(c)); assertFalse(t.eatHeartily(c)); assertTrue(t.eatAffordably(c));
        assertEquals(0.2, c.balance(), 0.00001);
        assertEquals("money: 1000.0, number of sold affordable meals: 1, number of sold hearty meals: 1", t.toString());
        t.addMoneyToCard(c, -10); assertEquals(0.2, c.balance(), 0.00001);
        t.addMoneyToCard(c, 100); assertEquals(100.2, c.balance(), 0.00001);
        assertEquals("money: 1100.0, number of sold affordable meals: 1, number of sold hearty meals: 1", t.toString());
    }
    @Test void cardAndTerminalKeepOnlySpecifiedInstanceFields() {
        assertEquals(1, java.util.Arrays.stream(PaymentCard.class.getDeclaredFields()).filter(f -> !java.lang.reflect.Modifier.isStatic(f.getModifiers())).count());
        assertEquals(3, java.util.Arrays.stream(PaymentTerminal.class.getDeclaredFields()).filter(f -> !java.lang.reflect.Modifier.isStatic(f.getModifiers())).count());
    }
}
