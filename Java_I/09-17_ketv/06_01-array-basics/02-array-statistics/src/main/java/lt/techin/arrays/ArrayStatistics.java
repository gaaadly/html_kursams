package lt.techin.arrays;

public class ArrayStatistics {
    public static int sum(int[] values) {
        // TODO
        int total = 0;
        for (int value : values) {
            total += value;
        }
        return total;
    }

    public static int min(int[] values) {
        // TODO
        int minimum = values[0];
        for (int i = 1; i < values.length; i++) {
            if (values[i] < minimum) {
                minimum = values[i];
            }
        }
        return minimum;
    }

    public static int max(int[] values) {
        // TODO
        int maximum = values[0];
        for (int i = 1; i < values.length; i++) {
            if (values[i] > maximum) {
                maximum = values[i];
            }
        }
        return maximum;
    }

    public static double average(int[] values) {
        // TODO
        return (double) sum(values) / values.length;
    }
}
