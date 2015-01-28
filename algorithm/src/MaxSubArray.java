/**
 * Created by Jeff on 1/19/15.
 */
public class MaxSubArray {
    public int maxSubArray(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int[] B = new int[A.length];
        B[0] = A[0] > 0 ? A[0] : 0;
        int maxSum = B[0];

        for (int i = 1; i < A.length; i++) {
            int sum = B[i-1] + A[i];
            B[i] = sum > 0 ? sum : 0;
            if (sum > maxSum) {
                maxSum = sum;
            }
        }
        if (maxSum == 0) {
            maxSum = A[0];
            for (int i = 1; i < A.length; i++) {
                if (A[i] > maxSum) {
                    maxSum = A[i];
                }
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        MaxSubArray maxSubArray = new MaxSubArray();
        System.out.println(maxSubArray.maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(maxSubArray.maxSubArray(new int[] {-2,-10,-100}));
        System.out.println(maxSubArray.maxSubArray(new int[] {3,0}));
    }
}
