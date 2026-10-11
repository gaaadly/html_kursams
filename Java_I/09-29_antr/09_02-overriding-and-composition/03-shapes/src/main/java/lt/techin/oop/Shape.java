package lt.techin.oop;

public class Shape {

    private String color;
    private boolean filled;


    public Shape() {
        // TODO: implement the contract in README.md / README.lt.md.
        this("red", true);
    }

    public Shape(String color,boolean filled) {
        // TODO: implement the contract in README.md / README.lt.md.
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        // TODO: implement the contract in README.md / README.lt.md.
        return color;
    }

    public void setColor(String color) {
        // TODO: implement the contract in README.md / README.lt.md.
        this.color = color;
    }

    public boolean isFilled() {
        // TODO: implement the contract in README.md / README.lt.md.
        return filled;
    }

    public void setFilled(boolean filled) {
        // TODO: implement the contract in README.md / README.lt.md.
        this.filled = filled;
    }

    @Override public String toString() {
        // TODO: implement the contract in README.md / README.lt.md.
        return "A Shape with color of " + color + " and " + (filled ? "filled" : "Not filled");
    }
}