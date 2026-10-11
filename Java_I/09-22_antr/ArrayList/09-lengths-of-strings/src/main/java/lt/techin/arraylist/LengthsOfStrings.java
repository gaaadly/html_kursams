package lt.techin.arraylist;

import java.util.ArrayList;

public class LengthsOfStrings {
    public static ArrayList<Integer> lengths(ArrayList<String> list) {
        ArrayList<Integer> lengthList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            lengthList.add(list.get(i).length());
        }
        return lengthList;
    }
}
