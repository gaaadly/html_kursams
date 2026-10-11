package lt.techin.loops;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // TODO: complete the loop program.
        System.out.println("Give a number:");
        long number = Long.parseLong(scanner.nextLine());
        long product = 1;
        for (long i = 2; i <= number; i++) {
            product *= i;
        }
        System.out.println("Factorial: " + product);
    }
}
