package lt.techin.arrays;

public class SwapElements {
    public static void swap(int[] values, int firstIndex, int secondIndex) {
        // TODO
        int temp = values[firstIndex];
        values[firstIndex] = values[secondIndex];
        values[secondIndex] = temp;
    }
}
