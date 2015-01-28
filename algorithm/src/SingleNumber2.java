/**
 * Created by Jeff on 1/14/15.
 */
public class SingleNumber2 {
    public int singleNumber(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }
        int[] counts = new int[32];
        for (int a : A) {
            for (int i = 0; i < 32; i++) {
                counts[i] += (a >> i) & 1;
            }
        }
        int single = 0;
        for (int i = 0; i < 32; i++) {
            single += (counts[i] % 3) << i;
        }
        return single;
    }
    public static void main(String[] args) {
        SingleNumber2 s = new SingleNumber2();
//        System.out.println(s.singleNumber(new int[] {0,0,0,1}));
        System.out.println(s.singleNumber(new int[] {100,100,100,1,1,1,0}));
        System.out.println(s.singleNumber(new int[] {-100,-100,-100,1,1,1,-12345}));
    }
}