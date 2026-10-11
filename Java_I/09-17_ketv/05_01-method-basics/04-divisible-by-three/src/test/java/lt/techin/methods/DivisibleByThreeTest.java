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
class DivisibleByThreeTest {
    private Method method() {
        return MethodCheck.require(DivisibleByThree.class, "divisibleByThreeInRange",
                void.class, int.class, int.class);
    }
    @Test void printsDivisibleValuesInOrder() {
        assertEquals("3\n6\n9\n", ConsoleCheck.run(() -> MethodCheck.invoke(method(), 2, 10)));
    }
    @Test void handlesNegativeAndZeroValues() {
        assertEquals("-3\n0\n3\n", ConsoleCheck.run(() -> MethodCheck.invoke(method(), -4, 4)));
    }
    @Test void reversedRangePrintsNothing() {
        assertEquals("", ConsoleCheck.run(() -> MethodCheck.invoke(method(), 5, 2)));
    }
}
