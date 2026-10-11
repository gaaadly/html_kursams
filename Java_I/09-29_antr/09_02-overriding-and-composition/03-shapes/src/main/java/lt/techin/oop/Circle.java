package lt.techin.oop;

public class Circle extends Shape {

    private double radius;


    public Circle() {
        // TODO: implement the contract in README.md / README.lt.md.
        this(1.0);
    }

    public Circle(double radius) {
        // TODO: implement the contract in README.md / README.lt.md.
        this(radius, "red", true);
    }

    public Circle(double radius,String color,boolean filled) {
        super(color,filled);
        this.radius = radius;
    }

    public double getRadius() {
        // TODO: implement the contract in README.md / README.lt.md.
        return radius;
    }

    public void setRadius(double radius) {
        // TODO: implement the contract in README.md / README.lt.md.
        this.radius = radius;
    }

    public double getArea() {
        // TODO: implement the contract in README.md / README.lt.md.
        return Math.PI * radius * radius;
    }

    public double getPerimeter() {
        // TODO: implement the contract in README.md / README.lt.md.
        return 2 * Math.PI * radius;
    }

    @Override public String toString() {
        // TODO: implement the contract in README.md / README.lt.md.
        return "A Circle with radius=" + radius + ", which is a subclass of " + super.toString();
    }
}