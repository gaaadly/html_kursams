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
class FourNumberStatsTest {
    private Method sum() {
        return MethodCheck.require(FourNumberStats.class, "sum", int.class,
                int.class, int.class, int.class, int.class);
    }
    private Method average() {
        return MethodCheck.require(FourNumberStats.class, "average", double.class,
                int.class, int.class, int.class, int.class);
    }
    @Test void sumsPositiveNegativeAndBoundaryValues() {
        assertEquals(14, (int) MethodCheck.invoke(sum(), 4, 3, 6, 1));
        assertEquals(3, (int) MethodCheck.invoke(sum(), 1, 2, -1, 1));
        assertEquals(Integer.MAX_VALUE,
                (int) MethodCheck.invoke(sum(), 0, 0, 0, Integer.MAX_VALUE));
    }
    @Test void returnsFractionalAverage() {
        assertEquals(3.5, (double) MethodCheck.invoke(average(), 4, 3, 6, 1));
        assertEquals(-0.5, (double) MethodCheck.invoke(average(), -12, 2, 8, 0));
    }
    @Test void averageReusesSum() throws Exception {
        SourceCheck.method("lt.techin.methods.FourNumberStats", "average", 4).requireCall("sum");
    }
}
