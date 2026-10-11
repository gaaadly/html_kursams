package lt.techin.oop;

import java.util.ArrayList;
import java.util.Scanner;

public class Items {
    public static void main(String[] args) {
        ArrayList<Item> items = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        // TODO: collect names until an empty line, then print every Item.
        while (true) {
            System.out.print("Name: ");
            String name = scanner.nextLine();
            if (name.isEmpty()) {
                break;
            }
            items.add(new Item(name));
        }

        for (Item item : items) {
            System.out.println(item);
        }
    }
}
