import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jeff on 1/13/15.
 */
public class SuffixTree {
    public static void main(String[] args) {
        SuffixTree tree = new SuffixTree("abaaba$");
        System.out.println(tree.contains("aba$a"));
    }

    class Node {
        Map<Integer, Node> children = new HashMap<>();
        Node suffixLink;
        Node() {
            suffixLink = this;
        }
        Node(Node suffixLink) {
            this.suffixLink = suffixLink;
        }
        void addEdge(int val, Node child) {
            if (!children.containsKey(val)) {
                children.put(val, child);
            }
        }
        boolean containsEdge(int val) {
            return children.containsKey(val);
        }
        Node getNextNode(int val) {
            return children.get(val);
        }
        void print() {
            System.out.println(suffixLink);
            for (Map.Entry<Integer, Node> entry : children.entrySet()) {
                System.out.println(String.format("%c",entry.getKey()));
                entry.getValue().print();
            }
        }
    }

    private Node root = new Node();

    SuffixTree(String s) {
        if (s == null || s.length() == 0) {
            throw new RuntimeException("Null or zero length input string");
        }
        int[] vals = toIntArray(s.toCharArray());
        Node longest = new Node(root);
        root.addEdge(vals[0], longest);
        for (int i = 1; i < vals.length; i++) {
            Node current = longest;
            Node previous = null;
            int val = vals[i];
            while (!current.containsEdge(val)) {
                Node node = new Node();
                current.addEdge(val, node);
                if (previous != null) {
                    previous.suffixLink = node;
                }
                current = current.suffixLink;
                previous = node;
            }
            if (current == root) {
                previous.suffixLink = root;
            } else {
                previous.suffixLink = current.getNextNode(val);
            }
            longest = longest.getNextNode(val);
        }
    }

    public boolean contains(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int[] input = toIntArray(s.toCharArray());
        Node node = root;
        for (int i = 0; i < input.length; i++) {
            node = node.getNextNode(input[i]);
            if (node == null && i < input.length - 1) {
                return false;
            }
        }
        return true;
    }
    private static int[] toIntArray(char[] charArray) {
        int[] intArray = new int[charArray.length];
        for (int i = 0; i < charArray.length; i++) {
            intArray[i] = (int)charArray[i];
        }
        return intArray;
    }
}
