package util;

/**
 * Created by Jeff on 1/21/15.
 */
public class Util {
    public static void printArray(int[] array) {
        if (array == null || array.length == 0) {
            System.out.println("empty");
            return;
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");

        }
        System.out.println();
    }
    public static void printArray(Integer[] array) {
        if (array == null || array.length == 0) {
            System.out.println("empty");
            return;
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");

        }
        System.out.println();
    }
}
