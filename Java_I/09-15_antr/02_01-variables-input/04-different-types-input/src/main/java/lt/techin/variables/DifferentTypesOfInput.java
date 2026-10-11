package lt.techin.variables;

import java.util.Scanner;

public class DifferentTypesOfInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Give project name:");
        String projectName = scanner.nextLine();

        System.out.println("Give source line count:");
        int sourceLines = Integer.parseInt(scanner.nextLine());

        System.out.println("Give execution time in milliseconds:");
        double executionTimeMillis = Double.parseDouble(scanner.nextLine());

        System.out.println("Is compilation successful:");
        boolean compilationSuccessful = Boolean.parseBoolean(scanner.nextLine());

        System.out.println("Project name: " + projectName);
        System.out.println("Source line count: " + sourceLines);
        System.out.println("Execution time (ms): " + executionTimeMillis);
        System.out.println("Compilation successful: " + compilationSuccessful);
        // TODO: complete the requirements in README.md / README.lt.md.
    }
}
