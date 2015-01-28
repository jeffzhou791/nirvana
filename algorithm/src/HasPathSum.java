import util.TreeNode;

/**
 * Created by Jeff on 1/16/15.
 */
public class HasPathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        return hasPathSum(root, 0, sum);
    }
    private boolean hasPathSum(TreeNode node, int sumSoFar, int sum) {
        if (node == null) {
            return false;
        }
        sumSoFar += node.val;
        if (node.left == null && node.right == null) {
            return sumSoFar == sum;
        }
        return hasPathSum(node.left, sumSoFar, sum) || hasPathSum(node.right, sumSoFar, sum);
    }

    public static void main(String[] args) {
        HasPathSum s = new HasPathSum();
        TreeNode root = new TreeNode(0);
        System.out.println(s.hasPathSum(root, 0));
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        System.out.println(s.hasPathSum(root, 2));
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(2);
        System.out.println(s.hasPathSum(root, 1));
        System.out.println(s.hasPathSum(root, 3));
        root.left.right.left = new TreeNode(3);
        root.right.left.left = new TreeNode(3);
        root.right.left.right = new TreeNode(3);
        System.out.println(s.hasPathSum(root, 5));
    }
}
