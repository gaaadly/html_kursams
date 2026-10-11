package lt.techin.arrays;

import java.util.Arrays;

public class AliasOrCopy {
    public static int[] alias(int[] source) {
        // TODO
        return source;
    }

    public static int[] manualCopy(int[] source) {
        // TODO: create a new array and copy every indexed element
        int[] copy = new int[source.length];
        for (int i = 0; i < source.length; i++) {
            copy[i] = source[i];
        }
        return copy;
    }

    public static int[] copyWithArraycopy(int[] source) {
        // TODO: use System.arraycopy
        int[] copy = new int[source.length];
        System.arraycopy(source, 0, copy, 0, source.length);
        return copy;
    }

    public static int[] copyWithCopyOf(int[] source) {
        // TODO: use Arrays.copyOf
        return Arrays.copyOf(source, source.length);
    }

    public static String describe(int[] source) {
        // TODO: use Arrays.toString
        return Arrays.toString(source);
    }
}
