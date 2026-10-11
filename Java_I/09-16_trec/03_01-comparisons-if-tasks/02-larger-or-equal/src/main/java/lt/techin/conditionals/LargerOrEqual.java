package lt.techin.conditionals;

import java.util.Scanner;

public class LargerOrEqual {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Give the first number:");
        int first = Integer.parseInt(scanner.nextLine());
        System.out.println("Give the second number:");
        int second = Integer.parseInt(scanner.nextLine());
        if (first == second) {
            System.out.println("The numbers are equal.");
        } else if (first > second) {
            System.out.println("Larger number: " + first);
        } else {
            System.out.println("Larger number: " + second);
        }
        // TODO: compare the two input numbers.
    }
}
