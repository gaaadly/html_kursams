package lt.techin.oop;

public class Employee {

    private int id;
    private String firstName;
    private String lastName;
    private int salary;


    public Employee(int id,String firstName,String lastName,int salary) {
        // TODO: implement the contract in README.md / README.lt.md.
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public int getID() {
        // TODO: implement the contract in README.md / README.lt.md.
        return id;
    }

    public String getFirstName() {
        // TODO: implement the contract in README.md / README.lt.md.
        return firstName;
    }

    public String getLastName() {
        // TODO: implement the contract in README.md / README.lt.md.
        return lastName;
    }

    public String getName() {
        // TODO: implement the contract in README.md / README.lt.md.
        return firstName + " " + lastName;
    }

    public int getSalary() {
        // TODO: implement the contract in README.md / README.lt.md.
        return salary;
    }

    public void setSalary(int salary) {
        // TODO: implement the contract in README.md / README.lt.md.
        if  (salary > 0) {
            this.salary = salary;
        }

    }

    public int getAnnualSalary() {
        // TODO: implement the contract in README.md / README.lt.md.
        return salary * 12;
    }

    public int raiseSalary(int percent) {
        // TODO: implement the contract in README.md / README.lt.md.
        if (percent>0) {
            this.salary = this.salary + this.salary * percent / 100;
            }
        return this.salary;
    }

    @Override public String toString() {
        // TODO: implement the contract in README.md / README.lt.md.
        return "Employee[id=" + id + ",name=" + firstName + " " + lastName + ",salary=" + salary + "]";
    }
}
