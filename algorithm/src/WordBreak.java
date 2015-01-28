import java.util.*;

/**
 * Created by Jeff on 1/26/15.
 */
public class WordBreak {
    private static final String[] dictWords = {"dog", "cat", "cats", "sand", "and"};
    public static void main(String[] args) {
        WordBreak s = new WordBreak();
        System.out.println(s.wordBreak("catsanddog", new HashSet<>(Arrays.asList(dictWords))));
    }
    public boolean wordBreak(String s, Set<String> dict) {
        boolean[] goodPos = new boolean[s.length()];
        Stack<Integer> goodPosStack = new Stack<>();
        goodPosStack.push(0);
        while (!goodPosStack.isEmpty()) {
            int i = goodPosStack.pop();
            for (int j = i+1; j <= s.length(); j++) {
                if (dict.contains(s.substring(i, j))) {
                    if (j == s.length()) {
                        return true;
                    }
                    if (!goodPos[j]) {
                        goodPos[j] = true;
                        goodPosStack.push(j);
                    }
                }
            }
        }
        return false;
    }
}
