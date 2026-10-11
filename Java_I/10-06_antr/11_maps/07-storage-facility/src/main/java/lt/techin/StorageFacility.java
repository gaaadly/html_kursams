package lt.techin;

import java.util.*;

/** @author JaroslavGr */
public class StorageFacility {
    private final HashMap<String, ArrayList<String>> units = new HashMap<>();

    public StorageFacility() {}

    public void add(String unit, String item) {
        // TODO: implement this method.
        if (!units.containsKey(unit)) {
            units.put(unit, new ArrayList<>());
        }
        units.get(unit).add(item);
    }

    public ArrayList<String> contents(String storageUnit) {
        // TODO: implement this method.
        return units.getOrDefault(storageUnit, new ArrayList<>());
    }

    public void remove(String storageUnit, String item) {
        // TODO: implement this method.
        ArrayList<String> items = units.get(storageUnit);
        if (items == null) {
            return;
        }
        items.remove(item);
        if (items.isEmpty()) {
            units.remove(storageUnit);
        }
    }

    public ArrayList<String> storageUnits() {
        // TODO: implement this method.
        return new ArrayList<>(units.keySet());
    }

}
