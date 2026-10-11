package lt.techin.testing;

import com.sun.source.tree.*;
import com.sun.source.util.JavacTask;
import com.sun.source.util.TreeScanner;
import com.sun.source.util.Trees;
import com.sun.source.util.SourcePositions;
import javax.lang.model.element.Modifier;
import javax.tools.ToolProvider;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Files;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

/** Parses only the named student method. Comments and string contents are not code. */
public final class SourceCheck {
    private final MethodTree method;
    private final CompilationUnitTree unit;
    private final SourcePositions positions;
    private final String source;
    private SourceCheck(MethodTree method, CompilationUnitTree unit, SourcePositions positions, String source) {
        this.method = method; this.unit = unit; this.positions = positions; this.source = source;
    }

    public static SourceCheck method(String qualifiedClass, String name) throws Exception {
        var compiler = ToolProvider.getSystemJavaCompiler();
        assertNotNull(compiler, "Run the tests with a JDK.");
        Path file = Path.of("src/main/java", qualifiedClass.replace('.', '/') + ".java");
        try (var manager = compiler.getStandardFileManager(null, Locale.ROOT, StandardCharsets.UTF_8)) {
            var task = (JavacTask) compiler.getTask(null, manager, null, List.of("-proc:none"), null,
                    manager.getJavaFileObjects(file));
            String simpleName = qualifiedClass.substring(qualifiedClass.lastIndexOf('.') + 1);
            for (var unit : task.parse()) {
                for (var declaration : unit.getTypeDecls()) {
                    if (declaration instanceof ClassTree cls && cls.getSimpleName().contentEquals(simpleName)) {
                        for (var member : cls.getMembers()) {
                            if (member instanceof MethodTree m && m.getName().contentEquals(name)) {
                                assertNotNull(m.getBody(), "Complete the supplied method body.");
                                return new SourceCheck(m, unit, Trees.instance(task).getSourcePositions(), Files.readString(file));
                            }
                        }
                    }
                }
            }
        }
        fail("Keep the supplied method " + name + " in " + qualifiedClass);
        return null;
    }

    public SourceCheck straightLine() {
        for (var statement : method.getBody().getStatements()) {
            assertTrue(statement instanceof VariableTree || statement instanceof ExpressionStatementTree,
                    "Use local declarations and expression statements; no branches, loops, helper classes or nested blocks.");
        }
        return this;
    }

    private VariableTree variable(String name) {
        var found = method.getBody().getStatements().stream()
                .filter(s -> s instanceof VariableTree v && v.getName().contentEquals(name))
                .map(s -> (VariableTree) s).toList();
        assertEquals(1, found.size(), "Declare one local variable named " + name + " in this method.");
        return found.get(0);
    }

    public SourceCheck local(String name, String type, boolean isFinal) {
        var variable = variable(name);
        // javac represents an inferred local type as null in its parsed tree.
        String actual = variable.getType() == null ? "var" : variable.getType().toString();
        assertEquals(type, actual, "Use type " + type + " for " + name + ".");
        assertEquals(isFinal, variable.getModifiers().getFlags().contains(Modifier.FINAL),
                isFinal ? "Declare " + name + " with final." : "Allow reassignment of " + name + ".");
        Integer uses = new TreeScanner<Integer, Void>() {
            @Override public Integer visitIdentifier(IdentifierTree node, Void unused) {
                return node.getName().contentEquals(name) ? 1 : 0;
            }
            @Override public Integer reduce(Integer a, Integer b) { return (a == null ? 0 : a) + (b == null ? 0 : b); }
        }.scan(method.getBody(), null);
        assertTrue(uses != null && uses > 0, "Use " + name + " in the calculation or output, not only its declaration.");
        return this;
    }

    public SourceCheck assignments(String name, int expected) {
        int count = 0;
        for (var statement : method.getBody().getStatements()) {
            if (statement instanceof ExpressionStatementTree e && e.getExpression() instanceof AssignmentTree a
                    && a.getVariable() instanceof IdentifierTree id && id.getName().contentEquals(name)) count++;
        }
        assertEquals(expected, count, "Assign to the existing " + name + " variable " + expected + " times.");
        return this;
    }

    public SourceCheck uninitialized(String name) {
        assertNull(variable(name).getInitializer(), "Declare " + name + " first, then assign separately.");
        return this;
    }

    private ExpressionTree unwrap(ExpressionTree node) {
        while (node instanceof ParenthesizedTree p) node = p.getExpression();
        return node;
    }

    public SourceCheck literal(String name, String notation) {
        ExpressionTree initializer = unwrap(variable(name).getInitializer());
        assertTrue(initializer instanceof LiteralTree, "Initialize " + name + " with the requested numeric literal.");
        assertTrue(initializer.getKind() == Tree.Kind.LONG_LITERAL || initializer.getKind() == Tree.Kind.FLOAT_LITERAL
                || initializer.getKind() == Tree.Kind.DOUBLE_LITERAL, "Use a numeric literal for " + name + ".");
        String token = source.substring((int) positions.getStartPosition(unit, initializer),
                (int) positions.getEndPosition(unit, initializer)).toUpperCase(Locale.ROOT);
        assertTrue(notation.equals("E") ? token.contains("E") : token.endsWith(notation),
                "Use " + notation + " notation in the literal for " + name + ".");
        return this;
    }

    public SourceCheck cast(String name, String targetType) {
        var initializer = unwrap(variable(name).getInitializer());
        assertTrue(initializer instanceof TypeCastTree, "Initialize " + name + " with an explicit narrowing cast.");
        assertEquals(targetType, ((TypeCastTree) initializer).getType().toString(), "Cast " + name + " to " + targetType);
        return this;
    }

    public SourceCheck from(String name, String input) {
        var initializer = unwrap(variable(name).getInitializer());
        assertTrue(initializer instanceof IdentifierTree id && id.getName().contentEquals(input),
                "Initialize " + name + " directly from " + input + " using automatic widening.");
        return this;
    }

    public SourceCheck dependsOn(String name, String input) {
        Boolean found = new TreeScanner<Boolean, Void>() {
            @Override public Boolean visitIdentifier(IdentifierTree node, Void unused) { return node.getName().contentEquals(input); }
            @Override public Boolean reduce(Boolean a, Boolean b) { return Boolean.TRUE.equals(a) || Boolean.TRUE.equals(b); }
        }.scan(variable(name).getInitializer(), null);
        assertTrue(Boolean.TRUE.equals(found), "Calculate " + name + " from " + input + ".");
        return this;
    }

    public SourceCheck member(String required) {
        Set<String> found = new HashSet<>();
        new TreeScanner<Void, Void>() {
            @Override public Void visitMemberSelect(MemberSelectTree node, Void unused) {
                found.add(node.toString()); return super.visitMemberSelect(node, unused);
            }
        }.scan(method.getBody(), null);
        assertTrue(found.contains(required), "Use " + required + " in the supplied method.");
        return this;
    }

    public SourceCheck calls(String... required) {
        Set<String> found = new HashSet<>();
        new TreeScanner<Void, Void>() {
            @Override public Void visitMethodInvocation(MethodInvocationTree node, Void unused) {
                found.add(node.getMethodSelect().toString());
                return super.visitMethodInvocation(node, unused);
            }
        }.scan(method.getBody(), null);
        for (String call : required) {
            boolean present = call.startsWith("*.") ? found.stream().anyMatch(s -> s.endsWith(call.substring(1))) : found.contains(call);
            assertTrue(present, "Use " + call.replace("*.", "") + " in the supplied method.");
        }
        return this;
    }

    public SourceCheck arithmeticOnly() {
        straightLine();
        new TreeScanner<Void, Void>() {
            @Override public Void visitMethodInvocation(MethodInvocationTree node, Void unused) {
                assertEquals("System.out.println", node.getMethodSelect().toString(),
                        "Use arithmetic for this task; only System.out.println calls are needed.");
                return super.visitMethodInvocation(node, unused);
            }
            @Override public Void visitVariable(VariableTree node, Void unused) {
                assertEquals("int", String.valueOf(node.getType()), "Use int locals for digit/group arithmetic.");
                return super.visitVariable(node, unused);
            }
            @Override public Void visitNewClass(NewClassTree node, Void unused) {
                fail("Use arithmetic, not newly created helper objects."); return null;
            }
            @Override public Void visitNewArray(NewArrayTree node, Void unused) {
                fail("Use arithmetic, not arrays."); return null;
            }
            @Override public Void visitConditionalExpression(ConditionalExpressionTree node, Void unused) {
                fail("Use arithmetic, not conditional expressions."); return null;
            }
            @Override public Void visitLambdaExpression(LambdaExpressionTree node, Void unused) {
                fail("Use arithmetic, not lambda expressions."); return null;
            }
        }.scan(method.getBody(), null);
        return this;
    }
}
