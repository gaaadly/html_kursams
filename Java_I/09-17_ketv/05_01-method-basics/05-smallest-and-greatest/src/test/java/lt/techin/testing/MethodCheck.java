package lt.techin.testing;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

/** Reflection support for tasks where declaring the method is student work. */
public final class MethodCheck {
    private MethodCheck() {}

    public static Method require(Class<?> owner, String name, Class<?> returnType,
            Class<?>... parameterTypes) {
        try {
            Method method = owner.getDeclaredMethod(name, parameterTypes);
            assertTrue(Modifier.isPublic(method.getModifiers()), name + " must be public.");
            assertTrue(Modifier.isStatic(method.getModifiers()), name + " must be static.");
            assertEquals(returnType, method.getReturnType(), name + " has the wrong return type.");
            return method;
        } catch (NoSuchMethodException exception) {
            fail("Declare public static method " + name + signature(parameterTypes) + ".");
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T invoke(Method method, Object... arguments) {
        try {
            return (T) method.invoke(null, arguments);
        } catch (IllegalAccessException exception) {
            throw new AssertionError("Method must be accessible.", exception);
        } catch (InvocationTargetException exception) {
            throw new AssertionError("The method threw an exception.", exception.getCause());
        }
    }

    private static String signature(Class<?>[] parameterTypes) {
        StringBuilder result = new StringBuilder("(");
        for (int index = 0; index < parameterTypes.length; index++) {
            if (index > 0) result.append(", ");
            result.append(parameterTypes[index].getSimpleName());
        }
        return result.append(')').toString();
    }
}
