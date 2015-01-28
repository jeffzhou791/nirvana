/**
 * Created by Jeff on 1/26/15.
 */
public class Divide {
    public static void main(String[] args) {
        Divide s = new Divide();
        System.out.println(s.divide(1023, 5));
        System.out.println(s.divide(-1023, 5));
        System.out.println(s.divide(-1, 5));
        System.out.println(s.divide(-1023, 0));
    }
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("Cannot divide by 0!");
        }
        boolean minus = (dividend ^ divisor) < 0;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int a = dividend;
        int b = divisor;
        int k = 1;
        while (b < a) {
            b = b << 1;
            k = k << 1;
        }
        int division = 0;
        while (k > 0) {
            if (a > b) {
                division += k;
                a = a - b;
            }
            b = b >> 1;
            k = k >> 1;
        }
        return minus ? -division : division;
    }
}
