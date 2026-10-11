package lt.techin.arrays;

public class PrintNeatly {
    public static void printNeatly(int[] values) {
        // TODO
        String line = "";
        for (int i = 0; i < values.length; i++) {
            if (i == 0) {
                line = line + values[i];
            } else {
                line = line + ", " + values[i];
            }
        }
        System.out.println(line);
    }

    public static void main(String[] args) {
        int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        printNeatly(values);
    }
}
