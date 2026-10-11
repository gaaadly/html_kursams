package lt.techin.oop;

public class CardDemo {



    public static String scenario() {
        // TODO: implement the contract in README.md / README.lt.md.
        PaymentCard paul = new PaymentCard(20);
        PaymentCard matt = new PaymentCard(30);

        StringBuilder result = new StringBuilder();

        paul.eatHeartily();
        matt.eatAffordably();
        result.append("Paul: ").append(paul).append("\n");
        result.append("Matt: ").append(matt).append("\n");

        paul.addMoney(20);
        matt.eatHeartily();
        result.append("Paul: ").append(paul).append("\n");
        result.append("Matt: ").append(matt).append("\n");

        paul.eatAffordably();
        paul.eatAffordably();
        matt.addMoney(50);
        result.append("Paul: ").append(paul).append("\n");
        result.append("Matt: ").append(matt);

        return result.toString();
    }
}