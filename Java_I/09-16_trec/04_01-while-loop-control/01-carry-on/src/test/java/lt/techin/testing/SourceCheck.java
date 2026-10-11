package lt.techin.testing;

import com.sun.source.tree.ClassTree;
import com.sun.source.tree.MethodTree;
import com.sun.source.tree.Tree;
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

/** AST checks for loop forms that are explicit lesson objectives. */
public final class SourceCheck {
    private final MethodTree method;

    private SourceCheck(MethodTree method) {
        this.method = method;
    }

    public static SourceCheck main(String qualifiedClass) throws Exception {
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
                                    && candidate.getName().contentEquals("main")) {
                                assertNotNull(candidate.getBody(), "Complete the supplied main method.");
                                return new SourceCheck(candidate);
                            }
                        }
                    }
                }
            }
        }
        fail("Keep the supplied main method in " + qualifiedClass + ".");
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

    public SourceCheck require(Tree.Kind... kinds) {
        for (Tree.Kind kind : kinds) {
            assertTrue(count(kind) > 0, "Use " + display(kind) + ".");
        }
        return this;
    }

    public SourceCheck requireAtLeast(Tree.Kind kind, int minimum) {
        assertTrue(count(kind) >= minimum,
                "Use at least " + minimum + " " + display(kind) + " construct(s).");
        return this;
    }

    public SourceCheck forbid(Tree.Kind... kinds) {
        for (Tree.Kind kind : kinds) {
            assertTrue(count(kind) == 0, "Do not use " + display(kind) + ".");
        }
        return this;
    }

    public SourceCheck nestedForDepthAtLeast(int minimum) {
        int[] current = {0};
        int[] best = {0};
        new TreeScanner<Void, Void>() {
            @Override public Void visitForLoop(com.sun.source.tree.ForLoopTree node, Void unused) {
                current[0]++;
                best[0] = Math.max(best[0], current[0]);
                super.visitForLoop(node, unused);
                current[0]--;
                return null;
            }
        }.scan(method.getBody(), null);
        assertTrue(best[0] >= minimum, "Nest a for loop inside another for loop.");
        return this;
    }

    public SourceCheck incrementOrDecrement() {
        int total = count(Tree.Kind.POSTFIX_INCREMENT) + count(Tree.Kind.PREFIX_INCREMENT)
                + count(Tree.Kind.POSTFIX_DECREMENT) + count(Tree.Kind.PREFIX_DECREMENT)
                + count(Tree.Kind.PLUS_ASSIGNMENT) + count(Tree.Kind.MINUS_ASSIGNMENT);
        assertTrue(total > 0, "Use ++, --, +=, or -= to make loop progress.");
        return this;
    }

    private static String display(Tree.Kind kind) {
        return kind.name().toLowerCase(Locale.ROOT).replace('_', ' ');
    }
}
