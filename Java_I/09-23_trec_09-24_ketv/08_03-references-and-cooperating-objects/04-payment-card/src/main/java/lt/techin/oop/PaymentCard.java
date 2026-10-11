package lt.techin.oop;

public class PaymentCard {

    public static final double AFFORDABLE_PRICE = 2.60;
    public static final double HEARTY_PRICE = 4.60;
    public static final double MAX_BALANCE = 150.0;

    private double balance;


    public PaymentCard(double openingBalance) {
        // TODO: implement the contract in README.md / README.lt.md.
        this.balance = openingBalance;
    }

    public double getBalance() {
        // TODO: implement the contract in README.md / README.lt.md.
        return this.balance;
    }

    public void eatAffordably() {
        // TODO: implement the contract in README.md / README.lt.md.
        if (this.balance >= AFFORDABLE_PRICE) {
            this.balance -= AFFORDABLE_PRICE;
        }
    }

    public void eatHeartily() {
        // TODO: implement the contract in README.md / README.lt.md.
        if (this.balance >= HEARTY_PRICE) {
            this.balance -= HEARTY_PRICE;
        }
    }

    public void addMoney(double amount) {
        // TODO: implement the contract in README.md / README.lt.md.
        if (amount < 0) {
            return;
        }
        this.balance = Math.min(this.balance + amount, MAX_BALANCE);
    }

    @Override public String toString() {
        // TODO: implement the contract in README.md / README.lt.md.
        return "The card has a balance of "
                + String.format(java.util.Locale.ROOT, "%.2f", this.balance)
                + " euros";
    }
}