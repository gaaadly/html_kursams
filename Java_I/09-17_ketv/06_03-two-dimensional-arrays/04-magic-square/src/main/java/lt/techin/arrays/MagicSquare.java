package lt.techin.arrays;

public class MagicSquare {
    public static boolean isSquare(int[][] grid) {
        for (int[] row : grid) {
            if (row.length != grid.length) {
                return false;
            }
        }
        return true;
    }

    public static int rowSum(int[][] grid, int row) {
        int total = 0;
        for (int value : grid[row]) {
            total += value;
        }
        return total;
    }

    public static int columnSum(int[][] grid, int column) {
        int total = 0;
        for (int row = 0; row < grid.length; row++) {
            total += grid[row][column];
        }
        return total;
    }

    public static boolean isMagic(int[][] grid) {
        // TODO: use all three helpers and check both diagonals
        if (grid.length == 0 || !isSquare(grid)) {
            return false;
        }

        int target = rowSum(grid, 0);

        for (int i = 0; i < grid.length; i++) {
            if (rowSum(grid, i) != target || columnSum(grid, i) != target) {
                return false;
            }
        }

        int mainDiagonal = 0;
        int otherDiagonal = 0;
        for (int i = 0; i < grid.length; i++) {
            mainDiagonal += grid[i][i];
            otherDiagonal += grid[i][grid.length - 1 - i];
        }

        return mainDiagonal == target && otherDiagonal == target;
    }
}
