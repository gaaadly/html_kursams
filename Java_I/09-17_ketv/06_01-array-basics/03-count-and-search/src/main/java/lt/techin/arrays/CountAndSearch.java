package lt.techin.arrays;

public class CountAndSearch {
    public static int countGreaterThan(int[] values, int limit) {
        // TODO
        int count = 0;
        for (int value : values) {
            if (value > limit) {
                count++;
            }
        }
        return count;
    }

    public static int firstIndexOf(int[] values, int target) {
        // TODO
        for (int i = 0; i < values.length; i++) {
            if (values[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static int lastIndexOf(int[] values, int target) {
        // TODO
        for (int i = values.length - 1; i >= 0; i--) {
            if (values[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static boolean contains(int[] values, int target) {
        // TODO: call firstIndexOf
        return firstIndexOf(values, target) != -1;
    }
}
