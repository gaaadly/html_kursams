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
class MethodMessageTest {
    @Test void methodPrintsTheMessage() {
        Method method = MethodCheck.require(MethodMessage.class, "printText", void.class);
        assertEquals("Welcome to the Java methods lesson!\n",
                ConsoleCheck.run(() -> MethodCheck.invoke(method)));
    }
    @Test void mainCallsTheMethodOnce() throws Exception {
        assertEquals("Welcome to the Java methods lesson!\n",
                ConsoleCheck.run(() -> MethodMessage.main(new String[0])));
        SourceCheck.method("lt.techin.methods.MethodMessage", "main", 1).requireCall("printText");
    }
}
