package lt.techin.oop;

public class Item {

    private String name;
    private int weight;


    public Item(String name,int weight) {
        // TODO: implement the contract in README.md / README.lt.md.
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        // TODO: implement the contract in README.md / README.lt.md.
        return name;
    }

    public int getWeight() {
        // TODO: implement the contract in README.md / README.lt.md.
        return weight;
    }

    @Override public String toString() {
        // TODO: implement the contract in README.md / README.lt.md.
        return name + " (" + weight + " kg)";
    }
}