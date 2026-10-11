package lt.techin.platform;

import java.util.Scanner;

public class CourseGreeting {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What is your name?");
        String name = scanner.nextLine();

        System.out.println("Welcome to the Java course, " + name + "!");

        scanner.close();
    }
}
