package lt.techin.oop;
public class Product {
    // TODO: declare name, price, quantity fields.
    private String name;
    private double price;
    private int quantity;
    public Product(String initialName, double initialPrice, int initialQuantity) {
        // TODO: store all arguments.
        name = initialName;
        price = initialPrice;
        quantity = initialQuantity;
    }
    public void printProduct() {
        // TODO: print the product line.
        System.out.println(name + ", price " + price + ", " + quantity + " pcs");
    }
}
