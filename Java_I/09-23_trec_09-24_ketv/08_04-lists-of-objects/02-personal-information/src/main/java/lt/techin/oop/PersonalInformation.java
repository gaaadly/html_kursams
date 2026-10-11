package lt.techin.oop;

public class PersonalInformation {
    private final String firstName;
    private final String lastName;
    private final String identificationNumber;
    public PersonalInformation(String firstName, String lastName, String identificationNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.identificationNumber = identificationNumber;
    }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getIdentificationNumber() { return identificationNumber; }
    @Override public String toString() { return lastName + ", " + firstName + " (" + identificationNumber + ")"; }
}
