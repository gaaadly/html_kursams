package lt.techin.oop;

public class Agent {
    private String firstName;
    private String lastName;
    public Agent(String firstName,String lastName) { this.firstName=firstName;this.lastName=lastName; }

    @Override
    public String toString() {
        return "My name is " + lastName + ", " + firstName + " " + lastName;
    }
}
