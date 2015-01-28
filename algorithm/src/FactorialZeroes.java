/**
 * Created by Jeff on 1/19/15.
 */
public class FactorialZeroes {
    public int trailingZeroes(int n) {
        if (n < 5) {
            return 0;
        }

        int zeroes = 0;
        int base = 5;
        while (n / base > 0) {
            n = n / base;
            zeroes += n;
        }
        return zeroes;
    }
    public static void main(String[] args) {
        FactorialZeroes s = new FactorialZeroes();
        System.out.println(s.trailingZeroes(25));
    }
}
