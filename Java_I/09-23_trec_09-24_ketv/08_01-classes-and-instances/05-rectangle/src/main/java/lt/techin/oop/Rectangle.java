package lt.techin.oop;

public class Rectangle {

    private float length;
    private float width;


    public Rectangle() {
        // TODO: implement the contract in README.md / README.lt.md.
        this(1.0f, 1.0f);
    }

    public Rectangle(float length, float width) {
        // TODO: implement the contract in README.md / README.lt.md.
        this.length = length;
        this.width = width;
    }

    public float getLength() {
        // TODO: implement the contract in README.md / README.lt.md.
        return length;
    }

    public float getWidth() {
        // TODO: implement the contract in README.md / README.lt.md.
        return width;
    }

    public void setLength(float length) {
        // TODO: implement the contract in README.md / README.lt.md.
        this.length = length;
    }

    public void setWidth(float width) {
        // TODO: implement the contract in README.md / README.lt.md.
        this.width = width;
    }

    public double getArea() {
        // TODO: implement the contract in README.md / README.lt.md.
        return (double) length * width;
    }

    public double getPerimeter() {
        // TODO: implement the contract in README.md / README.lt.md.
        return 2.0 * length + 2.0 * width;
    }

    @Override public String toString() {
        // TODO: implement the contract in README.md / README.lt.md.
        return "Rectangle[length=" + length + ",width=" + width + "]";
    }
}
