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

    public String longest() {
        // TODO: implement the contract in README.md / README.lt.md.
        if (elements.isEmpty()) {
            return null;
        }

        String longest = elements.get(0);
        for (String element : elements) {
            if (element.length() > longest.length()) {
                longest = element;
            }
        }
        return longest;
    }
}
