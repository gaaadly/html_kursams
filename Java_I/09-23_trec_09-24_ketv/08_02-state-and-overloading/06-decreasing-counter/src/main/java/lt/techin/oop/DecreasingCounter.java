package lt.techin.oop;

public class DecreasingCounter {
    private int value;

    public DecreasingCounter(int initialValue) {
        this.value = initialValue;
    }

    public void printValue() {
        System.out.println("value: " + this.value);
    }

    public void decrement() {
        // TODO: subtract one unless the counter is already at zero.
        if (value > 0) {
            value = value - 1;
        }
    }

    public void reset() {
        // TODO: set this counter's value to zero.
        value = 0;
    }
}