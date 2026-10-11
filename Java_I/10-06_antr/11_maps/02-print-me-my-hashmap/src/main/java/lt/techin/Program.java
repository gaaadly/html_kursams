package lt.techin;

import java.util.*;

/** @author JaroslavGr */
public class Program {


    public static void printKeys(HashMap<String, String> hashmap) {
        // TODO: implement this method.
        for (String key : hashmap.keySet()) {
            System.out.println(key);
        }
    }

    public static void printKeysWhere(HashMap<String, String> hashmap, String text) {
        // TODO: implement this method.
        for (String key : hashmap.keySet()) {
            if (key.contains(text)) {
                System.out.println(key);
            }
        }
    }

    public static void printValuesOfKeysWhere(HashMap<String, String> hashmap, String text) {
        // TODO: implement this method.
        hashmap.entrySet().stream()
                .filter(entry -> entry.getKey().contains(text))
                .forEach(entry -> System.out.println(entry.getValue()));
    }

}
