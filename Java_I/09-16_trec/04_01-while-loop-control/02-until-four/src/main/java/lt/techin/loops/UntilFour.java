package lt.techin.loops;

import java.util.Scanner;

public class UntilFour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // TODO: complete the loop program.
        int number;
        do {
            System.out.println("Give a number:");
            number = Integer.parseInt(scanner.nextLine());
        } while (number != 4);
    }
}
