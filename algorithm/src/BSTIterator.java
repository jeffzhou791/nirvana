import util.TreeNode;

import java.util.Stack;

/**
 * Created by Jeff on 1/17/15.
 */
public class BSTIterator {
    private final Stack<TreeNode> minStack = new Stack<>();
    public BSTIterator(TreeNode root) {
        storeLeftNodes(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !minStack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode next = minStack.pop();
        if (next.right != null) {
            storeLeftNodes(next.right);
        }
        return next.val;
    }

    private void storeLeftNodes(TreeNode node) {
        while (node != null) {
            minStack.push(node);
            node = node.left;
        }
    }
    public static void main(String[] args) {
        BSTIterator iter = new BSTIterator(TreeNode.fromString("1,2,#,3,4,#,#,5"));
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}
