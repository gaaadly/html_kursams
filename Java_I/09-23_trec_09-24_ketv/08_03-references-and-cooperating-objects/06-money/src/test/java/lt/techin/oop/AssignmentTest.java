package lt.techin.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;

@Timeout(5)
class AssignmentTest {
    @Test void additionCarriesAndReturnsNewObject() {
        Money a = new Money(10, 75), b = new Money(3, 50);
        Money sum = a.plus(b);
        assertNotNull(sum, "plus must return a new Money amount");
        assertNotSame(a, sum); assertNotSame(b, sum);
        assertEquals("14.25e", sum.toString());
        assertEquals("10.75e", a.toString()); assertEquals("3.50e", b.toString());
        assertEquals("10.75e", a.plus(new Money(0, 0)).toString());
    }
    @Test void strictAmountComparison() {
        Money a = new Money(2, 5), b = new Money(2, 50);
        assertTrue(a.lessThan(b)); assertFalse(b.lessThan(a));
        assertFalse(a.lessThan(new Money(2, 5)));
        assertTrue(new Money(1, 99).lessThan(new Money(2, 0)));
    }
    @Test void subtractionBorrowsAndClampsAtZero() {
        Money a = new Money(10, 0), b = new Money(3, 50);
        Money result = a.minus(b);
        assertNotNull(result, "minus must return a new Money amount");
        assertNotSame(a, result); assertEquals("6.50e", result.toString());
        Money belowZero = b.minus(a);
        Money exactlyZero = a.minus(new Money(10, 0));
        assertNotNull(belowZero); assertNotNull(exactlyZero);
        assertEquals("0.00e", belowZero.toString());
        assertEquals("0.00e", exactlyZero.toString());
        assertEquals("10.00e", a.toString()); assertEquals("3.50e", b.toString());
    }
    @Test void constructorNormalizesCentsAndKeepsTwoFields() {
        Money amount = new Money(2, 135);
        assertEquals(3, amount.euros()); assertEquals(35, amount.cents());
        assertEquals("3.35e", amount.toString());
        var fields = Money.class.getDeclaredFields();
        assertEquals(2, fields.length);
        for (var field : fields) assertTrue(java.lang.reflect.Modifier.isFinal(field.getModifiers()));
    }
}
