package lt.techin.variables;

import java.util.Scanner;

public class SecondsInADay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final long HOURS_PER_DAY = 24L;
        final int MINUTES_PER_HOUR = 60;
        final int SECONDS_PER_MINUTE = 60;

        System.out.println("How many days would you like to convert to seconds?");
        int days = Integer.parseInt(scanner.nextLine());

        long seconds = days * HOURS_PER_DAY * MINUTES_PER_HOUR * SECONDS_PER_MINUTE;

        System.out.println(seconds);
        // TODO: complete the requirements in README.md / README.lt.md.
    }
}
