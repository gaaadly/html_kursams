package lt.techin.arraylist;

import java.util.ArrayList;

public class SumOfNumbers {
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
}
