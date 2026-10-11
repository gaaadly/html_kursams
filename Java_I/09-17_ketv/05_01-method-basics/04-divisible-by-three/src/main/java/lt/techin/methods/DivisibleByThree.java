package lt.techin.methods;

public class DivisibleByThree {
    // TODO: declare and implement divisibleByThreeInRange.
    public static void divisibleByThreeInRange(int beginning, int end) {
        for (int i = beginning; i <= end; i++) {
            if (i % 3 == 0) {
                System.out.println(i);
            }
        }
    }
}
