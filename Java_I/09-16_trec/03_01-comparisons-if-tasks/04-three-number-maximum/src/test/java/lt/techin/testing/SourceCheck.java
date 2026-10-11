package lt.techin.testing;

import com.sun.source.tree.*;
import com.sun.source.util.JavacTask;
import com.sun.source.util.TreeScanner;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.*;
import javax.tools.ToolProvider;
import static org.junit.jupiter.api.Assertions.*;

/** AST checks for constructs that are explicit lesson objectives. */
public final class SourceCheck {
    private final MethodTree method;

    private SourceCheck(MethodTree method) { this.method = method; }

    public static SourceCheck method(String qualifiedClass, String methodName) throws Exception {
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
                                    && candidate.getName().contentEquals(methodName)) {
                                assertNotNull(candidate.getBody(), "Complete the supplied method body.");
                                return new SourceCheck(candidate);
                            }
                        }
                    }
                }
            }
        }
        fail("Keep the supplied method " + methodName + " in " + qualifiedClass + ".");
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

    public SourceCheck requireKinds(Tree.Kind... kinds) {
        for (Tree.Kind kind : kinds) {
            assertTrue(count(kind) > 0, "Use " + kind.name().toLowerCase(Locale.ROOT).replace('_', ' ') + ".");
        }
        return this;
    }

    public SourceCheck forbidKinds(Tree.Kind... kinds) {
        for (Tree.Kind kind : kinds) {
            assertEquals(0, count(kind), "Do not use " + kind.name().toLowerCase(Locale.ROOT).replace('_', ' ') + ".");
        }
        return this;
    }

    public SourceCheck bracedIfsAtLeast(int minimum) {
        int[] total = {0};
        new TreeScanner<Void, Void>() {
            @Override public Void visitIf(IfTree node, Void unused) {
                total[0]++;
                assertTrue(node.getThenStatement() instanceof BlockTree, "Use braces around every if branch.");
                if (node.getElseStatement() != null && !(node.getElseStatement() instanceof IfTree)) {
                    assertTrue(node.getElseStatement() instanceof BlockTree, "Use braces around every else branch.");
                }
                return super.visitIf(node, unused);
            }
        }.scan(method.getBody(), null);
        assertTrue(total[0] >= minimum, "Use at least " + minimum + " if statement(s).");
        return this;
    }

    public SourceCheck hasElse() {
        boolean[] found = {false};
        new TreeScanner<Void, Void>() {
            @Override public Void visitIf(IfTree node, Void unused) {
                if (node.getElseStatement() != null) found[0] = true;
                return super.visitIf(node, unused);
            }
        }.scan(method.getBody(), null);
        assertTrue(found[0], "Use an else branch.");
        return this;
    }

    public SourceCheck local(String name, String type) {
        List<VariableTree> matches = new ArrayList<>();
        new TreeScanner<Void, Void>() {
            @Override public Void visitVariable(VariableTree node, Void unused) {
                if (node.getName().contentEquals(name)) matches.add(node);
                return super.visitVariable(node, unused);
            }
        }.scan(method.getBody(), null);
        assertEquals(1, matches.size(), "Declare one local variable named " + name + ".");
        assertEquals(type, matches.get(0).getType().toString(), "Use type " + type + " for " + name + ".");
        return this;
    }

    public SourceCheck elseIfDepthAtLeast(int minimum) {
        int best = 0;
        for (StatementTree statement : method.getBody().getStatements()) {
            if (!(statement instanceof IfTree current)) continue;
            int depth = 1;
            while (current.getElseStatement() instanceof IfTree next) {
                depth++;
                current = next;
            }
            best = Math.max(best, depth);
        }
        assertTrue(best >= minimum, "Use one ordered else-if chain with at least " + minimum + " conditions.");
        return this;
    }

    public SourceCheck independentTopLevelIfs(int expected) {
        long total = method.getBody().getStatements().stream().filter(IfTree.class::isInstance).count();
        assertEquals(expected, total, "Use exactly " + expected + " independent top-level if statements.");
        for (StatementTree statement : method.getBody().getStatements()) {
            if (statement instanceof IfTree tree) assertNull(tree.getElseStatement(), "These checks must be independent, without else.");
        }
        return this;
    }

    public SourceCheck callEnding(String ending) {
        boolean[] found = {false};
        new TreeScanner<Void, Void>() {
            @Override public Void visitMethodInvocation(MethodInvocationTree node, Void unused) {
                if (node.getMethodSelect().toString().endsWith(ending)) found[0] = true;
                return super.visitMethodInvocation(node, unused);
            }
        }.scan(method.getBody(), null);
        assertTrue(found[0], "Use the " + ending + " method call.");
        return this;
    }

    public SourceCheck parenthesized() {
        assertTrue(count(Tree.Kind.PARENTHESIZED) > 0, "Use parentheses to show the grouping of the mixed condition.");
        return this;
    }

    public SourceCheck ruleSwitchStatement() {
        boolean[] found = {false};
        boolean[] hasDefault = {false};
        new TreeScanner<Void, Void>() {
            @Override public Void visitSwitch(SwitchTree node, Void unused) {
                found[0] = node.getCases().stream().allMatch(c -> c.getCaseKind() == CaseTree.CaseKind.RULE);
                hasDefault[0] = node.getCases().stream().anyMatch(c -> c.getExpressions().isEmpty());
                return super.visitSwitch(node, unused);
            }
        }.scan(method.getBody(), null);
        assertTrue(found[0], "Use an arrow-label switch statement.");
        assertTrue(hasDefault[0], "Include a default branch for every other value.");
        return this;
    }

    public SourceCheck groupedRuleSwitchExpression() {
        boolean[] expression = {false};
        boolean[] grouped = {false};
        new TreeScanner<Void, Void>() {
            @Override public Void visitSwitchExpression(SwitchExpressionTree node, Void unused) {
                expression[0] = true;
                for (CaseTree item : node.getCases()) {
                    assertEquals(CaseTree.CaseKind.RULE, item.getCaseKind(), "Use arrow labels in the switch expression.");
                    if (item.getExpressions().size() > 1) grouped[0] = true;
                }
                return super.visitSwitchExpression(node, unused);
            }
        }.scan(method.getBody(), null);
        assertTrue(expression[0], "Use a switch expression that returns the number of days.");
        assertTrue(grouped[0], "Group months that have the same number of days in one case.");
        return this;
    }

    public SourceCheck classicSwitchWithBreaks(int minimumBreaks) {
        boolean[] classic = {false};
        new TreeScanner<Void, Void>() {
            @Override public Void visitSwitch(SwitchTree node, Void unused) {
                classic[0] = node.getCases().stream().allMatch(c -> c.getCaseKind() == CaseTree.CaseKind.STATEMENT);
                return super.visitSwitch(node, unused);
            }
        }.scan(method.getBody(), null);
        assertTrue(classic[0], "Keep the supplied classic colon-label switch.");
        assertTrue(count(Tree.Kind.BREAK) >= minimumBreaks, "Add break after each non-default command branch.");
        return this;
    }

    public SourceCheck oneSimpleTernary() {
        assertEquals(1, count(Tree.Kind.CONDITIONAL_EXPRESSION), "Use exactly one ternary expression.");
        forbidKinds(Tree.Kind.IF, Tree.Kind.SWITCH, Tree.Kind.SWITCH_EXPRESSION);
        return this;
    }
}
