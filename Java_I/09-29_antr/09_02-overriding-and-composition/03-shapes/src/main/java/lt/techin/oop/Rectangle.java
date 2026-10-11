package lt.techin.oop;

public class Rectangle extends Shape {

    private double width;
    private double length;


    public Rectangle() {
        // TODO: implement the contract in README.md / README.lt.md.
        this(1.0, 1.0);
    }

    public Rectangle(double width,double length) {
        // TODO: implement the contract in README.md / README.lt.md.
        this(width, length, "red", true);
    }

    public Rectangle(double width,double length,String color,boolean filled) {
        super(color,filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        // TODO: implement the contract in README.md / README.lt.md.
        return width;
    }

    public double getLength() {
        // TODO: implement the contract in README.md / README.lt.md.
        return length;
    }

    public void setWidth(double width) {
        // TODO: implement the contract in README.md / README.lt.md.
        this.width = width;
    }

    public void setLength(double length) {
        // TODO: implement the contract in README.md / README.lt.md.
        this.length = length;
    }

    public double getArea() {
        // TODO: implement the contract in README.md / README.lt.md.
        return width * length;
    }

    public double getPerimeter() {
        // TODO: implement the contract in README.md / README.lt.md.
        return 2 * (width + length);
    }

    @Override public String toString() {
        // TODO: implement the contract in README.md / README.lt.md.
        return "A Rectangle with width=" + width + " and length=" + length
                + ", which is a subclass of " + super.toString();
    }
}