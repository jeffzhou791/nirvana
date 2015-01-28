/**
 * Created by Jeff on 1/19/15.
 */
public class ExcelColNum {
    public int titleToNumber(String s) {
        char[] chars = s.toCharArray();
        int num = 0;
        for (int i = 0; i < chars.length; i++) {
            num += pow(26, chars.length-1-i) * toInt(chars[i]);
        }
        return num;
    }
    private int pow(int base, int exp) {
        int pow = 1;
        while (exp > 0) {
            pow = pow * base;
            exp--;
        }
        return pow;
    }
    private int toInt(char c) {
        return c - 'A' + 1;
    }
    public static void main(String[] args) {
        ExcelColNum s = new ExcelColNum();
        System.out.println(s.titleToNumber("AAA"));
        System.out.println(s.titleToNumber("Z"));
    }
}
