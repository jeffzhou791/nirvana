/**
 * Created by Jeff on 1/12/15.
 */
public class Sqrtx {
    public static void main(String[] args) {
        System.out.println(new Sqrtx().sqrt(2147395599));
    }
    public int sqrt(int x) {
        if (x < 0) {
            throw new RuntimeException("Cannot sqrt a negative number");
        }
        if (x == 0) {
            return 0;
        }
        if (x == 1 || x == 2 || x == 3) {
            return 1;
        }
        int i = 1;
        int j = x/2 + 1;
        while (true) {
            long m = (i+j)/2;
            if (m==i || m==j) {
                return (int)m;
            }
            if (m*m == x) {
                return (int)m;
            } else if (m*m < x) {
                i = (int)m;
            } else {
                j = (int)m;
            }
        }
    }
}
