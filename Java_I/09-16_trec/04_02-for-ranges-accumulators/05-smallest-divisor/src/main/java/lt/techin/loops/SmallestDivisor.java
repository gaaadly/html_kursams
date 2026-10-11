package lt.techin.loops;

import java.util.Scanner;

public class SmallestDivisor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // TODO: complete the loop program.
        System.out.println("Give a number:");
        int number = Integer.parseInt(scanner.nextLine());
        int divisor = number;
        for (int i = 2; i <= number; i++) {
            if (number % i == 0) {
                divisor = i;
                break;
            }
        }
        System.out.println("Smallest divisor: " + divisor);
    }
}
