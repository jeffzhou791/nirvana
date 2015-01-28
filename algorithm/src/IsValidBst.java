import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jeff on 1/15/15.
 */
public class IsValidBst {
    public boolean isValidBST(TreeNode root) {
        List<Integer> vals = new ArrayList<>();
        add(root, vals);
        return isSorted(vals.toArray(new Integer[0]));
    }

    private boolean isSorted(Integer[] vals) {
        for (int i = 1; i < vals.length; i++) {
            if (vals[i] <= vals[i-1]) {
                return false;
            }
        }
        return true;
    }

    private static void add(TreeNode node, List<Integer> vals) {
        if (node == null) {
            return;
        }
        add(node.left, vals);
        vals.add(node.val);
        add(node.right, vals);
    }

    public static void main(String[] args) {
        IsValidBst s = new IsValidBst();
        TreeNode root = new TreeNode(nextInt());
        System.out.println(s.isValidBST(root));
        root.left = new TreeNode(nextInt());
        root.right = new TreeNode(nextInt());
        System.out.println(s.isValidBST(root));
        root.left = new TreeNode(0);
        System.out.println(s.isValidBST(root));
        root.val = 10;
        root.left.val = 5;
        root.right.val = 15;
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(20);
        System.out.println(s.isValidBST(root));
    }
    private static int i = 1;
    private static int nextInt() {
        return i++;
    }
}
