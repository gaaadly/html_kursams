package lt.techin.oop;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        // TODO: collect books, ask for a display choice, then print the requested view.
        while (true) {
            System.out.print("Title: ");
            String title = scanner.nextLine();
            if (title.isEmpty()) {
                break;
            }

            System.out.print("Pages: ");
            int pages = Integer.parseInt(scanner.nextLine());

            System.out.print("Publication year: ");
            int year = Integer.parseInt(scanner.nextLine());

            books.add(new Book(title, pages, year));
        }

        System.out.print("What information will be printed? ");
        String choice = scanner.nextLine();

        for (Book book : books) {
            if (choice.equals("everything")) {
                System.out.println(book);
            } else if (choice.equals("name")) {
                System.out.println(book.getTitle());
            }
        }
    }
}