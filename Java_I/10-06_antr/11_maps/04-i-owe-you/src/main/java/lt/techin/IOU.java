package lt.techin;

import java.util.*;

/** @author JaroslavGr */
public class IOU {
    private final HashMap<String, Double> debts = new HashMap<>();

    public IOU() {}

    public void setSum(String toWhom, double amount) {
        // TODO: implement this method.
        debts.put(toWhom, amount);
    }

    public double howMuchDoIOweTo(String toWhom) {
        // TODO: implement this method.
        return debts.getOrDefault(toWhom, 0.0);
    }

}
