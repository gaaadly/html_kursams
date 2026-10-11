package lt.techin.loops;

import java.util.Scanner;

public class PositiveSquares {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // TODO: complete the loop program.
        while (true) {
            System.out.println("Give a number:");
            int number = Integer.parseInt(scanner.nextLine());
            if (number == 0) {
                break;
            }
            if (number < 0) {
                System.out.println("Unsuitable number");
                continue;
            }
            System.out.println(number * number);
        }
    }
}