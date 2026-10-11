package lt.techin.arraylist;

import java.util.ArrayList;

public class TheGreatest {
    public static int greatest(ArrayList<Integer> list) {
        int greatest = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > greatest) {
                greatest = list.get(i);
            }
        }
        return greatest;
    }
}
