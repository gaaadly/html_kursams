package lt.techin.loops;

import java.util.Scanner;

public class MultiplesReport {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // TODO: complete the loop program.
        String line = "";
        int count = 0;
        int sum = 0;
        for (int i = 10; i <= 99; i++) {
            if (i % 6 == 0) {
                if (count == 0) {
                    line = line + i;
                } else {
                    line = line + " " + i;
                }
                count++;
                sum += i;
            }
        }
        System.out.println(line);
        System.out.println("Count: " + count);
        System.out.println("Sum: " + sum);
    }
}
