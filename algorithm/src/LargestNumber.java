/**
 * Created by Jeff on 1/14/15.
 */
public class LargestNumber {
    public static void main(String[] args) {
        LargestNumber s = new LargestNumber();
        System.out.println(s.largestNumber(new int[] {55,555,5}));
        System.out.println(s.largestNumber(new int[] {45454,454,45,545,5}));
        System.out.println(s.largestNumber(new int[] {55,555,5,555,5555}));
        System.out.println(s.largestNumber(new int[] {0,0,0}));
        System.out.println(s.largestNumber(new int[] {1,2}));
    }
    private String[] testString;
    public String largestNumber(int[] num) {
        if (num == null || num.length == 0) {
            return null;
        }
        testString = toStrings(num);
        quicksort();
        return getLargestCombination();
    }
    private String getLargestCombination() {
        StringBuilder b = new StringBuilder();
        int i = testString.length - 1;
        while (i > 0 && testString[i].equals("0")) {
            i--;
        }
        for (; i >= 0; i--) {
            b.append(testString[i]);
        }
        return b.toString();
    }
    private void quicksort() {
        quicksort(0, testString.length-1);
    }
    private void quicksort(int s, int e) {
        if (s >= e) {
            return;
        }
        int pivot = partition(s, e);
        quicksort(s, pivot-1);
        quicksort(pivot+1, e);
    }
    private int partition(int s, int e) {
        String pivot = testString[e];
        int gate = s-1;
        int pos = s;
        while (pos < e) {
            if (compare(testString[pos], pivot) < 0) {
                swap(pos, gate+1);
                gate++;
            }
            pos++;
        }
        swap(e, gate+1);
        return gate+1;
    }
    private void swap(int i, int j) {
        if (i != j) {
            String temp = testString[i];
            testString[i] = testString[j];
            testString[j] = temp;
        }
    }

    private int compare(String a, String b) {
        char[] as = a.toCharArray();
        char[] bs = b.toCharArray();
        int i = 0;
        int j = 0;
        while (i < as.length || j < bs.length) {
            if (i == as.length) {
                i = 0;
            }
            if (j == bs.length) {
                j = 0;
            }
            if (as[i] > bs[j]) {
                return 1;
            } else if (as[i] < bs[j]) {
                return -1;
            }
            i++;
            j++;
        }
        return 0;
    }
    private static String[] toStrings(int[] num) {
        String[] strings = new String[num.length];
        for (int i = 0; i < num.length; i++) {
            strings[i] = String.valueOf(num[i]);
        }
        return strings;
    }
}
