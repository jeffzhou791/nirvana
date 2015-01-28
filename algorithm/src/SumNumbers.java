import util.TreeNode;

/**
 * Created by Jeff on 1/16/15.
 */
public class SumNumbers {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return sumNumbers(root, 0);
    }

    private int sumNumbers(TreeNode node, int parentNumber) {
        int number = parentNumber * 10 + node.val;
        if (node.left == null && node.right == null) {
            return number;
        }
        int sum = 0;
        if (node.left != null) {
            sum += sumNumbers(node.left, number);
        }
        if (node.right != null) {
            sum += sumNumbers(node.right, number);
        }
        return sum;
    }


    public static void main(String[] args) {
        SumNumbers s = new SumNumbers();
        TreeNode root = new TreeNode(0);
        System.out.println(s.sumNumbers(root));
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        System.out.println(s.sumNumbers(root));
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(2);
        System.out.println(s.sumNumbers(root));
        root.left.right.left = new TreeNode(3);
        root.right.left.left = new TreeNode(3);
        root.right.left.right = new TreeNode(3);
        System.out.println(s.sumNumbers(root));
    }
}
