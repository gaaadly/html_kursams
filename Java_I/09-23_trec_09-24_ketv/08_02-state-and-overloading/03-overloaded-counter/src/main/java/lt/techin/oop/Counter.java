package lt.techin.oop;

public class Counter {

    private int value;


    public Counter() {
        // TODO: implement the contract in README.md / README.lt.md.
        this(0);
    }

    public Counter(int startValue) {
        // TODO: implement the contract in README.md / README.lt.md.
        this.value = startValue;

    }

    public int value() {
        // TODO: implement the contract in README.md / README.lt.md.
        return value;
    }

    public void increase() {
        // TODO: implement the contract in README.md / README.lt.md.
        value++;
    }

    public void decrease() {
        // TODO: implement the contract in README.md / README.lt.md.
        value--;
    }

    public void increase(int amount) {
        // TODO: implement the contract in README.md / README.lt.md.
        if (amount > 0) {
            value = value + amount;
        }
    }

    public void decrease(int amount) {
        // TODO: implement the contract in README.md / README.lt.md.
        if (amount > 0) {
            value = value - amount;
        }
    }

    public void reset() {
        // TODO: implement the contract in README.md / README.lt.md.
        value = 0;
    }
}
