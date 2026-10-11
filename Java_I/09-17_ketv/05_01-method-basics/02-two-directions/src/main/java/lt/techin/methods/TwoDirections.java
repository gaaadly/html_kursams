package lt.techin.methods;

public class TwoDirections {

    public static void main(String[] args) {
        printAscending(3);
        printDescending(3);
    }

    public static void printAscending(int end) {
        for (int i = 1; i <= end; i++) {
            System.out.println(i);
        }
    }

    public static void printDescending(int start) {
        for (int i = start; i >= 1; i--) {
            System.out.println(i);
        }
    }
    // TODO: declare and implement both methods.
}
