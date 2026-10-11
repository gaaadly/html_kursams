package lt.techin.oop;

public class Statistics {

    private int count;
    private int sum;


    public Statistics() {
        // TODO: implement the contract in README.md / README.lt.md.
        count = 0;
        sum = 0;
    }

    public void addNumber(int number) {
        // TODO: implement the contract in README.md / README.lt.md.
        count = count + 1;
        sum = sum + number;
    }

    public int getCount() {
        // TODO: implement the contract in README.md / README.lt.md.
        return count;
    }

    public int sum() {
        // TODO: implement the contract in README.md / README.lt.md.
        return sum;
    }

    public double average() {
        // TODO: implement the contract in README.md / README.lt.md.
        if (count == 0) {
            return 0.0;
        }
        return (double) sum / count;
    }
}