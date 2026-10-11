public class Triangle extends Shape {
    private double a = 3.0;
    private double b = 4.0;
    private double c = 5.0;

    public Triangle() {
    }

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Triangle(double a, double b, double c, String color, boolean filled) {
        super(color, filled);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double getArea() {
        double s = getPerimeter() / 2;               // Heron's formula
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public double getPerimeter() { return a + b + c; }

    @Override
    public String toString() {
        return "A Triangle with sides=" + a + ", " + b + ", " + c
                + ", which is a subclass of " + super.toString();
    }
}