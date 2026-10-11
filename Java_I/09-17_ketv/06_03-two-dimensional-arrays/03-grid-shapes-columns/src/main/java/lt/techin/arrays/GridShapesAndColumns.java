package lt.techin.arrays;

public class GridShapesAndColumns {
    public static boolean isRectangular(int[][] grid) {
        // TODO
        if (grid.length == 0) {
            return true;
        }
        int width = grid[0].length;
        for (int row = 1; row < grid.length; row++) {
            if (grid[row].length != width) {
                return false;
            }
        }
        return true;
    }

    public static boolean isSquare(int[][] grid) {
        // TODO
        for (int row = 0; row < grid.length; row++) {
            if (grid[row].length != grid.length) {
                return false;
            }
        }
        return true;
    }

    public static int columnSum(int[][] grid, int column) {
        // TODO
        int sum = 0;
        for (int row = 0; row < grid.length; row++) {
            sum += grid[row][column];
        }
        return sum;
    }
}