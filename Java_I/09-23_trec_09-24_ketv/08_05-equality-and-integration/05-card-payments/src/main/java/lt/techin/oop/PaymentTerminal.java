package lt.techin.oop;
public class PaymentTerminal {
    private static final double AFFORDABLE_PRICE = 2.50;
    private static final double HEARTY_PRICE = 4.30;

    private double money;
    private int affordableMeals;
    private int heartyMeals;
    public PaymentTerminal() { // TODO: start with 1000 euros.
        money = 1000.0;
    }
    public double eatAffordably(double payment) { // TODO: cash purchase
        if (payment >= AFFORDABLE_PRICE) {
            money += AFFORDABLE_PRICE;
            affordableMeals++;
            return payment - AFFORDABLE_PRICE;
        }
        return payment;
    }
    public double eatHeartily(double payment) { // TODO: cash purchase
        if (payment >= HEARTY_PRICE) {
            money += HEARTY_PRICE;
            heartyMeals++;
            return payment - HEARTY_PRICE;
        }
        return payment;
    }
    public boolean eatAffordably(PaymentCard card) { // TODO: card purchase
        if (card.takeMoney(AFFORDABLE_PRICE)) {
            affordableMeals++;
            return true;
        }
        return false;
    }
    public boolean eatHeartily(PaymentCard card) { // TODO: card purchase
        if (card.takeMoney(HEARTY_PRICE)) {
            heartyMeals++;
            return true;
        }
        return false;
    }
    public void addMoneyToCard(PaymentCard card, double sum) { // TODO: top up
        if (sum > 0) {
            card.addMoney(sum);
            money += sum;
        }
    }
    @Override public String toString() {
        return "money: " + money + ", number of sold affordable meals: " + affordableMeals + ", number of sold hearty meals: " + heartyMeals;
    }
}