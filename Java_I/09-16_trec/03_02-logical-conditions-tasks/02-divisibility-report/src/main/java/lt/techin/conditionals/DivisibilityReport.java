package lt.techin.conditionals;

import java.util.Scanner;

public class DivisibilityReport {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter an integer:");
        int number = Integer.parseInt(scanner.nextLine());
        boolean divisibleBy4 = number % 4 == 0;
        boolean divisibleBy5 = number % 5 == 0;
        boolean both = divisibleBy4 && divisibleBy5;
        boolean either = divisibleBy4 || divisibleBy5;
        boolean onlyOne = divisibleBy4 ^ divisibleBy5;
        System.out.println("Divisible by 4 and 5: " + both);
        System.out.println("Divisible by 4 or 5: " + either);
        System.out.println("Divisible by 4 or 5 but not both: " + onlyOne);
        // TODO: calculate and print the three boolean results.
    }
}
