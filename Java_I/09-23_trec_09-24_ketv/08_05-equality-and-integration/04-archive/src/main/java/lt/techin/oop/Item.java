package lt.techin.oop;

public class Item {

    private String identifier;
    private String name;


    public Item(String identifier,String name) {
        // TODO: implement the contract in README.md / README.lt.md.
        this.identifier = identifier;
        this.name = name;
    }

    @Override public String toString() {
        // TODO: implement the contract in README.md / README.lt.md.
        return identifier + ": " + name;
    }

    @Override public boolean equals(Object other) {
        // TODO: implement the contract in README.md / README.lt.md.
        if (this == other) {
            return true;
        }
        if (!(other instanceof Item)) {
            return false;
        }
        Item item = (Item) other;
        return java.util.Objects.equals(identifier, item.identifier);
    }

    @Override public int hashCode() {
        // TODO: implement the contract in README.md / README.lt.md.
        return java.util.Objects.hash(identifier);
    }
}