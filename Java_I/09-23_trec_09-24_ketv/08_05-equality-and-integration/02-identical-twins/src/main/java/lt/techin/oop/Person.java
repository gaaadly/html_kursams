package lt.techin.oop;

public class Person {

    private String name;
    private SimpleDate birthday;
    private int height;
    private int weight;


    public Person(String name,SimpleDate birthday,int height,int weight) {
        this.name=name;this.birthday=birthday;this.height=height;this.weight=weight;
    }

    @Override public boolean equals(Object other) {
        // TODO: implement the contract in README.md / README.lt.md.
        if (this == other) {
            return true;
        }
        if (!(other instanceof Person)) {
            return false;
        }
        Person person = (Person) other;
        return height == person.height
                && weight == person.weight
                && java.util.Objects.equals(name, person.name)
                && java.util.Objects.equals(birthday, person.birthday);
    }

    @Override public int hashCode() {
        // TODO: implement the contract in README.md / README.lt.md.
        return java.util.Objects.hash(name, birthday, height, weight);
    }
}
