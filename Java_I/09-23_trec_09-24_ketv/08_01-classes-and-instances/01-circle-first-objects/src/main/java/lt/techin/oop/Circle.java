package lt.techin.oop;

public class Circle {

    private double radius;
    private String color;

    public Circle() {
        // TODO: implement the contract in README.md / README.lt.md.
        radius = 1.0;
        color = "red";

    }

    public Circle(double radius) {
        // TODO: implement the contract in README.md / README.lt.md.
        this.radius = radius;
        color = "red";
    }

    public double getRadius() {
        // TODO: implement the contract in README.md / README.lt.md.
        return radius;
    }

    public double getArea() {
        // TODO: implement the contract in README.md / README.lt.md.
        return Math.PI*radius*radius;
    }
}
