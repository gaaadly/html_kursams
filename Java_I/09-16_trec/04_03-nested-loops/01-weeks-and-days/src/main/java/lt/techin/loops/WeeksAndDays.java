package lt.techin.loops;

import java.util.Scanner;

public class WeeksAndDays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // TODO: complete the loop program.
        System.out.println("Weeks:");
        int weeks = Integer.parseInt(scanner.nextLine());
        System.out.println("Days per week:");
        int daysPerWeek = Integer.parseInt(scanner.nextLine());
        for (int week = 1; week <= weeks; week++) {
            System.out.println("Week " + week);
            for (int day = 1; day <= daysPerWeek; day++) {
                System.out.println("  Day " + day);
            }
        }
    }
}
