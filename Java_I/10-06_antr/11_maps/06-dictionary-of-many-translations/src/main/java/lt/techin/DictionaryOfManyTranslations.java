package lt.techin;

import java.util.*;

/** @author JaroslavGr */
public class DictionaryOfManyTranslations {
    private final HashMap<String, ArrayList<String>> translations = new HashMap<>();

    public DictionaryOfManyTranslations() {}

    public void add(String word, String translation) {
        // TODO: implement this method.
        if (!translations.containsKey(word)) {
            translations.put(word, new ArrayList<>());
        }
        translations.get(word).add(translation);
    }

    public ArrayList<String> translate(String word) {
        // TODO: implement this method.
        return translations.getOrDefault(word, new ArrayList<>());
    }

    public void remove(String word) {
        // TODO: implement this method.
        translations.remove(word);
    }

}
