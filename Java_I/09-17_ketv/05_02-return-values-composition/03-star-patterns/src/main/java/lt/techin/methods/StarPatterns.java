package lt.techin.methods;

public class StarPatterns {
    // TODO: declare and implement all seven methods.
    public static void printStars(int count) {
        String line = "";
        for (int i = 0; i < count; i++) {
            line = line + "*";
        }
        System.out.println(line);
    }

    public static void printSpaces(int count) {
        String line = "";
        for (int i = 0; i < count; i++) {
            line = line + " ";
        }
        System.out.print(line);
    }

    public static void printSquare(int size) {
        for (int row = 0; row < size; row++) {
            printStars(size);
        }
    }

    public static void printRectangle(int width, int height) {
        for (int row = 0; row < height; row++) {
            printStars(width);
        }
    }

    public static void printTriangle(int size) {
        for (int row = 1; row <= size; row++) {
            printStars(row);
        }
    }

    public static void printRightTriangle(int size) {
        for (int row = 1; row <= size; row++) {
            printSpaces(size - row);
            printStars(row);
        }
    }

    public static void christmasTree(int height) {
        for (int row = 1; row <= height; row++) {
            printSpaces(height - row);
            printStars(2 * row - 1);
        }
        printSpaces(height - 2);
        printStars(3);
        printSpaces(height - 2);
        printStars(3);
    }
}
