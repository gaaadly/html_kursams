package lt.techin.oop;

public class CircleDemo {



    public static String describe(double firstRadius,double secondRadius) {
        Circle first=new Circle(firstRadius);
        Circle second=new Circle(secondRadius);
        return "First: radius="+first.getRadius()+", area="+first.getArea()
            +"\nSecond: radius="+second.getRadius()+", area="+second.getArea();
    }

    public static void main(String[] args) {
        Circle c = new Circle(2);
        c.setRadius(5);
        c.setColor("blue");
        System.out.println(c.getRadius()); // 5.0
        System.out.println(c.getColor()); // blue
        System.out.println(c.getArea()); // 78.53981633974483
        c.setRadius(-3);
        System.out.println(c.getArea()); // 0.0
    }
}
