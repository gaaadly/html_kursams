package lt.techin.conditionals;

import java.util.Scanner;

public class ThreeNumberMaximum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Give the first number:");
        int first = Integer.parseInt(scanner.nextLine());
        System.out.println("Give the second number:");
        int second = Integer.parseInt(scanner.nextLine());
        System.out.println("Give the third number:");
        int third = Integer.parseInt(scanner.nextLine());
        int maximum = first;
        if (second > maximum) {
            maximum = second;
        }
        if (third > maximum) {
            maximum = third;
        }
        System.out.println("Maximum: " + maximum);
        // TODO: update one maximum variable with two independent checks.
    }
}
