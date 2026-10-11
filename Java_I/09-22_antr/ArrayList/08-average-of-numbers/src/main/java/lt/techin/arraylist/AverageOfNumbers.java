package lt.techin.arraylist;

import java.util.ArrayList;

public class AverageOfNumbers {
    public static int sum(ArrayList<Integer> list) {
        if  (list.isEmpty()) {
            return 0;
        }
        int  sum = 0;
        for (int i : list) {
            sum += i;
        }
        return sum;
    }

    public static double average(ArrayList<Integer> list) {
        double mean = (double) sum(list) / list.size();
        return mean;
    }
}
