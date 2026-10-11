package lt.techin.oop;

public class Room {

    private java.util.List<Person> persons = new java.util.ArrayList<>();


    public Room() {
        // TODO: implement the contract in README.md / README.lt.md.
    }

    public void add(Person person) {
        // TODO: implement the contract in README.md / README.lt.md.
        persons.add(person);
    }

    public boolean isEmpty() {
        // TODO: implement the contract in README.md / README.lt.md.
        boolean empty = persons.isEmpty();
        if (empty) {
            return true;
        }
        return false;
    }

    public java.util.ArrayList<Person> getPersons() {
        // TODO: implement the contract in README.md / README.lt.md.
        return new java.util.ArrayList<>(persons);
    }

    public Person shortest() {
        // TODO: implement the contract in README.md / README.lt.md.
        int index = indexOfShortest();
        if (index == -1) {
            return null;
        }
        return persons.get(index);
    }

    public Person take() {
        // TODO: implement the contract in README.md / README.lt.md.
        int index = indexOfShortest();
        if (index == -1) {
            return null;
        }
        return persons.remove(index);
    }

    private int indexOfShortest() {
        if (persons.isEmpty()) {
            return -1;
        }
        int shortestIndex = 0;
        for (int i = 1; i < persons.size(); i++) {
            if (persons.get(i).getHeight() < persons.get(shortestIndex).getHeight()) {
                shortestIndex = i;
            }
        }
        return shortestIndex;
    }
}