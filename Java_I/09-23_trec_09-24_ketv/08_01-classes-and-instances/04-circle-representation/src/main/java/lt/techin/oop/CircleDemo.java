package lt.techin.oop;

public class CircleDemo {



    public static String describe(double radius,String color) {
        // TODO: implement the contract in README.md / README.lt.md.
        Circle circle = new Circle(radius, color);
        String first = circle.toString();
        String second = "" + circle;
        return first + "\n" + second;
    }

    public static void main(String[] args) {

        System.out.println(describe(2.0,"blue"));
    }
}
