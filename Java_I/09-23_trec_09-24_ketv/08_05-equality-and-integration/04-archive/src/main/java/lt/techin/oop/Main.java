package lt.techin.oop;

public class Main {



    public static void main(String[] args) {
        // TODO: implement the contract in README.md / README.lt.md.
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        Archive archive = new Archive();

        while (true) {
            System.out.println("Identifier? (empty will stop)");
            String identifier = scanner.nextLine();
            if (identifier.isEmpty()) {
                break;
            }

            System.out.println("Name? (empty will stop)");
            String name = scanner.nextLine();
            if (name.isEmpty()) {
                break;
            }

            archive.add(new Item(identifier, name));
        }

        System.out.println("==Items==");
        for (Item item : archive.getItems()) {
            System.out.println(item);
        }
    }
}