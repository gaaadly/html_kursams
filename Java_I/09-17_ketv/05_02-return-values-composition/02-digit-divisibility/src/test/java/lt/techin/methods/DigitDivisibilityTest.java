package lt.techin.methods;

import com.sun.source.tree.Tree;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import lt.techin.testing.ConsoleCheck;
import lt.techin.testing.MethodCheck;
import lt.techin.testing.SourceCheck;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;

@Timeout(2)
class DigitDivisibilityTest {
    private Method digitSum() {
        return MethodCheck.require(DigitDivisibility.class, "digitSum", int.class, int.class);
    }
    private Method countDivisible() {
        return MethodCheck.require(DigitDivisibility.class, "countDivisible", long.class,
                int.class, int.class);
    }
    @Test void sumsDigitsAcrossSignsAndIntLimits() {
        assertEquals(0, (int) MethodCheck.invoke(digitSum(), 0));
        assertEquals(3, (int) MethodCheck.invoke(digitSum(), 12));
        assertEquals(3, (int) MethodCheck.invoke(digitSum(), -120));
        assertEquals(46, (int) MethodCheck.invoke(digitSum(), Integer.MAX_VALUE));
        assertEquals(47, (int) MethodCheck.invoke(digitSum(), Integer.MIN_VALUE));
    }
    @Test void countsClosedIntervalsAndExcludesZero() {
        assertEquals(2L, (long) MethodCheck.invoke(countDivisible(), 10, 15));
        assertEquals(2L, (long) MethodCheck.invoke(countDivisible(), -15, -10));
        assertEquals(0L, (long) MethodCheck.invoke(countDivisible(), 0, 0));
        assertEquals(0L, (long) MethodCheck.invoke(countDivisible(), Integer.MAX_VALUE, Integer.MAX_VALUE));
    }
    @Test void counterReusesDigitSum() throws Exception {
        SourceCheck.method("lt.techin.methods.DigitDivisibility", "countDivisible", 2)
                .requireCall("digitSum");
    }
}
