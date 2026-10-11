package lt.techin.loops;

import java.util.Scanner;

public class CoordinateGrid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // TODO: complete the loop program.

        System.out.println("Rows:");
        int rows = Integer.parseInt(scanner.nextLine());
        System.out.println("Columns:");
        int columns = Integer.parseInt(scanner.nextLine());
        for (int row = 1; row <= rows; row++) {
            String line = "";
            for (int col = 1; col <= columns; col++) {
                if (col == 1) {
                    line = line + "(" + row + "," + col + ")";
                } else {
                    line = line + " " + "(" + row + "," + col + ")";
                }
            }
            System.out.println(line);
        }
    }
}
