package lt.techin.oop;

public class ChangeHistory {

    private java.util.List<Double> values = new java.util.ArrayList<>();


    public ChangeHistory() {
        // TODO: implement the contract in README.md / README.lt.md.
    }

    public void add(double status) {
        // TODO: implement the contract in README.md / README.lt.md.
        values.add(status);
    }

    public void clear() {
        // TODO: implement the contract in README.md / README.lt.md.
        values.clear();
    }

    @Override public String toString() {
        // TODO: implement the contract in README.md / README.lt.md.
        return values.toString();
    }

    public double minValue() {
        // TODO: implement the contract in README.md / README.lt.md.
        if (values.isEmpty()) {
            return 0.0;
        }
        double min = values.get(0);
        for (double value : values) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }

    public double maxValue() {
        // TODO: implement the contract in README.md / README.lt.md.
        if (values.isEmpty()) {
            return 0.0;
        }
        double max = values.get(0);
        for (double value : values) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    public double average() {
        // TODO: implement the contract in README.md / README.lt.md.
        if (values.isEmpty()) {
            return 0.0;
        }
        double sum = 0.0;
        for (double value : values) {
            sum += value;
        }
        return sum / values.size();
    }
}