package lt.techin.testing;

import com.sun.source.tree.ClassTree;
import com.sun.source.tree.ForLoopTree;
import com.sun.source.tree.LiteralTree;
import com.sun.source.tree.MethodInvocationTree;
import com.sun.source.tree.MethodTree;
import com.sun.source.tree.Tree;
import com.sun.source.tree.VariableTree;
import com.sun.source.util.JavacTask;
import com.sun.source.util.TreeScanner;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.List;
import java.util.Locale;
import javax.tools.ToolProvider;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

/** AST checks for method constructs that are explicit lesson objectives. */
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
                                assertNotNull(candidate.getBody(), "Complete the supplied " + methodName + " method.");
                                return new SourceCheck(candidate);
                            }
                        }
                    }
                }
            }
        }
        fail("Keep method " + methodName + " with " + parameterCount + " parameter(s) in " + qualifiedClass + ".");
        return null;
    }

    private int count(Tree.Kind kind) {
        Integer result = new TreeScanner<Integer, Void>() {
            @Override public Integer scan(Tree node, Void unused) {
                if (node == null) return 0;
                Integer nested = super.scan(node, unused);
                return (node.getKind() == kind ? 1 : 0) + (nested == null ? 0 : nested);
            }
            @Override public Integer reduce(Integer a, Integer b) {
                return (a == null ? 0 : a) + (b == null ? 0 : b);
            }
        }.scan(method.getBody(), null);
        return result == null ? 0 : result;
    }

    public SourceCheck requireAny(Tree.Kind... kinds) {
        int total = 0;
        for (Tree.Kind kind : kinds) total += count(kind);
        assertTrue(total > 0, "Use one of the required constructs in " + method.getName() + ".");
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
            @Override public Integer reduce(Integer a, Integer b) {
                return (a == null ? 0 : a) + (b == null ? 0 : b);
            }
        }.scan(method.getBody(), null);
        assertTrue(calls != null && calls > 0,
                "Call " + calledMethod + " from " + method.getName() + " instead of repeating its work.");
        return this;
    }

    public SourceCheck requireIntLiteralCall(String calledMethod, int value) {
        Integer calls = new TreeScanner<Integer, Void>() {
            @Override public Integer visitMethodInvocation(MethodInvocationTree node, Void unused) {
                String selection = node.getMethodSelect().toString();
                boolean nameMatches = selection.equals(calledMethod) || selection.endsWith("." + calledMethod);
                boolean argumentMatches = node.getArguments().size() == 1
                        && node.getArguments().get(0) instanceof LiteralTree literal
                        && literal.getValue() instanceof Integer integer
                        && integer == value;
                Integer nested = super.visitMethodInvocation(node, unused);
                return (nameMatches && argumentMatches ? 1 : 0) + (nested == null ? 0 : nested);
            }
            @Override public Integer reduce(Integer a, Integer b) {
                return (a == null ? 0 : a) + (b == null ? 0 : b);
            }
        }.scan(method.getBody(), null);
        assertTrue(calls != null && calls > 0,
                "Return the result of " + calledMethod + "(" + value + ") without a cast or suffix.");
        return this;
    }

    public SourceCheck requireForVariablesNamed(String variableName, int minimum) {
        Integer declarations = new TreeScanner<Integer, Void>() {
            @Override public Integer visitForLoop(ForLoopTree node, Void unused) {
                int current = 0;
                for (var initializer : node.getInitializer()) {
                    if (initializer instanceof VariableTree variable
                            && variable.getName().contentEquals(variableName)) current++;
                }
                Integer nested = super.visitForLoop(node, unused);
                return current + (nested == null ? 0 : nested);
            }
            @Override public Integer reduce(Integer a, Integer b) {
                return (a == null ? 0 : a) + (b == null ? 0 : b);
            }
        }.scan(method.getBody(), null);
        assertTrue(declarations != null && declarations >= minimum,
                "Declare " + variableName + " separately in both for-loop headers.");
        return this;
    }
}
