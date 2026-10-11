package lt.techin.arraylist;

import java.util.ArrayList;

public class SmartCombining {
    public static void smartCombine(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        // Write your code here.
        for (int i = 0; i < list2.size(); i++) {
            Integer value = list2.get(i);
            if (!list1.contains(value)) {
                list1.add(value);
            }
        }
    }
}