package lt.techin.oop;

public class Apartment {

    private int rooms;
    private int squares;
    private int pricePerSquare;


    public Apartment(int rooms,int squares,int pricePerSquare) {
        // TODO: implement the contract in README.md / README.lt.md.
        this.rooms = rooms;
        this.squares = squares;
        this.pricePerSquare = pricePerSquare;
    }

    public boolean largerThan(Apartment compared) {
        // TODO: implement the contract in README.md / README.lt.md.
        return this.squares > compared.squares;
    }

    public int priceDifference(Apartment compared) {
        // TODO: implement the contract in README.md / README.lt.md.
        int thisPrice = this.squares * this.pricePerSquare;
        int comparedPrice = compared.squares * compared.pricePerSquare;
        return Math.abs(thisPrice - comparedPrice);
    }

    public boolean moreExpensiveThan(Apartment compared) {
        // TODO: implement the contract in README.md / README.lt.md.
        int thisPrice = this.squares * this.pricePerSquare;
        int comparedPrice = compared.squares * compared.pricePerSquare;
        return thisPrice > comparedPrice;
    }
}