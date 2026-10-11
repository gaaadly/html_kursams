import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // 6. call methods of the objects
        Circle circle = new Circle(2.0, "blue", false);
        Rectangle rectangle = new Rectangle(3.0, 5.0);
        Square square = new Square(4.0, "green", true);
        Triangle triangle = new Triangle();

        System.out.println(circle);
        System.out.println("Area: " + circle.getArea() + ", perimeter: " + circle.getPerimeter());
        square.setWidth(6.0);   // a Square stays a square
        System.out.println(square);
        System.out.println("Area: " + square.getArea() + ", perimeter: " + square.getPerimeter());
        System.out.println();

        // 7. the collection uses the parent type Shape
        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(circle);
        shapes.add(rectangle);
        shapes.add(square);
        shapes.add(triangle);
        shapes.add(new Square(2.5));

        // 8a. print all elements
        for (Shape shape : shapes) {
            System.out.println(shape);
        }

        // 8b. total area
        double totalArea = 0;
        for (Shape shape : shapes) {
            totalArea += shape.getArea();
        }
        System.out.println("Total area: " + totalArea);

        // 8c. shape with the largest perimeter
        Shape largest = shapes.get(0);
        for (Shape shape : shapes) {
            if (shape.getPerimeter() > largest.getPerimeter()) {
                largest = shape;
            }
        }
        System.out.println("Largest perimeter: " + largest.getPerimeter() + " -> " + largest);

        // 8d. only the sides of squares
        for (Shape shape : shapes) {
            if (shape instanceof Square) {
                Square s = (Square) shape;
                System.out.println("Square side: " + s.getSide());
            }
        }
    }
}