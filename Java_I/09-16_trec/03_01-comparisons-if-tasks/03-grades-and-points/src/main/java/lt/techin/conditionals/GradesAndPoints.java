package lt.techin.conditionals;

import java.util.Scanner;

public class GradesAndPoints {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Give points:");
        int points = Integer.parseInt(scanner.nextLine());
        if (points > 100) {
            System.out.println("Grade: incredible!");
        } else if (points >= 90) {
            System.out.println("Grade: 5");
        } else if (points >= 80) {
            System.out.println("Grade: 4");
        } else if (points >= 70) {
            System.out.println("Grade: 3");
        } else if (points >= 60) {
            System.out.println("Grade: 2");
        } else if (points >= 50) {
            System.out.println("Grade: 1");
        } else if (points >= 0) {
            System.out.println("Grade: failed");
        } else {
            System.out.println("Grade: impossible!");
        }
        // TODO: classify every score, including values outside 0-100.
    }
}
