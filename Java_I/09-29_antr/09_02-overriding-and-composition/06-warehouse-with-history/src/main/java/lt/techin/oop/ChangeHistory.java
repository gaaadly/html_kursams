package lt.techin.oop;

public class ChangeHistory {

    private java.util.List<Double> values = new java.util.ArrayList<>();


    public ChangeHistory() {

    }

    public void add(double status) {
        values.add(status);
    }

    public void clear() {
        values.clear();
    }

    @Override public String toString() {
        return values.toString();
    }

    public double minValue() {
        if(values.isEmpty())return 0;double min=values.get(0);for(double v:values)if(v<min)min=v;return min;
    }

    public double maxValue() {
        if(values.isEmpty())return 0;double max=values.get(0);for(double v:values)if(v>max)max=v;return max;
    }

    public double average() {
        if(values.isEmpty())return 0;double sum=0;for(double v:values)sum+=v;return sum/values.size();
    }
}
