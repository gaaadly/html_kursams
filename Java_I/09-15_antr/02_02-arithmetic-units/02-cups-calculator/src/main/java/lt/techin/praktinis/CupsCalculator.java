package lt.techin.praktinis;

public class CupsCalculator {
    public void calculateCups(int numberOfCups) {
        final int CUPS_PER_BOX = 3;

        int fullBoxes = numberOfCups / CUPS_PER_BOX;
        int leftoverCups = numberOfCups % CUPS_PER_BOX;

        System.out.println("Dėžių: " + fullBoxes);
        System.out.println("Liko puodelių: " + leftoverCups);
    }

    public static void main(String[] args) {
        new CupsCalculator().calculateCups(10);
    }
        // TODO: complete the requirements in README.md / README.lt.md.
}

