/**
 * Created by Jeff on 1/14/15.
 */
public class UniqueBsts {
    private static final int[] answers = new int[1000];
    static {
        answers[0] = 1;
        answers[1] = 1;
    }
    public int numTrees(int n) {
        if (n < 0) {
            throw new RuntimeException();
        }
        if (answers[n] != 0) {
            return answers[n];
        }
        int i = 1;
        for (; i <= n/2; i++) {
            answers[n] += numTrees(i-1) * numTrees(n-i);
        }
        answers[n] *= 2;
        if (n%2 == 1) {
            answers[n] += numTrees(i-1) * numTrees(n-i);
        }
        return answers[n];
    }
    public static final void main(String[] args) {
        UniqueBsts s = new UniqueBsts();
        System.out.println(s.numTrees(15));
    }
}
