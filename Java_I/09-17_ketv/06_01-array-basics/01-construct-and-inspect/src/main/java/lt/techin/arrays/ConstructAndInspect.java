package lt.techin.arrays;

public class ConstructAndInspect {
    public static int[] createWithEdges(int size, int firstValue, int lastValue) {
        // TODO: create the requested array and assign its edge values
        int[] array = new int[size];
        if (size == 1) {
            array[0] = firstValue;
        } else if (size >= 2) {
            array[0] = firstValue;
            array[size - 1] = lastValue;
        }
        return array;
    }

    public static int first(int[] values) {
        // TODO
        return values[0];
    }

    public static int last(int[] values) {
        // TODO
        return values[values.length - 1];
    }
}
