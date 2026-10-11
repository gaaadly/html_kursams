package lt.techin.testing;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.lang.reflect.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

/** Provided test infrastructure. Do not edit. */
public final class Contract {
    private Contract() {}
    public static Field field(Class<?> type,String name) {
        return assertDoesNotThrow(()->type.getDeclaredField(name),"Declare the field "+name+" in "+type.getSimpleName()+".");
    }
    public static void fields(Class<?> type, String... names) throws Exception {
        Set<String> expected = new HashSet<>(Arrays.asList(names));
        Set<String> actual = new HashSet<>();
        for (Field f : type.getDeclaredFields()) {
            if (f.isSynthetic() || Modifier.isStatic(f.getModifiers())) continue;
            actual.add(f.getName());
            assertTrue(Modifier.isPrivate(f.getModifiers()), f.getName()+" must be private.");
        }
        assertEquals(expected, actual, "Declare the instance fields named in the brief; do not store derived values.");
        for (String name : names) assertFalse(Modifier.isStatic(type.getDeclaredField(name).getModifiers()), name+" belongs to each object.");
    }
    public static String output(Runnable action) { return console("", action); }
    public static String console(String input, Runnable action) {
        InputStream oldIn=System.in; PrintStream oldOut=System.out;
        ByteArrayOutputStream bytes=new ByteArrayOutputStream();
        try (PrintStream stream=new PrintStream(bytes,true,StandardCharsets.UTF_8)) {
            System.setIn(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));
            System.setOut(stream); action.run();
        } finally { System.setIn(oldIn); System.setOut(oldOut); }
        return bytes.toString(StandardCharsets.UTF_8).replace("\r\n","\n").replace('\r','\n');
    }
}
