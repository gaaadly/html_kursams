package lt.techin.arraylist;

import java.util.ArrayList;
import java.util.List;
import lt.techin.testing.SourceCheck;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AverageOfNumbersTest {
    @Test
    void calculatesSumsAndDecimalAverages() {
        assertEquals(14, AverageOfNumbers.sum(new ArrayList<>(List.of(3, 2, 7, 2))));
        assertEquals(3.5, AverageOfNumbers.average(
                new ArrayList<>(List.of(3, 2, 7, 2))), 0.0001);
        assertEquals(1.25, AverageOfNumbers.average(
                new ArrayList<>(List.of(1, 1, 1, 2))), 0.0001);
        assertEquals(-2.5, AverageOfNumbers.average(
                new ArrayList<>(List.of(-2, -3))), 0.0001);
    }

    @Test
    void averageCallsSum() throws Exception {
        SourceCheck.method("lt.techin.arraylist.AverageOfNumbers", "average", 1)
                .requireCall("sum");
    }
}
