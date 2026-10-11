package lt.techin.testing;
import com.sun.source.tree.*;
import com.sun.source.util.*;
import javax.tools.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

/** Compiler parser checks for explicitly requested learning constructs. */
public final class Source {
    private Source() {}
    public static void calls(String name,String method,int count,String receiver,String called) throws Exception {
        boolean[] found={false};
        new TreeScanner<Void,Void>() {
            @Override public Void visitMethodInvocation(MethodInvocationTree t,Void p) {
                Tree select=t.getMethodSelect();
                if(select instanceof MemberSelectTree m && m.getExpression().toString().replaceFirst("^this\\.", "").equals(receiver) && m.getIdentifier().contentEquals(called)) found[0]=true;
                if(receiver.isEmpty() && select instanceof IdentifierTree i && i.getName().contentEquals(called)) found[0]=true;
                return super.visitMethodInvocation(t,p);
            }
        }.scan(method(name,method,count).getBody(),null);
        assertTrue(found[0],"Use "+receiver+"."+called+" in "+method+".");
    }
    public static void override(String name,String method,int count) throws Exception {
        assertTrue(method(name,method,count).getModifiers().getAnnotations().stream().anyMatch(a->a.getAnnotationType().toString().matches("(java.lang.)?Override")),"Mark "+method+" with @Override.");
    }
    public static CompilationUnitTree unit(String name) throws Exception {
        JavaCompiler compiler=ToolProvider.getSystemJavaCompiler();
        assertNotNull(compiler,"Run with a JDK.");
        Path file=Path.of("src/main/java", name.replace('.','/')+".java");
        assertTrue(Files.exists(file),"Create "+file);
        try (var manager=compiler.getStandardFileManager(null,Locale.ROOT,StandardCharsets.UTF_8)) {
            JavacTask task=(JavacTask)compiler.getTask(null,manager,null,List.of("-proc:none"),null,manager.getJavaFileObjects(file));
            return task.parse().iterator().next();
        }
    }
    public static ClassTree type(String name) throws Exception {
        String simple=name.substring(name.lastIndexOf('.')+1);
        for (Tree tree:unit(name).getTypeDecls())
            if(tree instanceof ClassTree c && c.getSimpleName().contentEquals(simple)) return c;
        fail("Declare class "+simple); return null;
    }
    public static MethodTree method(String name,String method,int count) throws Exception {
        for(Tree t:type(name).getMembers())
            if(t instanceof MethodTree m && m.getName().contentEquals(method) && m.getParameters().size()==count) return m;
        fail("Declare "+method+" with "+count+" parameters.");return null;
    }
    public static void delegates(String name,int parameters,int targetParameters) throws Exception {
        MethodTree m=method(name,"<init>",parameters);
        var statements=m.getBody().getStatements();
        assertFalse(statements.isEmpty(),"Delegate to the other constructor using this(...).");
        Tree first=statements.get(0);
        assertTrue(first instanceof ExpressionStatementTree,"Use this(...) as the first statement in this exercise.");
        Tree expression=((ExpressionStatementTree)first).getExpression();
        assertTrue(expression instanceof MethodInvocationTree,"Call this(...).");
        MethodInvocationTree call=(MethodInvocationTree)expression;
        assertEquals("this",call.getMethodSelect().toString(),"Delegate to this class's constructor.");
        assertEquals(targetParameters,call.getArguments().size(),"Delegate to the canonical constructor.");
    }
    public static void assignsThis(String name,String method,int count,String field) throws Exception {
        boolean[] found={false};
        new TreeScanner<Void,Void>() {
            @Override public Void visitAssignment(AssignmentTree t,Void unused) {
                if(t.getVariable() instanceof MemberSelectTree m && m.getExpression().toString().equals("this") && m.getIdentifier().contentEquals(field)) found[0]=true;
                return super.visitAssignment(t,unused);
            }
        }.scan(method(name,method,count).getBody(),null);
        assertTrue(found[0],"Assign to this."+field+" in "+method+"; a parameter assignment does not update the object.");
    }
    public static void defaultFields(String name) throws Exception {
        for(Tree t:type(name).getMembers()) {
            if(t instanceof VariableTree v) assertNull(v.getInitializer(),"Let Java supply the field default for "+v.getName());
            if(t instanceof MethodTree m) assertNotEquals("<init>",m.getName().toString(),"Use the compiler-provided default constructor.");
        }
    }
    public static boolean usesIdentifier(String name,String method,int count,String identifier) throws Exception {
        boolean[] found={false};
        new TreeScanner<Void,Void>() {
            @Override public Void visitIdentifier(IdentifierTree t,Void p) { if(t.getName().contentEquals(identifier)) found[0]=true;return super.visitIdentifier(t,p); }
            @Override public Void visitMemberSelect(MemberSelectTree t,Void p) { if(t.getIdentifier().contentEquals(identifier)) found[0]=true;return super.visitMemberSelect(t,p); }
        }.scan(method(name,method,count).getBody(),null);
        return found[0];
    }
    public static boolean compiles(String qualifiedName,String code) throws Exception {
        Path dir=Files.createTempDirectory("oop-access-");
        try {
            Path file=dir.resolve(qualifiedName.replace('.','/')+".java");
            Files.createDirectories(file.getParent());Files.writeString(file,code);
            var compiler=ToolProvider.getSystemJavaCompiler();
            try(var manager=compiler.getStandardFileManager(null,Locale.ROOT,StandardCharsets.UTF_8)) {
                var diagnostics=new DiagnosticCollector<JavaFileObject>();
                return compiler.getTask(null,manager,diagnostics,List.of("-proc:none","-classpath",Path.of("target/classes").toAbsolutePath().toString(),"-d",dir.toString()),null,manager.getJavaFileObjects(file)).call();
            }
        } finally {
            try(var paths=Files.walk(dir)) { for(Path p:paths.sorted(Comparator.reverseOrder()).toList()) Files.delete(p); }
        }
    }
}
