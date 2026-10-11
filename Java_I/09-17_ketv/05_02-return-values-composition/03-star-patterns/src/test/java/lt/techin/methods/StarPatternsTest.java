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
class StarPatternsTest {
    private Method method(String name, Class<?>... parameterTypes) {
        return MethodCheck.require(StarPatterns.class, name, void.class, parameterTypes);
    }
    private String output(String name, Class<?>[] parameterTypes, Object... arguments) {
        Method target = method(name, parameterTypes);
        return ConsoleCheck.run(() -> MethodCheck.invoke(target, arguments));
    }
    @Test void printsAStarLineIncludingEmpty() {
        assertEquals("***\n", output("printStars", new Class<?>[] {int.class}, 3));
        assertEquals("\n", output("printStars", new Class<?>[] {int.class}, 0));
    }
    @Test void printsStarSignShapes() {
        assertEquals("***\n***\n***\n", output("printSquare", new Class<?>[] {int.class}, 3));
        assertEquals("****\n****\n", output("printRectangle",
                new Class<?>[] {int.class, int.class}, 4, 2));
        assertEquals("*\n**\n***\n", output("printTriangle", new Class<?>[] {int.class}, 3));
    }
    @Test void printsSpacesWithoutANewline() {
        assertEquals("   ", output("printSpaces", new Class<?>[] {int.class}, 3));
    }
    @Test void printsAdvancedAstrologyShapes() {
        assertEquals("*\n", output("printRightTriangle", new Class<?>[] {int.class}, 1));
        assertEquals("  *\n **\n***\n",
                output("printRightTriangle", new Class<?>[] {int.class}, 3));
        assertEquals("   *\n  ***\n *****\n*******\n  ***\n  ***\n",
                output("christmasTree", new Class<?>[] {int.class}, 4));
    }
    @Test void shapesReuseTheRequiredHelpers() throws Exception {
        SourceCheck.method("lt.techin.methods.StarPatterns", "printSquare", 1).requireCall("printStars");
        SourceCheck.method("lt.techin.methods.StarPatterns", "printRectangle", 2).requireCall("printStars");
        SourceCheck.method("lt.techin.methods.StarPatterns", "printTriangle", 1).requireCall("printStars");
        SourceCheck.method("lt.techin.methods.StarPatterns", "printRightTriangle", 1)
                .requireCall("printSpaces").requireCall("printStars");
        SourceCheck.method("lt.techin.methods.StarPatterns", "christmasTree", 1)
                .requireCall("printSpaces").requireCall("printStars");
    }
}
