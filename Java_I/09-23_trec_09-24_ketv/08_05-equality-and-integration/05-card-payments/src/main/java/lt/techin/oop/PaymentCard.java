package lt.techin.oop;
public class PaymentCard {
    private double balance;
    public PaymentCard(double balance) { this.balance = balance; }
    public double balance() { return balance; }
    public void addMoney(double increase) { balance += increase; }
    public boolean takeMoney(double amount) {
        // TODO: subtract only when the balance is sufficient.
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }
}