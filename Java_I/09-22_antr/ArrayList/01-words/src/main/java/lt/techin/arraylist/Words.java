package lt.techin.arraylist;

import java.util.ArrayList;
import java.util.Scanner;

public class Words {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        ArrayList<String> words = new ArrayList<>();
        // Write your code here.
        while (true) {
            String word = reader.nextLine();
            if (word.isEmpty()) {
                break;
            }
            words.add(word);
        }
        System.out.println("You typed the following words:");
        for  (String word : words) {
            System.out.println(word);
        }
    }
}
