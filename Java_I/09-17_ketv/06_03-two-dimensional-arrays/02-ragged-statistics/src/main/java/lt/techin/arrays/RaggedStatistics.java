package lt.techin.arrays;

public class RaggedStatistics {
    public static int max(int[][] values) {
        // TODO
        int max = Integer.MIN_VALUE;
        for (int row = 0; row < values.length; row++) {
            for (int column = 0; column < values[row].length; column++) {
                if (values[row][column] > max) {
                    max = values[row][column];
                }
            }
        }
        return max;
    }

    public static int rowSum(int[][] values, int row) {
        // TODO
        int sum = 0;
        for (int column = 0; column < values[row].length; column++) {
            sum += values[row][column];
        }
        return sum;
    }

    public static int[] allRowSums(int[][] values) {
        // TODO: call rowSum for each row
        int[] sums = new int[values.length];
        for (int row = 0; row < values.length; row++) {
            sums[row] = rowSum(values, row);
        }
        return sums;
    }
}