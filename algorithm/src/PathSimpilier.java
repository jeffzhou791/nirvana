import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class PathSimpilier {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println("Original: " + s);
        System.out.println("Simplified: " + simplify(s));
    }

    static String simplify(String path) {
        String[] elements = path.split("/+");
        Stack<String> folders = new Stack<>();
        for (String element : elements) {
            if (element.equals("..")) {
                if (folders.size() > 0) {
                    folders.pop();
                }
            } else if (element.equals(".") || element.equals("")) {
                // ignore
            } else {
                folders.push(element);
            }
        }
        StringBuilder b = new StringBuilder();
        while (folders.size() > 0) {
            b.insert(0, folders.pop());
            b.insert(0, "/");
        }
        if (b.length() == 0) {
            b.append("/");
        }
        return b.toString();

    }
}
