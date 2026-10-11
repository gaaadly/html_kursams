package lt.techin.platform;

import java.util.Scanner;

public class DeveloperCard {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Let's create your developer card.");

        System.out.println("What is your name?");
        String name = scanner.nextLine();

        System.out.println("What do you want to build?");
        String goal = scanner.nextLine();

        System.out.println("Developer card:");
        System.out.println("Name: " + name);
        System.out.println("Goal: " + goal);
        System.out.println("Java version: 25");

        scanner.close();
    }
}
