package lt.techin.oop;

public class Suitcase {

    private int maximumWeight;
    private java.util.List<Item> items = new java.util.ArrayList<>();


    public Suitcase(int maximumWeight) {
        // TODO: implement the contract in README.md / README.lt.md.
        this.maximumWeight = maximumWeight;
    }

    public void addItem(Item item) {
        // TODO: implement the contract in README.md / README.lt.md.
        if (totalWeight() + item.getWeight() <= maximumWeight) {
            items.add(item);
        }
    }

    public int totalWeight() {
        // TODO: implement the contract in README.md / README.lt.md.
        int total = 0;
        for (Item item : items) {
            total += item.getWeight();
        }
        return total;
    }

    public void printItems() {
        // TODO: implement the contract in README.md / README.lt.md.
        for (Item item : items) {
            System.out.println(item);
        }
    }

    public Item heaviestItem() {
        // TODO: implement the contract in README.md / README.lt.md.
        if (items.isEmpty()) {
            return null;
        }
        Item heaviest = items.get(0);
        for (Item item : items) {
            if (item.getWeight() > heaviest.getWeight()) {
                heaviest = item;
            }
        }
        return heaviest;
    }

    @Override public String toString() {
        // TODO: implement the contract in README.md / README.lt.md.
        if (items.isEmpty()) {
            return "no items (0 kg)";
        }
        if (items.size() == 1) {
            return "1 item (" + totalWeight() + " kg)";
        }
        return items.size() + " items (" + totalWeight() + " kg)";
    }
}