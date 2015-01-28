import java.util.ArrayList;
import java.util.List;

public class Median {
    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1,1}, new int[]{1,2}));
    }
    public static double findMedianSortedArrays(int A[], int B[]) {
        List<Integer> integers = mergeArrays(A, B);
        if (integers == null || integers.size() == 0) {
            return -1;
        }
        int size = integers.size();
        if (size % 2 == 0 && integers.get((size -1)/2) != integers.get(size/2)) {
            return (integers.get((size -1)/2) + (double) integers.get(size/2))/2;
        }
        return integers.get((size -1) / 2);
    }

    static List<Integer> mergeArrays(int A[], int B[]) {
        List<Integer> integers = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (true) {
            if (i < A.length && j < B.length) {
                if (A[i] < B[j]) {
                    integers.add(A[i++]);
                } else {
                    integers.add(B[j++]);
                }
            } else if (i < A.length) {
                integers.add(A[i++]);
            } else if (j < B.length) {
                integers.add(B[j++]);
            } else {
                return integers;
            }
        }
    }
}
