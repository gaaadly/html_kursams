package lt.techin.oop;

public class SimpleCollection {

    private String name;
    private java.util.List<String> elements = new java.util.ArrayList<>();


    public SimpleCollection(String name) {
        this.name=name;
    }

    public void add(String element) {
        elements.add(element);
    }

    public java.util.ArrayList<String> getElements() {
        return new java.util.ArrayList<>(elements);
    }

    @Override
    public String toString() {
        // TODO: implement the contract in README.md / README.lt.md.
        if (elements.isEmpty()) {
            return "The collection " + name + " is empty.";
        }

        StringBuilder result = new StringBuilder();
        result.append("The collection ").append(name).append(" has ")
                .append(elements.size())
                .append(elements.size() == 1 ? " element:" : " elements:");

        for (String element : elements) {
            result.append("\n").append(element);
        }
        return result.toString();
    }
}
