package lt.techin.variables;

import java.util.Scanner;

public class NumericInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Give source line count:");
        int sourceLines = Integer.parseInt(scanner.nextLine());

        System.out.println("Give execution time in milliseconds:");
        double executionTimeMillis = Double.parseDouble(scanner.nextLine());

        System.out.println("Source line count: " + sourceLines);
        System.out.println("Execution time (ms): " + executionTimeMillis);

        scanner.close();
        // TODO: complete the requirements in README.md / README.lt.md.
    }
}
