import java.util.Arrays;

/**
 * Created by Jeff on 1/19/15.
 */
public class KmpMatch {
    public int findFirst(String s, String pattern) {
        return findFirst(addHead(s.toCharArray()), addHead(pattern.toCharArray())) - 1;
    }

    int findFirst(char[] text, char[] pattern) {
        int[] fallback = calculateFallback(pattern);
        int k = 0;
        for (int i = 1; i < text.length; i++) {
            while (k > 0 && text[i] != pattern[k+1]) {
                k = fallback[k];
            }
            if (text[i] == pattern[k+1]) {
                k++;
            }
            if (k == pattern.length - 1) {
                return i - k + 1;
            }
        }
        return 0;
    }

    int[] calculateFallback(char[] pattern) {
        int k = 0;
        int[] fallback = new int[pattern.length];
        fallback[0] = 0;
        fallback[1] = 0;
        for (int i = 2; i < pattern.length; i++) {
            while (k > 0 && pattern[i] != pattern[k+1]) {
                k = fallback[k];
            }
            if (pattern[i] == pattern[k+1]) {
                k++;
            }
            fallback[i] = k;
        }
        return fallback;
    }

    char[] addHead(char[] chars) {
        char[] added = new char[chars.length+1];
        added[0] = 0;
        for (int i = 0; i < chars.length; i++) {
            added[i+1] = chars[i];
        }
        return added;
    }

    private void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");

        }
        System.out.println();
    }

    public static void main(String[] args) {
        KmpMatch m = new KmpMatch();
        System.out.println(m.findFirst("aaaaaaaaa", "aaaaa"));
        System.out.println(m.findFirst("ababcdef", "abd"));
        System.out.println(m.findFirst("abababababc", "abc"));
    }
}
