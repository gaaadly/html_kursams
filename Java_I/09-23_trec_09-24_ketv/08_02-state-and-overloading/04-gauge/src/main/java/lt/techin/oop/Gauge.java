package lt.techin.oop;

public class Gauge {

    private int value;


    public Gauge() {
        // TODO: implement the contract in README.md / README.lt.md.
        value = 0;
    }

    public void increase() {
        // TODO: implement the contract in README.md / README.lt.md.
        if (value < 5) {
            value = value + 1;
        }
    }

    public void decrease() {
        // TODO: implement the contract in README.md / README.lt.md.
        if (value > 0) {
            value = value - 1;
        }
    }

    public int value() {
        // TODO: implement the contract in README.md / README.lt.md.
        return value;
    }

    public boolean full() {
        // TODO: implement the contract in README.md / README.lt.md.
        return value == 5;
    }
}