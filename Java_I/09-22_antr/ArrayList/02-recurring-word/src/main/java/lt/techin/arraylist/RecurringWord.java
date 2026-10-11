package lt.techin.arraylist;

import java.util.ArrayList;
import java.util.Scanner;

public class RecurringWord {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        ArrayList<String> words = new ArrayList<>();
        // Write your code here.
        while (true) {
            System.out.println("Type a word: ");
            String word = reader.nextLine();
            if (words.contains(word)) {
                words.add(word);
                break;
            }
            words.add(word);
        }
        System.out.println("You gave the word " + words.getLast() + " twice");
    }
}
