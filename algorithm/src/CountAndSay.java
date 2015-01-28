public class CountAndSay {
    public static void main(String[] args) {
        System.out.print(countAndSay(40));
    }
    public static String countAndSay(int n) {
        String s = "1";
        for (int i = 0; i < n; i++) {
            s = countAndSay(s);
        }
        return s;
    }

    private static String countAndSay(String s) {
        StringBuilder b = new StringBuilder();
        String rest = s;
        while (rest != null && rest.length() > 0) {
            rest = removeFirst(rest, b);
        }
        return b.toString();
    }

    private static String removeFirst(String s, StringBuilder b) {
        char[] chars = s.toCharArray();
        char c = chars[0];
        int i = 1;
        while (i < chars.length && chars[i] == c) {
            i++;
        }
        b.append(i);
        b.append(Integer.parseInt(String.format("%s", c)));
        if (s.length() == i) {
            return null;
        }
        return s.substring(i);
    }
}
