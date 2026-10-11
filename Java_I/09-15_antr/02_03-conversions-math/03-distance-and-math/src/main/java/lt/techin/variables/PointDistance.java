package lt.techin.variables;

import java.util.Scanner;

public class PointDistance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter x1:");
        double x1 = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter y1:");
        double y1 = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter x2:");
        double x2 = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter y2:");
        double y2 = Double.parseDouble(scanner.nextLine());
        double dx = x2 - x1;
        double dy = y2 - y1;
        double distance = Math.sqrt(dx * dx + dy * dy);
        System.out.println("The distance between the two points is " + distance);
        // TODO: complete the requirements in README.md / README.lt.md.
    }
}
