package lt.techin.arrays;

public class ReverseInPlace {
    public static void reverseInPlace(int[] values) {
        // TODO: swap symmetric elements without another array
        for (int i = 0; i < values.length / 2; i++) {
            int temp = values[i];
            values[i] = values[values.length - 1 - i];
            values[values.length - 1 - i] = temp;
        }
    }
}
