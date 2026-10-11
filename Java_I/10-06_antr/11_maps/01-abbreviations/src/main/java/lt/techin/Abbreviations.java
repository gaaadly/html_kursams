package lt.techin;

import java.util.*;

/** @author JaroslavGr */
public class Abbreviations {
    private final HashMap<String, String> abbreviations = new HashMap<>();

    public Abbreviations() {}

    public void addAbbreviation(String abbreviation, String explanation) {
        // TODO: implement this method.
        abbreviations.put(abbreviation, explanation);
    }

    public boolean hasAbbreviation(String abbreviation) {
        // TODO: implement this method.
        return abbreviations.containsKey(abbreviation);
    }

    public String findExplanationFor(String abbreviation) {
        // TODO: implement this method.
        return abbreviations.get(abbreviation);
    }

}
