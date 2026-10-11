package lt.techin.variables;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceLock;
import lt.techin.testing.ConsoleCheck;
import lt.techin.testing.SourceCheck;
import static org.junit.jupiter.api.Assertions.*;

@ResourceLock("SYSTEM_STREAMS")
class LiteralLabTest {
    @Test
    void printsCorrectedValues() {
        ConsoleCheck.lines(ConsoleCheck.run(new String[]{}, new String[]{}, () -> LiteralLab.main(new String[0])),
                "Max unsigned int: 2147483648",
                "~Cache ratio: |0.5",
                "~Byte scale: |2560",
                "Drive letter: C",
                "Before: Java",
                "After: Java 25");
    }

    @Test
    void usesRequiredConstructs() throws Exception {
        SourceCheck check = SourceCheck.method("lt.techin.variables.LiteralLab", "main").straightLine();
        check.local("maxUnsignedInt", "long", false);
        check.local("cacheRatio", "float", false);
        check.local("byteScale", "double", false);
        check.local("driveLetter", "char", false);
        check.local("language", "var", false);
        check.assignments("language", 1).literal("maxUnsignedInt", "L").literal("cacheRatio", "F").literal("byteScale", "E");
    }
}
