import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class ReverseWords {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println("Original: " + s);
        System.out.println("Simplified: " + reverseWords(s));
    }
    static String reverseWords(String s) {
        String[] ws = s.split("\\s+");
        Stack<String> words = new Stack<>();
        for (String w : ws) {
            if (!w.equals("")) {
                words.push(w);
            }
        }
        StringBuilder b = new StringBuilder();
        while (words.size() > 0) {
            b.append(words.pop());
            b.append(" ");
        }
        if (b.length() > 0) {
            b.deleteCharAt(b.length() - 1);
        }
        return b.toString();
    }
}
