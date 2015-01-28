import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Jeff on 1/21/15.
 */
public class SubStringNoDup {
    public static void main(String[] args) {
        SubStringNoDup s = new SubStringNoDup();
        System.out.println(s.lengthOfLongestSubstring("wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco"));
        System.out.println(s.lengthOfLongestSubstring("aaababbcddddefghd"));
    }
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int start = 0;
        int pos = 0;
        char[] chars = s.toCharArray();
        Map<Character, Integer> charPos = new HashMap<>();
        int maxLength = 0;
        while (pos < chars.length) {
            Integer foundAt = charPos.get(chars[pos]);
            if (foundAt != null && foundAt >= start) {
                start = charPos.get(chars[pos]) + 1;
            }
            charPos.put(chars[pos], pos);
            int length = pos - start + 1;
            if (length > maxLength) {
                maxLength = length;
            }
            pos++;
        }
        return maxLength;
    }
}
