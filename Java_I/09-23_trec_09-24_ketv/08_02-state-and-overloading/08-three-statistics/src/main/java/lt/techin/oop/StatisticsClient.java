package lt.techin.oop;

import java.util.Scanner;

public class StatisticsClient {



    public static void record(int number,Statistics all,Statistics even,Statistics odd) {
        // TODO: implement the contract in README.md / README.lt.md.
        all.addNumber(number);
        if (number % 2 == 0) {
            even.addNumber(number);
        } else {
            odd.addNumber(number);
        }
    }

    public static String summary(Statistics all,Statistics even,Statistics odd) {
        // TODO: implement the contract in README.md / README.lt.md.
        return "Sum: " + all.sum() + "\nSum of even numbers: " + even.sum() + "\nSum of odd numbers: " + odd.sum();
    }

    public static void main(String[] args) {
        // TODO: implement the contract in README.md / README.lt.md.
        Scanner scanner = new Scanner(System.in);
        Statistics all = new Statistics();
        Statistics even = new Statistics();
        Statistics odd = new Statistics();
        System.out.println("Enter numbers:");
        int number = Integer.parseInt(scanner.nextLine());
        while (number != -1) {
            record(number, all, even, odd);
            number = Integer.parseInt(scanner.nextLine());
        }
        System.out.println(summary(all, even, odd));
    }
}