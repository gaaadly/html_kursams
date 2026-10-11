package lt.techin.oop;

public class Product {

    private String name;
    private String location;
    private int weight;


    public Product(String name,String location,int weight) {
        this.name=name;this.location=location;this.weight=weight;
    }

    public Product(String name) {
        // TODO: implement the contract in README.md / README.lt.md.
        this(name, "shelf", 1);
    }

    public Product(String name,String location) {
        // TODO: implement the contract in README.md / README.lt.md.
        this(name, location, 1);
    }

    public Product(String name,int weight) {
        // TODO: implement the contract in README.md / README.lt.md.
        this(name, "shelf", weight);
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public int getWeight() {
        return weight;
    }

    @Override public String toString() {
        return name+" ("+weight+" kg) can be found from the "+location;
    }
}
