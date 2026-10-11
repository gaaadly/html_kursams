package lt.techin.oop;

public class Hold {

    private int maximumWeight;
    private java.util.List<Suitcase> suitcases = new java.util.ArrayList<>();


    public Hold(int maximumWeight) {
        // TODO: implement the contract in README.md / README.lt.md.
        this.maximumWeight = maximumWeight;
    }

    public void addSuitcase(Suitcase suitcase) {
        // TODO: implement the contract in README.md / README.lt.md.
        if (totalWeight() + suitcase.totalWeight() <= maximumWeight) {
            suitcases.add(suitcase);
        }
    }

    public void printItems() {
        // TODO: implement the contract in README.md / README.lt.md.
        for (Suitcase suitcase : suitcases) {
            suitcase.printItems();
        }
    }

    private int totalWeight() {
        int total = 0;
        for (Suitcase suitcase : suitcases) {
            total += suitcase.totalWeight();
        }
        return total;
    }

    @Override public String toString() {
        // TODO: implement the contract in README.md / README.lt.md.
        return suitcases.size() + " suitcases (" + totalWeight() + " kg)";
    }
}