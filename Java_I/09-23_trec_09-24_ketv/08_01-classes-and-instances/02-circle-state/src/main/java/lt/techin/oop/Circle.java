package lt.techin.oop;

public class Circle {

    private double radius;
    private String color;


    public Circle() {
        radius=1.0;
        color="red";
    }

    public Circle(double radius) {
        setRadius(radius);
        color="red";
    }

    public double getRadius() {
        return radius;
    }

    public double getArea() {
        return radius*radius*Math.PI;
    }

    public String getColor() {
        // TODO: implement the contract in README.md / README.lt.md.
        return color;
    }

    public void setRadius(double radius) {
        // TODO: implement the contract in README.md / README.lt.md.
        if (radius < 0) {
            this.radius = 0;
        } else {
            this.radius = radius;
        }
    }

    public void setColor(String color) {
        // TODO: implement the contract in README.md / README.lt.md.
        this.color = color;
    }
}
