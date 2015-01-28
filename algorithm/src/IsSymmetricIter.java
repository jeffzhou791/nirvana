import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jeff on 1/15/15.
 */

// Last submission shows time exceeded. Need to speed up by remembering the node position so that a long tree does not
// end up creating too many rounds
public class IsSymmetricIter {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root.left);
        nodes.add(root.right);
        while (nodes.size() != 0) {
            if (!isSymmetric(nodes)) {
                return false;
            }
            List<TreeNode> nextNodes = new ArrayList<>();
            boolean hasNode = false;
            for (TreeNode node : nodes) {
                if (node == null) {
                    nextNodes.add(null);
                    nextNodes.add(null);
                } else {
                    hasNode = true;
                    nextNodes.add(node.left);
                    nextNodes.add(node.right);
                }
            }
            if (!hasNode) {
                break;
            }
            nodes = nextNodes;
        }
        return true;
    }

    private static boolean isSymmetric(List<TreeNode> nodes) {
        int size = nodes.size();
        for (int i = 0; i < size / 2; i++) {
            if (!equals(nodes.get(i), nodes.get(size - i - 1))) {
                return false;
            }
        }
        return true;
    }

    private static boolean equals(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        return node1.val == node2.val;
    }

    public static void main(String[] args) {
        IsSymmetricIter s = new IsSymmetricIter();
        TreeNode root = new TreeNode(0);
        System.out.println(s.isSymmetric(root));
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        System.out.println(s.isSymmetric(root));
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(2);
        System.out.println(s.isSymmetric(root));
        root.left.right.left = new TreeNode(3);
        root.right.left.left = new TreeNode(3);
        System.out.println(s.isSymmetric(root));
    }
}
