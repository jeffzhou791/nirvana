import util.Util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jeff on 1/24/15.
 */
public class CountingInversion {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("IntegerArray.txt"));
        String line = reader.readLine();
        List<Integer> list = new ArrayList<>();
        while (line != null) {
            list.add(Integer.parseInt(line));
            line = reader.readLine();
        }
        Integer[] array = list.toArray(new Integer[0]);
//        Integer[] array = new Integer[] {10, 2, 20, 3, 11, 12};
        long time = System.currentTimeMillis();
        System.out.println(countInversionNaive(array));
        System.out.println("Took time " + (time - System.currentTimeMillis()));
        time = System.currentTimeMillis();
        System.out.println(countInversionAndSort(array, 0, array.length - 1));
        System.out.println("Took time " + (time - System.currentTimeMillis()));
        Util.printArray(array);
    }

    public static long countInversionNaive(Integer[] array) {
        long count = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i+1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    public static long countInversionAndSort(Integer[] array, int i, int j) {
        if (i == j) {
            return 0;
        }
        if (i + 1 == j) {
            if (array[i] > array[j]) {
                swap(array, i, j);
                return 1;
            }
            return 0;
        }
        long count = 0;
        int m = (i+j)/2;
        count += countInversionAndSort(array, i, m);
        count += countInversionAndSort(array, m+1, j);
        int[] sorted = new int[j-i+1];
        int left = i;
        int right = m+1;
        int k = 0;
        while (left <= m && right <= j) {
            if (array[left] <= array[right]) {
                sorted[k] = array[left];
                k++;
                left++;
            } else {
                sorted[k] = array[right];
                k++;
                count += m-left+1;
                right++;
            }
        }
        if (left > m) {
            while (right <= j) {
                sorted[k] = array[right];
                k++;
                right++;
            }
        } else if (right > j) {
            while (left <= m) {
                sorted[k] = array[left];
                k++;
                left++;
            }
        }
        k = 0;
        for (int l = i; l <= j; l++) {
            array[l] = sorted[k];
            k++;
        }
        return count;
    }

    private static void swap(Integer[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
