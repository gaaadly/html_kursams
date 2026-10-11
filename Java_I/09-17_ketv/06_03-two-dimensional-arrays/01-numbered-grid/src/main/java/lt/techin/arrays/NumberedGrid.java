package lt.techin.arrays;

import java.util.Arrays;

public class NumberedGrid {
    public static int[][] create(int rows, int columns) {
        // TODO
        int[][] grid = new int[rows][columns];
        int number = 1;
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                grid[row][column] = number;
                number++;
            }
        }
        return grid;
    }

    public static void setCell(int[][] grid, int row, int column, int value) {
        // TODO
        grid[row][column] = value;
    }

    public static String describe(int[][] grid) {
        // TODO
        return Arrays.deepToString(grid);
    }
}
