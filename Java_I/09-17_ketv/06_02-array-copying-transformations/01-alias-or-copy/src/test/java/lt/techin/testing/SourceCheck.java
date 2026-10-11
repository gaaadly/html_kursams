package lt.techin.testing;

import com.sun.source.tree.ClassTree;
import com.sun.source.tree.MethodInvocationTree;
import com.sun.source.tree.MethodTree;
import com.sun.source.tree.Tree;
import com.sun.source.util.JavacTask;
import com.sun.source.util.TreeScanner;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.List;
import java.util.Locale;
import javax.tools.ToolProvider;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

/** AST checks for constructs that are explicit array-lesson objectives. */
public final class SourceCheck {
    private final MethodTree method;

    private SourceCheck(MethodTree method) {
        this.method = method;
    }

    public static SourceCheck method(String qualifiedClass, String methodName, int parameterCount)
            throws Exception {
        var compiler = ToolProvider.getSystemJavaCompiler();
        assertNotNull(compiler, "Run tests with a JDK, not only a JRE.");
        Path file = Path.of("src/main/java", qualifiedClass.replace('.', '/') + ".java");
        try (var manager = compiler.getStandardFileManager(null, Locale.ROOT, StandardCharsets.UTF_8)) {
            var task = (JavacTask) compiler.getTask(null, manager, null, List.of("-proc:none"), null,
                    manager.getJavaFileObjects(file));
            String simple = qualifiedClass.substring(qualifiedClass.lastIndexOf('.') + 1);
            for (var unit : task.parse()) {
                for (var declaration : unit.getTypeDecls()) {
                    if (declaration instanceof ClassTree cls && cls.getSimpleName().contentEquals(simple)) {
                        for (var member : cls.getMembers()) {
                            if (member instanceof MethodTree candidate
                                    && candidate.getName().contentEquals(methodName)
                                    && candidate.getParameters().size() == parameterCount) {
                                assertNotNull(candidate.getBody(), "Complete method " + methodName + ".");
                                return new SourceCheck(candidate);
                            }
                        }
                    }
                }
            }
        }
        fail("Keep method " + methodName + " with " + parameterCount + " parameter(s).");
        return null;
    }

    private int count(Tree.Kind kind) {
        Integer result = new TreeScanner<Integer, Void>() {
            @Override public Integer scan(Tree node, Void unused) {
                if (node == null) return 0;
                Integer nested = super.scan(node, unused);
                return (node.getKind() == kind ? 1 : 0) + (nested == null ? 0 : nested);
            }
            @Override public Integer reduce(Integer left, Integer right) {
                return (left == null ? 0 : left) + (right == null ? 0 : right);
            }
        }.scan(method.getBody(), null);
        return result == null ? 0 : result;
    }

    public SourceCheck require(Tree.Kind kind, int minimum, String message) {
        assertTrue(count(kind) >= minimum, message);
        return this;
    }

    public SourceCheck forbid(Tree.Kind kind, String message) {
        assertEquals(0, count(kind), message);
        return this;
    }

    public SourceCheck requireCall(String calledMethod) {
        Integer calls = new TreeScanner<Integer, Void>() {
            @Override public Integer visitMethodInvocation(MethodInvocationTree node, Void unused) {
                String selection = node.getMethodSelect().toString();
                int current = selection.equals(calledMethod) || selection.endsWith("." + calledMethod) ? 1 : 0;
                Integer nested = super.visitMethodInvocation(node, unused);
                return current + (nested == null ? 0 : nested);
            }
            @Override public Integer reduce(Integer left, Integer right) {
                return (left == null ? 0 : left) + (right == null ? 0 : right);
            }
        }.scan(method.getBody(), null);
        assertTrue(calls != null && calls > 0,
                "Call " + calledMethod + " from " + method.getName() + " as required.");
        return this;
    }
}
