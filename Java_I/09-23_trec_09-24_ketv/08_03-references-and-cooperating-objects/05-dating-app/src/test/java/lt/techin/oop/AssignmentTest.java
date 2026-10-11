package lt.techin.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;

@Timeout(5)
class AssignmentTest {
    @Test void nextDayAndMonthYearRollover() {
        SimpleDate date = new SimpleDate(29, 12, 2011);
        date.advance(); assertEquals("30.12.2011", date.toString());
        date.advance(); assertEquals("1.1.2012", date.toString());
        new SimpleDate(1, 1, 2012).advance();
    }
    @Test void manyDaysAndZero() {
        SimpleDate date = new SimpleDate(13, 2, 2015);
        date.advance(0); assertEquals("13.2.2015", date.toString());
        date.advance(21); assertEquals("4.3.2015", date.toString());
        date.advance(360); assertEquals("4.3.2016", date.toString());
    }
    @Test void returnedDateIsDistinctAndOriginalUnchanged() {
        SimpleDate now = new SimpleDate(30, 12, 2011);
        SimpleDate later = now.afterNumberOfDays(5);
        assertNotNull(later, "afterNumberOfDays must return a new date");
        assertNotSame(now, later);
        assertEquals("30.12.2011", now.toString());
        assertEquals("5.1.2012", later.toString());
        later.advance(); assertEquals("30.12.2011", now.toString());
        assertEquals("30.12.2011", now.afterNumberOfDays(0).toString());
    }
    @Test void existingComparisonStillWorks() {
        SimpleDate first = new SimpleDate(1, 1, 2012);
        assertTrue(first.before(new SimpleDate(2, 1, 2012)));
        assertFalse(first.before(new SimpleDate(1, 1, 2012)));
    }
}
