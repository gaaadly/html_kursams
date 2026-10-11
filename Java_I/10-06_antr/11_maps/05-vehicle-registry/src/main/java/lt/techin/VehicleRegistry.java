package lt.techin;

import java.util.*;

/** @author JaroslavGr */
public class VehicleRegistry {
    private final HashMap<LicensePlate, String> owners = new HashMap<>();

    public VehicleRegistry() {}

    public boolean add(LicensePlate licensePlate, String owner) {
        // TODO: implement this method.
        if (owners.containsKey(licensePlate)) {
            return false;      // already has an owner, do nothing
        }
        owners.put(licensePlate, owner);
        return true;
    }

    public String get(LicensePlate licensePlate) {
        // TODO: implement this method.
        if (owners.containsKey(licensePlate)) {
            return owners.get(licensePlate);
        }
        return null;
    }

    public boolean remove(LicensePlate licensePlate) {
        // TODO: implement this method.
        if (owners.containsKey(licensePlate)) {
            owners.remove(licensePlate);
            return true;
        }
        return false;
    }

    public void printLicensePlates() {
        // TODO: implement this method.
        owners.keySet().forEach(licensePlate -> System.out.println(licensePlate));
    }

    public void printOwners() {
        // TODO: implement this method.
        owners.values().stream()
                .distinct()
                .forEach(owner -> System.out.println(owner));
    }

}
