import util.Util;

/**
 * Created by Jeff on 1/20/15.
 */
public class TwoSumWrongAttempt {
    public static void main(String[] args) {
        TwoSumWrongAttempt s = new TwoSumWrongAttempt();
//        Util.printArray(s.twoSum(new int[]{2, 5, 7, 9}, 7));
//        Util.printArray(s.twoSum(new int[]{2, 5, 7, 9}, 11));
//        Util.printArray(s.twoSum(new int[]{2, 5, 7, 9}, 13));
        Util.printArray(s.twoSum(new int[]{5, 75, 25}, 100));
    }
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) {
            return null;
        }
        int[] sorted = qsort(numbers);
        int end = sorted.length - 1;
        if (sorted[0] + sorted[sorted.length - 1] > target) {
            end = findEndPosition(sorted, target - sorted[0], 1, sorted.length - 1);
        }
        int[] sumParts = getSumParts(sorted, end, target);
        int first = findInArray(numbers, sumParts[0]);
        int second = findInArray(numbers, sumParts[1]);
        if (first > second) {
            int temp = first;
            first = second;
            second = temp;
        }
        return new int[] {first+1, second+1};
    }


    private int findInArray(int[] numbers, int number) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == number) {
                return i;
            }
        }
        return -1;
    }

    private int[] getSumParts(int[] sorted, int end, int target) {
        int i = 0;
        int j = end;
        while (i < j) {
            if (sorted[i] + sorted[j] > target) {
                j--;
            } else if (sorted[i] + sorted[j] < target) {
                i++;
            } else {
                break;
            }
        }
        if (i < j) {
            return new int[] {sorted[i], sorted[j]};
        }
        return null;
    }

    private static int findEndPosition(int[] sorted, int target, int i, int j) {
        while (i <= j) {
            int m = (i+j)/2;
            if (sorted[m] > target) {
                if (sorted[m-1] < target) {
                    return m;
                }
                j = m-1;
            } else if (sorted[m] < target) {
                if (sorted[m+1] > target) {
                    return m+1;
                }
                i = m+1;
            } else {
                return m;
            }
        }
        return -1;
    }

    private static int[] qsort(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return null;
        }
        if (numbers.length == 1) {
            return numbers;
        }
        int[] sorted = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            sorted[i] = numbers[i];
        }
        qsort(sorted, 0, sorted.length - 1);
        return sorted;
    }

    private static void qsort(int[] array, int i, int j) {
        if (i >= j) {
            return;
        }
        int cut = i-1;
        int pos = i;
        while (pos < j) {
            if (array[pos] < array[j]) {
                swap(array, pos, cut+1);
                cut++;
            }
            pos++;
        }
        swap(array, cut+1, j);
        qsort(array, i, cut);
        qsort(array, cut+2, j);
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
