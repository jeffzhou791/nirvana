/**
 * Created by Jeff on 1/12/15.
 */
public class JumpGame {
    public boolean canJump(int[] A) {
        if (A == null || A.length == 0) {
            return false;
        }
        if (A.length == 1) {
            return true;
        }
        int n = A.length;
        int relay = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (A[i] >= relay - i) {
                relay = i;
            }
        }
        return relay == 0;
    }
}
