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
class SmallestAndGreatestTest {
    private Method smallest() {
        return MethodCheck.require(SmallestAndGreatest.class, "smallest", int.class,
                int.class, int.class);
    }
    private Method greatest() {
        return MethodCheck.require(SmallestAndGreatest.class, "greatest", int.class,
                int.class, int.class, int.class);
    }
    @Test void findsTheSmallestInEitherOrder() {
        assertEquals(2, (int) MethodCheck.invoke(smallest(), 2, 7));
        assertEquals(-5, (int) MethodCheck.invoke(smallest(), 4, -5));
        assertEquals(9, (int) MethodCheck.invoke(smallest(), 9, 9));
    }
    @Test void findsGreatestInEveryPositionAndWithTies() {
        assertEquals(7, (int) MethodCheck.invoke(greatest(), 7, 2, 3));
        assertEquals(7, (int) MethodCheck.invoke(greatest(), 2, 7, 3));
        assertEquals(7, (int) MethodCheck.invoke(greatest(), 2, 3, 7));
        assertEquals(-4, (int) MethodCheck.invoke(greatest(), -5, -8, -4));
        assertEquals(9, (int) MethodCheck.invoke(greatest(), 9, 9, 9));
    }
}
