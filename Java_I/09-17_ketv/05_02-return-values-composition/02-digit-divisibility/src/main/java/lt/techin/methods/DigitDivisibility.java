package lt.techin.methods;

public class DigitDivisibility {
    // TODO: declare and implement digitSum and countDivisible.
    public static int digitSum(int number) {
        long n = number;
        if (n < 0) {
            n = -n;
        }
        int sum = 0;
        while (n > 0) {
            sum += (int) (n % 10);
            n /= 10;
        }
        return sum;
    }

    public static long countDivisible(int from, int to) {
        long count = 0;
        for (long i = from; i <= to; i++) {
            if (i == 0) {
                continue;
            }
            int ds = digitSum((int) i);
            if (i % ds == 0) {
                count++;
            }
        }
        return count;
    }
}
