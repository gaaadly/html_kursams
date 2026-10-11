package lt.techin.oop;

public class Package {

    private java.util.List<Gift> gifts = new java.util.ArrayList<>();


    public Package() {
        // TODO: implement the contract in README.md / README.lt.md.
    }

    public void addGift(Gift gift) {
        // TODO: implement the contract in README.md / README.lt.md.
        gifts.add(gift);
    }

    public int totalWeight() {
        // TODO: implement the contract in README.md / README.lt.md.
        int total = 0;
        for (Gift gift : gifts) {
            total += gift.getWeight();
        }
        return total;
    }
}