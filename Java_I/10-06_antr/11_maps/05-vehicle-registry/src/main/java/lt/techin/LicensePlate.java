package lt.techin;

import java.util.*;

/** @author JaroslavGr */
public class LicensePlate {
    private final String liNumber;
    private final String country;

    public LicensePlate(String country, String liNumber) {
        this.liNumber = liNumber;
        this.country = country;
    }
    @Override public String toString() { return country + " " + liNumber; }

    @Override public boolean equals(Object other) {
        // TODO: implement this method.
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        LicensePlate that = (LicensePlate) other;
        return Objects.equals(country, that.country)
                && Objects.equals(liNumber, that.liNumber);
    }

    @Override public int hashCode() {
        // TODO: implement this method.
        return Objects.hash(country, liNumber);
    }

}
