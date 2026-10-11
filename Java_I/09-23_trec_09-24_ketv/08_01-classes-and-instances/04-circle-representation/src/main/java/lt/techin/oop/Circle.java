package lt.techin.oop;

public class Circle {

    private double radius;
    private String color;


    public Circle() {
        this(1.0,"red");
    }

    public Circle(double radius) {
        this(radius,"red");
    }

    public Circle(double radius,String color) {
        setRadius(radius);this.color=color;
    }

    public double getRadius() {
        return radius;
    }

    public double getArea() {
        return radius*radius*Math.PI;
    }

    public String getColor() {
        return color;
    }

    public void setRadius(double radius) {
        this.radius=radius>=0?radius:0;
    }

    public void setColor(String color) {
        this.color=color;
    }

    public double getCircumference() { return radius * 2 * Math.PI; /* TODO */ }

    @Override public String toString() {
        return "Circle[radius=" + radius + ",color=" + color + "]"; /* TODO */
    }
}
