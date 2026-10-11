package lt.techin.oop;

public class Item {

    private String name; private int weight;


    public Item(String name,int weight) {
        this.name=name;this.weight=weight;
    }

    public Item(String name) {
        this(name,0);
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    @Override public boolean equals(Object other) {
        // TODO: implement the contract in README.md / README.lt.md.
        return false;
    }

    @Override public int hashCode() {
        // TODO: implement the contract in README.md / README.lt.md.
        return 0;
    }
}
