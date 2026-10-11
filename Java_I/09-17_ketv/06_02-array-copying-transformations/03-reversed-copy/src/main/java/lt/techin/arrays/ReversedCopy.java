package lt.techin.arrays;

public class ReversedCopy {
    public static int[] reversedCopy(int[] source) {
        // TODO
        int[] reversed = new int[source.length];
        for (int i = 0; i < source.length; i++) {
            reversed[i] = source[source.length - 1 - i];
        }
        return reversed;
    }
}
