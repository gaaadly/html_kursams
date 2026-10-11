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
class TwoDirectionsTest {
    private Method ascending() {
        return MethodCheck.require(TwoDirections.class, "printAscending", void.class, int.class);
    }
    private Method descending() {
        return MethodCheck.require(TwoDirections.class, "printDescending", void.class, int.class);
    }
    @Test void printsAscendingInclusively() {
        assertEquals("1\n2\n3\n4\n", ConsoleCheck.run(() -> MethodCheck.invoke(ascending(), 4)));
    }
    @Test void printsDescendingInclusively() {
        assertEquals("4\n3\n2\n1\n", ConsoleCheck.run(() -> MethodCheck.invoke(descending(), 4)));
    }
    @Test void nonPositiveBoundsPrintNothing() {
        assertEquals("", ConsoleCheck.run(() -> MethodCheck.invoke(ascending(), 0)));
        assertEquals("", ConsoleCheck.run(() -> MethodCheck.invoke(descending(), -2)));
    }
}
