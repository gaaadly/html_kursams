package lt.techin.loops;

import java.util.Scanner;

public class InclusiveRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // TODO: complete the loop program.
        System.out.println("Start:");
        int start = Integer.parseInt(scanner.nextLine());
        System.out.println("End:");
        int end = Integer.parseInt(scanner.nextLine());
        for (int i = start; i <= end; i++) {
            System.out.println(i);
        }
    }
}
