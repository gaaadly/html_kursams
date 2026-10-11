package lt.techin.oop;

public class Teacher extends Person {

    private int salary;


    public Teacher(String name,String address,int salary) {
        super(name,address);
        this.salary = salary;
    }

    @Override public String toString() {
        // TODO: implement the contract in README.md / README.lt.md.
        return super.toString() + "\n" + "  " + "salary " + salary + " euro/month";
    }
}