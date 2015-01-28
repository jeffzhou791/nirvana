import util.TreeNode;

/**
 * Created by Jeff on 1/16/15.
 */
public class FlattenTree {
    public void flatten(TreeNode root) {
        if (root != null) {
            doFlatten(root);
        }
    }

    private TreeNode doFlatten(TreeNode node) {
        TreeNode right = node.right;
        TreeNode lastNode = node;
        if (node.left != null) {
            lastNode = doFlatten(node.left);
            node.right = node.left;
            node.left = null;
            lastNode.right = right;
        }
        if (right != null) {
            lastNode = doFlatten(right);
        }
        return lastNode;
    }

    public static void main(String[] args) {
        FlattenTree s = new FlattenTree();
        TreeNode node = TreeNode.fromString("1,2,#,3,4,#,#,5");
        s.flatten(node);
        System.out.println(TreeNode.toString(node));
    }
}
