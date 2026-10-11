package lt.techin.oop;

public class Person {

    private String name;
    private String address;


    public Person(String name,String address) {
        // TODO: implement the contract in README.md / README.lt.md.
        this.name = name;
        this.address = address;
    }

    @Override public String toString() {
        // TODO: implement the contract in README.md / README.lt.md.
        return name + "\n" + "  " + address;
    }
}