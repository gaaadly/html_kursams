package lt.techin.arrays;

public class ArrayHistogram {
    public static void printHistogram(int[] values) {
        // TODO: use for-each for the outer traversal
        for (int value : values) {
            String line = "";
            for (int i = 0; i < value; i++) {
                line = line + "*";
            }
            System.out.println(line);
        }
    }
}
