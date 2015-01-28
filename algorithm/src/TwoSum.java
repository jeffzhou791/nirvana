import util.Util;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jeff on 1/21/15.
 */
public class TwoSum {
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
        Map<Integer, Integer> numberMap = new HashMap<>();
        numberMap.put(numbers[0], 0);
        for (int i = 0; i < numbers.length; i++) {
            int remain = target - numbers[i];
            if (numberMap.containsKey(remain)) {
                return new int[] {numberMap.get(remain)+1, i+1};
            }
            numberMap.put(numbers[i], i);
        }
        return null;
    }
}
