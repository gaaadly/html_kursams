package lt.techin.arraylist;

import java.util.ArrayList;
import java.util.Scanner;

public class IndexOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        while (true) {
            int input = Integer.parseInt(scanner.nextLine());
            if (input == -1) {
                break;
            }
            list.add(input);
        }
        // Find and print every matching index.
        System.out.print("Search for? ");
        int searched = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == searched) {
                System.out.println(searched + " is at index " + i);
            }
        }
    }
}