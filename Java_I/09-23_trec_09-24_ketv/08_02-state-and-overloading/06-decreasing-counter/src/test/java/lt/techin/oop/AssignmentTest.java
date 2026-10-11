package lt.techin.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;
import static lt.techin.testing.Contract.*;

@Timeout(5)
class AssignmentTest {
    @Test void stepsAndPrintedLine() {
        DecreasingCounter counter = new DecreasingCounter(10);
        assertEquals("value: 10\n", output(counter::printValue));
        counter.decrement();
        assertEquals("value: 9\n", output(counter::printValue));
        counter.decrement();
        assertEquals("value: 8\n", output(counter::printValue));
    }

    @Test void lowerBoundary() {
        DecreasingCounter counter = new DecreasingCounter(2);
        counter.decrement();
        counter.decrement();
        counter.decrement();
        counter.decrement();
        assertEquals("value: 0\n", output(counter::printValue));
    }

    @Test void resetAndIndependentObjects() throws Exception {
        DecreasingCounter first = new DecreasingCounter(100);
        DecreasingCounter second = new DecreasingCounter(5);
        first.reset();
        first.decrement();
        assertEquals("value: 0\n", output(first::printValue));
        assertEquals("value: 5\n", output(second::printValue));
        fields(DecreasingCounter.class, "value");
    }
}
