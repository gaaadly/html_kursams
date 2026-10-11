package lt.techin.praktinis;

public class NumberReverter {
    public void revert(int number) {
        int hundreds = number / 100;
        int tens = (number / 10) % 10;
        int ones = number % 10;
        int reverted = ones * 100 + tens * 10 + hundreds;
        System.out.println(reverted);
        // TODO: complete the requirements in README.md / README.lt.md.
    }
}
