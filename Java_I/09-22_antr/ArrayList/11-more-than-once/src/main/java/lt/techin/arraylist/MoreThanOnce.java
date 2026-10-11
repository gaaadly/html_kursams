package lt.techin.arraylist;

import java.util.ArrayList;

public class MoreThanOnce {
    public static boolean moreThanOnce(ArrayList<Integer> list, int searched) {
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == searched) {
                count++;
                if (count >= 2) {
                    return true;
                }
            }
        }
        return false;
    }
}