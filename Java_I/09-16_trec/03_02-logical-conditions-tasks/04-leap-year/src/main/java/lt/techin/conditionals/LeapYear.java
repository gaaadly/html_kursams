package lt.techin.conditionals;

import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // TODO: implement the complete leap-year rule.
        System.out.println("Give a year:");
        int year = Integer.parseInt(scanner.nextLine());
        boolean isLeap = year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
        if (isLeap) {
            System.out.println("The year is a leap year.");
        } else {
            System.out.println("The year is not a leap year.");
        }
    }
}
