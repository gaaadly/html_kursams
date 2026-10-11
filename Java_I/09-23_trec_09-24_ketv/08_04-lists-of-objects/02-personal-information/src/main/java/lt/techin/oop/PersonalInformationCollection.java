package lt.techin.oop;

import java.util.ArrayList;
import java.util.Scanner;

public class PersonalInformationCollection {
    public static void main(String[] args) {
        ArrayList<PersonalInformation> people = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        // TODO: collect complete people until an empty first name, then print names only.
        while (true) {
            System.out.print("First name: ");
            String firstName = scanner.nextLine();
            if (firstName.isEmpty()) {
                break;
            }

            System.out.print("Last name: ");
            String lastName = scanner.nextLine();

            System.out.print("Identification number: ");
            String identificationNumber = scanner.nextLine();

            people.add(new PersonalInformation(firstName, lastName, identificationNumber));
        }

        for (PersonalInformation person : people) {
            System.out.println(person.getFirstName() + " " + person.getLastName());
        }
    }
}