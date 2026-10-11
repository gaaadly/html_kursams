package lt.techin.loops;

import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // TODO: complete the loop program.

        System.out.println("Size:");
        int size = Integer.parseInt(scanner.nextLine());
        for (int row = 1; row <= size; row++) {
            String line = "";
            for (int col = 1; col <= size; col++) {
                if (col == 1) {
                    line = line + (row * col);
                } else {
                    line = line + " " + (row * col);
                }
            }
            System.out.println(line);
        }
    }
}
