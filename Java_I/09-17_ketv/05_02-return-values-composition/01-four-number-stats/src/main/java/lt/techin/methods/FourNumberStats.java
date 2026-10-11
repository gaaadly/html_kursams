package lt.techin.methods;

public class FourNumberStats {
    // TODO: declare and implement sum and average.
    public static int sum(int first, int second, int third, int fourth) {
        return first + second + third + fourth;
    }

    public static double average(int first, int second, int third, int fourth) {
        return (double) sum(first, second, third, fourth) / 4;
    }
}
