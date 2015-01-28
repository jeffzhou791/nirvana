/**
 * Created by Jeff on 1/26/15.
 */
public class SearchRotated {
    public static void main(String[] args) {
        SearchRotated s = new SearchRotated();
        System.out.println(s.search(new int[] {4,5,6,7,1,2,3}, 5));
        System.out.println(s.search(new int[] {1,2,3,4,5,6,7}, 5));
        System.out.println(s.search(new int[] {5}, 5));
        System.out.println(s.search(new int[] {4}, 5));
        System.out.println(s.search(new int[] {1,3}, 0));
    }

    public int search(int[] A, int target) {
        if (A == null | A.length == 0) {
            return -1;
        }
        if (A.length == 1) {
            return target == A[0] ? 0 : -1;
        }
        int pivot = findPivot(A, 0, A.length - 1);
        if (pivot == -1) {
            return find(A, 0, A.length - 1, target);
        } else {
            int pos = find(A, 0, pivot - 1, target);
            return pos == -1 ? find(A, pivot, A.length-1, target) : pos;
        }
    }

    private int find(int[] A, int i, int j, int target) {
        if (A[i] > target || A[j] < target) {
            return -1;
        }
        while (i <= j) {
            int m = (i+j)/2;
            if (A[m] < target) {
                i = m + 1;
            } else if (A[m] > target) {
                j = m - 1;
            } else {
                return m;
            }
        }
        return -1;
    }

    private int findPivot(int[] A, int i, int j) {
        while (i < j) {
            int m = (i+j)/2;
            if (A[m] < A[i]) {
                if (A[m] < A[m-1]) {
                    return m;
                }
                j = m-1;
            } else if (A[m] > A[j]) {
                if (A[m] > A[m+1]) {
                    return m+1;
                }
                i = m+1;
            } else {
                return -1;
            }
        }
        return -1;
    }
}
