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
class DecimalDivisionTest {
    private Method divide() {
        return MethodCheck.require(DecimalDivision.class, "divide", double.class,
                int.class, int.class);
    }
    @Test void returnsFractionalResults() {
        assertEquals(3.5, (double) MethodCheck.invoke(divide(), 7, 2));
        assertEquals(0.5, (double) MethodCheck.invoke(divide(), 2, 4));
        assertEquals(-2.5, (double) MethodCheck.invoke(divide(), -5, 2));
    }
    @Test void doesNotPrintTheResult() {
        assertEquals("", ConsoleCheck.run(() -> MethodCheck.invoke(divide(), 9, 4)));
    }
}
