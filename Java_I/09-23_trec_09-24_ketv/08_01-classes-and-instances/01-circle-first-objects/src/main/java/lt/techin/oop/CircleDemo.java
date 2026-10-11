package lt.techin.oop;

public class CircleDemo {



    public static String describe(double firstRadius,double secondRadius) {
        // TODO: implement the contract in README.md / README.lt.md.
        Circle first = new Circle(firstRadius);
        Circle second = new Circle(secondRadius);
        return "First: radius=" + first.getRadius() + ", area=" + first.getArea()
                + "\nSecond: radius=" + second.getRadius() + ", area=" + second.getArea();
    }

    public static void main(String[] args) {
        System.out.println(describe(1.0,2.0));
    }
}
