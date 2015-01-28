import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class PolishEval {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println("Original: " + s);
        System.out.println("Result: " + evalRPN(s.split(",")));
    }
    static int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        for (String token : tokens) {
            if (isNumeric(token)) {
                s.push(Integer.parseInt(token));
            } else {
                int right = s.pop();
                int left = s.pop();
                switch (token) {
                    case "+" :
                        s.push(left + right);
                        break;
                    case "-" :
                        s.push(left - right);
                        break;
                    case "*" :
                        s.push(left * right);
                        break;
                    case "/" :
                        s.push(left / right);
                        break;
                }
            }
        }
        assert s.size() == 1;
        return s.pop();
    }

    private static boolean isNumeric(String s) {
        for (char c : s.toCharArray()) {
            if (!isNumeric(c)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isNumeric(char c) {
        return c >= '0' && c <='9';
    }
}
