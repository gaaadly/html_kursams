package lt.techin.loops;

import java.util.Scanner;

public class NumberStreamReport {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // TODO: complete the loop program.
        int count = 0;
        int sum = 0;
        int negativeCount = 0;
        int maximum = 0;
        int positiveSum = 0;
        int positiveCount = 0;
        int evenCount = 0;
        int oddCount = 0;
        while (true) {
            System.out.println("Give a number:");
            int number = Integer.parseInt(scanner.nextLine());
            if (number == 0) {
                break;
            }
            count++;
            sum += number;
            if (count == 1 || number > maximum) {
                maximum = number;
            }
            if (number < 0) {
                negativeCount++;
            }
            if (number > 0) {
                positiveSum += number;
                positiveCount++;
            }
            if (number % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }
        System.out.println("Numbers: " + count);
        System.out.println("Sum: " + sum);
        if (count == 0) {
            System.out.println("Average: cannot calculate");
        } else {
            System.out.println("Average: " + ((double) sum / count));
        }
        System.out.println("Negative: " + negativeCount);
        if (count == 0) {
            System.out.println("Maximum: no numbers");
        } else {
            System.out.println("Maximum: " + maximum);
        }
        if (positiveCount == 0) {
            System.out.println("Positive average: cannot calculate");
        } else {
            System.out.println("Positive average: " + ((double) positiveSum / positiveCount));
        }
        System.out.println("Even: " + evenCount);
        System.out.println("Odd: " + oddCount);
    }
}
