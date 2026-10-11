package lt.techin.praktinis;

public class ConversionReport {
    public void convert(double measurement, long large, char letter) {
        int truncated = (int) measurement;
        int narrowed = (int) large;
        float approximate = large;
        long recovered = (long) approximate;
        int code = letter;

        System.out.println("Truncated: " + truncated);
        System.out.println("Narrowed: " + narrowed);
        System.out.println("Recovered: " + recovered);
        System.out.println("Code: " + code);
        // TODO: complete the requirements in README.md / README.lt.md.
    }
}
