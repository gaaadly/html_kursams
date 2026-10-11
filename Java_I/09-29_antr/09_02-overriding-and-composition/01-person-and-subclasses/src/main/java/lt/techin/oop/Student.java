package lt.techin.oop;

public class Student extends Person {

    private int credits;


    public Student(String name,String address) {
        super(name,address);
    }

    public int credits() {
        // TODO: implement the contract in README.md / README.lt.md.
        return credits;
    }

    public void study() {
        // TODO: implement the contract in README.md / README.lt.md.
        credits++;
    }

    @Override public String toString() {
        // TODO: implement the contract in README.md / README.lt.md.
        return super.toString() + "\n" + "  " + "Study credits " + credits;
    }
}