package lt.techin.oop;

public class HealthStation {

    private int count;


    public int weigh(Person person) {
        // TODO: implement the contract in README.md / README.lt.md.
        count++;
        return person.getWeight();
    }

    public void feed(Person person) {
        // TODO: implement the contract in README.md / README.lt.md.
        person.setWeight(person.getWeight() + 1);
    }

    public int weighings() {
        // TODO: implement the contract in README.md / README.lt.md.
        return count;
    }

}