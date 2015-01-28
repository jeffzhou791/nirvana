import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jeff on 1/12/15.
 */
public class Combinations {
    public static void main(String[] args) {
        System.out.println(new Combinations().combine(10,3).size());
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> integerLists = new ArrayList<List<Integer>>();
        integerLists.add(new ArrayList<Integer>());
        return combine(n, k, 1, integerLists);
    }

    /**
     * Add another integer to the integer list
     * @param n
     *  The space of integers
     * @param k
     *  The length of integer lists to achieve
     * @param m
     *  The current length of integer lists
     * @param integerLists
     *  The integer lists of length m
     * @return
     *  Integer list of length m+1
     */
    private List<List<Integer>> combine(int n, int k, int m, List<List<Integer>> integerLists) {
        if (m > k) {
            return integerLists;
        }
        List<List<Integer>> result = new ArrayList<>();
        if (m == 1) {

            for (List<Integer> list : integerLists) {
                for (int i = m; i <= n - k + m; i++) {
                    List<Integer> newList = new ArrayList<>(list);
                    newList.add(i);
                    result.add(newList);
                }
            }
        } else {
            for (List<Integer> list : integerLists) {
                for (int i = list.get(list.size()-1)+1; i <= n - k + m; i++) {
                    List<Integer> newList = new ArrayList<>(list);
                    newList.add(i);
                    result.add(newList);
                }
            }
        }


        return combine(n, k, m+1, result);
    }
}
