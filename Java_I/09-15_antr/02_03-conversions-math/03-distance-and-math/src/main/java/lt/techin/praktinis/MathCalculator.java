package lt.techin.praktinis;

public class MathCalculator {
    public void calculate(double value, int first, int second, double radius) {
        double square = Math.pow(value, 2);
        double root = Math.sqrt(value);
        long rounded = Math.round(value);
        int smaller = Math.min(first, second);
        int larger = Math.max(first, second);
        double area = Math.PI * Math.pow(radius, 2);
        System.out.println("Square: " + square);
        System.out.println("Root: " + root);
        System.out.println("Rounded: " + rounded);
        System.out.println("Smaller: " + smaller);
        System.out.println("Larger: " + larger);
        System.out.println("Area: " + area);
        // TODO: complete the requirements in README.md / README.lt.md.
    }
}
