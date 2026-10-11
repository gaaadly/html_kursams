package lt.techin.arraylist;

import java.util.ArrayList;

public class RemoveLast {
    public static void removeLast(ArrayList<String> list) {
        // Write your code here.
        if (!list.isEmpty()) {
            list.remove(list.size() - 1);
        }
    }
}
