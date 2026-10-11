package lt.techin.methods;

public class SmallestAndGreatest {
    // TODO: declare and implement both methods.
    public static int smallest(int first, int second) {
        return Math.min(first, second);
    }

    public static int greatest(int first, int second, int third) {
        return Math.max(first, Math.max(second, third));
    }
}
