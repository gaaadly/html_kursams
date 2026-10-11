package lt.techin.variables;

import java.util.Scanner;

public class MilesToKilometers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final double KILOMETERS_PER_MILE = 1.6;

        System.out.println("Enter miles:");
        double miles = Double.parseDouble(scanner.nextLine());

        double kilometers = miles * KILOMETERS_PER_MILE;

        System.out.println("Kilometers: " + kilometers);
        // TODO: complete the requirements in README.md / README.lt.md.
    }
}
