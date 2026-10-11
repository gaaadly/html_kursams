package lt.techin.oop;

public class Person {
    private String name;
    private int weight;
    public Person(String name,int weight){this.name=name;this.weight=weight;}
    public String getName(){return name;}
    public int getWeight(){return weight;}
    public void setWeight(int weight){this.weight=weight;}
}
