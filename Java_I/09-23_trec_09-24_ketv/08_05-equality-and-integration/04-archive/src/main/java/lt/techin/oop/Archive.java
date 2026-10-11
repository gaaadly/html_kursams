package lt.techin.oop;

public class Archive {

    private java.util.List<Item> items = new java.util.ArrayList<>();


    public boolean add(Item item) {
        // TODO: implement the contract in README.md / README.lt.md.
        if (items.contains(item)) {
            return false;
        }
        items.add(item);
        return true;
    }

    public java.util.List<Item> getItems() {
        // TODO: implement the contract in README.md / README.lt.md.
        return new java.util.ArrayList<>(items);
    }
}