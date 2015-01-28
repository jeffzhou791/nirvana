import util.TreeNode;

/**
 * Created by Jeff on 1/16/15.
 */
public class PathSum {
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
}
