package lt.techin.oop;

public class Stack {

    private java.util.List<String> values = new java.util.ArrayList<>();


    public Stack() {
        // TODO: implement the contract in README.md / README.lt.md.
    }

    public boolean isEmpty() {
        // TODO: implement the contract in README.md / README.lt.md.
        return values.isEmpty();
    }

    public void add(String value) {
        // TODO: implement the contract in README.md / README.lt.md.
        values.add(value);
    }

    public java.util.ArrayList<String> values() {
        // TODO: implement the contract in README.md / README.lt.md.
        return new java.util.ArrayList<>(values);
    }

    public String take() {
        // TODO: implement the contract in README.md / README.lt.md.
        if (values.isEmpty()) {
            return null;
        }
        return values.remove(values.size() - 1);
    }
}