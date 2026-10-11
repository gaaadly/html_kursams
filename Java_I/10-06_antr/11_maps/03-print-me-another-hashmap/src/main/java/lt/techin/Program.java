package lt.techin;

import java.util.*;

/** @author JaroslavGr */
public class Program {


    public static void printValues(HashMap<String, Book> hashmap) {
        // TODO: implement this method.
        hashmap.values().forEach(book -> System.out.println(book));
    }

    public static void printValueIfNameContains(HashMap<String, Book> hashmap, String text) {
        // TODO: implement this method.
        hashmap.values().stream()
                .filter(book -> book.getName().contains(text))
                .forEach(book -> System.out.println(book));
    }

}
