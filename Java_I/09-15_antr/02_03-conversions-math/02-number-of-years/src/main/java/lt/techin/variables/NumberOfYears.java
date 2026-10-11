package lt.techin.variables;

import java.util.Scanner;

public class NumberOfYears {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of minutes:");
        long minutes = Long.parseLong(scanner.nextLine());

        final long MINUTES_PER_DAY = 24 * 60;
        final long DAYS_PER_YEAR = 365;
        int years = (int) (minutes / (MINUTES_PER_DAY * DAYS_PER_YEAR));
        int days = (int) ((minutes % (DAYS_PER_YEAR * MINUTES_PER_DAY)) / MINUTES_PER_DAY);

        System.out.println(minutes + " minutes is approximately " + years + " years and " + days + " days");
        // TODO: complete the requirements in README.md / README.lt.md.
    }
}
