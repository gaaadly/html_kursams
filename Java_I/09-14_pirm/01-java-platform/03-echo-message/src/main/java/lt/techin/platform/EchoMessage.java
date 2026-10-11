package lt.techin.platform;

import java.util.Scanner;

public class EchoMessage {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a message:");
        String message = scanner.nextLine();

        System.out.println(message);

        scanner.close();
    }
}
