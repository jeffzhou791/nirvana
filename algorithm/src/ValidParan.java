import java.util.Stack;

/**
 * Created by Jeff on 1/16/15.
 */
public class ValidParan {
    public boolean isValid(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    break;
                default:
                    try {
                        char top = stack.pop();
                        if (!match(top, c)) {
                            return false;
                        }
                    } catch (Exception e) {
                        return false;
                    }
            }
        }
        return stack.isEmpty();
    }

    private boolean match(char prev, char cur) {
        return (cur == ')' && prev == '(') ||
                (cur == ']' && prev == '[') ||
                (cur == '}' && prev == '{');
    }

    public static void main(String[] args) {
        ValidParan paran = new ValidParan();
        System.out.println(paran.isValid("([{{{}}}])"));
        System.out.println(paran.isValid("([{{{}}}]))"));
        System.out.println(paran.isValid("{([{{{}}}])"));
        System.out.println(paran.isValid("]"));
    }
}
