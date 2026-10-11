package lt.techin.oop;

public class ProductWarehouseWithHistory extends ProductWarehouse {

    private ChangeHistory changes;


    public ProductWarehouseWithHistory(String productName,double capacity,double initialBalance) {
        super(productName,capacity);changes=new ChangeHistory(); // TODO: initialize balance and history.
        super.addToWarehouse(initialBalance);
        changes.add(getBalance());
    }

    public String history() {
        // TODO: implement the contract in README.md / README.lt.md.
        return changes.toString();
    }

    @Override public void addToWarehouse(double amount) {
        // TODO: implement the contract in README.md / README.lt.md.
        super.addToWarehouse(amount);
        changes.add(getBalance());
    }

    @Override public double takeFromWarehouse(double amount) {
        // TODO: implement the contract in README.md / README.lt.md.
        double taken = super.takeFromWarehouse(amount);
        changes.add(getBalance());
        return taken;
    }

    public void printAnalysis() {
        // TODO: implement the contract in README.md / README.lt.md.
        System.out.println("Product: " + getName());
        System.out.println("History: " + changes);
        System.out.println("Largest amount of product: " + changes.maxValue());
        System.out.println("Smallest amount of product: " + changes.minValue());
        System.out.println("Average: " + changes.average());
    }
}