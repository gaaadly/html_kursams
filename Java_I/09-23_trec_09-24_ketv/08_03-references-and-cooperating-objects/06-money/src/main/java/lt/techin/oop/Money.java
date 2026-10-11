package lt.techin.oop;

public class Money {
    private final int euros;
    private final int cents;

    public Money(int euros, int cents) {
        this.euros = euros + cents / 100;
        this.cents = cents % 100;
    }

    public int euros() { return euros; }
    public int cents() { return cents; }

    @Override public String toString() {
        return euros + "." + (cents < 10 ? "0" : "") + cents + "e";
    }

    public Money plus(Money addition) {
        // TODO: return a new object with the sum.
        return new Money(this.euros + addition.euros, this.cents + addition.cents);
    }

    public boolean lessThan(Money compared) {
        // TODO: compare amounts, not object references.
        int thisTotal = this.euros * 100 + this.cents;
        int comparedTotal = compared.euros * 100 + compared.cents;
        return thisTotal < comparedTotal;
    }

    public Money minus(Money decreaser) {
        // TODO: return a new nonnegative result.
        int thisTotal = this.euros * 100 + this.cents;
        int decreaserTotal = decreaser.euros * 100 + decreaser.cents;
        int difference = thisTotal - decreaserTotal;
        if (difference < 0) {
            return new Money(0, 0);
        }
        return new Money(0, difference);
    }
}
