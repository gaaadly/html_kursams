package lt.techin.variables;

import java.util.Scanner;

public class SumAndAverage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Give the first number:");
        int first = Integer.parseInt(scanner.nextLine());

        System.out.println("Give the second number:");
        int second = Integer.parseInt(scanner.nextLine());

        System.out.println("Give the third number:");
        int third = Integer.parseInt(scanner.nextLine());

        int sum = first + second + third;
        double average = sum / 3.0;

        System.out.println("The sum of the numbers is " + sum);
        System.out.println("The average is " + average);
        // TODO: complete the requirements in README.md / README.lt.md.
    }
}
