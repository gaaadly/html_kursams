package lt.techin.loops;

import java.util.Scanner;

public class IntervalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // TODO: complete the loop program.
        System.out.println("First number:");
        long first = Long.parseLong(scanner.nextLine());
        System.out.println("Last number:");
        long last = Long.parseLong(scanner.nextLine());
        long sum = 0;
        for (long i = first; i <= last; i++) {
            sum += i;
        }
        System.out.println("Sum: " + sum);
    }
}
