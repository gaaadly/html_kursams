package lt.techin.oop;

public class Debt {

    private double balance;
    private double interestRate;


    public Debt(double initialBalance,double initialInterestRate) {
        // TODO: implement the contract in README.md / README.lt.md.
        this.balance = initialBalance;
        this.interestRate = initialInterestRate;
    }

    public double getBalance() {
        // TODO: implement the contract in README.md / README.lt.md.
        return balance;
    }

    public void printBalance() {
        // TODO: implement the contract in README.md / README.lt.md.
        System.out.println(balance);
    }

    public void waitOneYear() {
        // TODO: implement the contract in README.md / README.lt.md.
        balance = balance * interestRate;
    }
}