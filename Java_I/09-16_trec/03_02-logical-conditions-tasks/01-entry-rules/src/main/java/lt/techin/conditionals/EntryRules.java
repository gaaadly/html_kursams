package lt.techin.conditionals;

import java.util.Scanner;

public class EntryRules {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Give age:");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Has ticket:");
        boolean hasTicket = Boolean.parseBoolean(scanner.nextLine());
        System.out.println("Is VIP:");
        boolean isVip = Boolean.parseBoolean(scanner.nextLine());
        System.out.println("Is blocked:");
        boolean isBlocked = Boolean.parseBoolean(scanner.nextLine());
        boolean allowed = !isBlocked && ((age >= 18 && hasTicket) || isVip);
        if (allowed) {
            System.out.println("Entry allowed.");
        } else {
            System.out.println("Entry denied.");
        }
        // TODO: read the values, build allowed, and print the decision.
    }
}
