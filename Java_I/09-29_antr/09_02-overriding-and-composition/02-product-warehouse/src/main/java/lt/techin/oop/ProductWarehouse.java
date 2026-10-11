package lt.techin.oop;

public class ProductWarehouse extends Warehouse {

    private String productName;


    public ProductWarehouse(String productName,double capacity) {
        super(capacity);
        this.productName = productName;
    }

    public String getName() {
        // TODO: implement the contract in README.md / README.lt.md.
        return productName;
    }

    public void setName(String newName) {
        // TODO: implement the contract in README.md / README.lt.md.
        this.productName = newName;
    }

    @Override public String toString() {
        // TODO: implement the contract in README.md / README.lt.md.
        return productName + ": " + super.toString();
    }
}