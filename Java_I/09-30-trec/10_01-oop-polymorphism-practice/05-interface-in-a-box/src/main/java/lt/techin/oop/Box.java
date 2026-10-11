package lt.techin.oop;

public class Box implements Packable {

    private double capacity;private java.util.List<Packable> items=new java.util.ArrayList<>();


    public Box(double maximumCapacity) {
        // TODO: store capacity.
    }

    public void add(Packable item) {
        // TODO: implement the contract in README.md / README.lt.md.
    }

    public double weight() {
        // TODO: implement the contract in README.md / README.lt.md.
        return 0.0;
    }

    @Override public String toString() {
        // TODO: implement the contract in README.md / README.lt.md.
        return "";
    }
}
