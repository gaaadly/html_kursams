package lt.techin.testing;

import com.sun.source.tree.*;
import com.sun.source.util.*;
import javax.tools.ToolProvider;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

/** JDK syntax checks: comments and string contents cannot satisfy an API requirement. */
public final class PipelineCheck {
    private PipelineCheck() { }

    public static void check(String className, String methodName, String... required) throws Exception {
        var compiler = ToolProvider.getSystemJavaCompiler();
        assertNotNull(compiler, "Run tests with a JDK.");
        Path source = Path.of("src/main/java/lt/techin/stream", className + ".java");
        try (var files = compiler.getStandardFileManager(null, Locale.ROOT, StandardCharsets.UTF_8)) {
            var task = (JavacTask) compiler.getTask(null, files, null,
                List.of("-proc:none"), null, files.getJavaFileObjects(source));
            var unit = task.parse().iterator().next();
            MethodTree method = null;
            for (Tree type : unit.getTypeDecls()) {
                if (type instanceof ClassTree cls && cls.getSimpleName().contentEquals(className)) {
                    for (Tree member : cls.getMembers()) {
                        if (member instanceof MethodTree candidate && candidate.getName().contentEquals(methodName)) {
                            method = candidate;
                        }
                    }
                }
            }
            assertNotNull(method, "Keep the supplied " + methodName + " method.");
            var statements = method.getBody().getStatements();
            assertEquals(1, statements.size(), methodName + ": return one stream pipeline directly, without extra statements.");
            assertInstanceOf(ReturnTree.class, statements.get(0), methodName + ": return the pipeline result directly.");
            ExpressionTree result = ((ReturnTree) statements.get(0)).getExpression();
            Set<String> calls = new HashSet<>();
            new TreeScanner<Void, Void>() {
                @Override public Void scan(Tree node, Void unused) {
                    if (node != null) assertFalse(Set.of(Tree.Kind.FOR_LOOP, Tree.Kind.ENHANCED_FOR_LOOP,
                        Tree.Kind.WHILE_LOOP, Tree.Kind.DO_WHILE_LOOP).contains(node.getKind()),
                        methodName + ": use stream operations instead of loops.");
                    return super.scan(node, unused);
                }
                @Override public Void visitMethodInvocation(MethodInvocationTree call, Void unused) {
                    Tree select = call.getMethodSelect();
                    String name = select instanceof MemberSelectTree member ? member.getIdentifier().toString() : select.toString();
                    assertFalse(name.equals("forEach") || name.equals("forEachOrdered"),
                        methodName + ": use a returned stream result instead of forEach.");
                    calls.add(name);
                    return super.visitMethodInvocation(call, unused);
                }
            }.scan(result, null);
            for (String call : required) assertTrue(calls.contains(call),
                methodName + ": use " + call + " in the returned pipeline (see README).");
        }
    }
}
