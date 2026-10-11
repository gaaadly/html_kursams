package lt.techin.variables;

public class LiteralLab {
    public static void main(String[] args) {
        // TODO: correct the values and reassignment described in the task.

        long maxUnsignedInt = 2147483648L;
        float cacheRatio = 0.5F;
        double byteScale = 2.56e3;
        char driveLetter = 'C';
        var language = "Java";
        System.out.println("Max unsigned int: " + maxUnsignedInt);
        System.out.println("Cache ratio: " + cacheRatio);
        System.out.println("Byte scale: " + byteScale);
        System.out.println("Drive letter: " + driveLetter);
        System.out.println("Before: " + language);
        language = "Java 25";
        System.out.println("After: " + language);
    }
}
