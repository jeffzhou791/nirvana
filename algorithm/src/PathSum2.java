import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jeff on 1/16/15.
 */
public class PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        pathSum(root, 0, sum, path, paths);
        return paths;
    }

    private void pathSum(TreeNode node, int sumSoFar, int sum, List<Integer> path, List<List<Integer>> paths) {
        if (node == null) {
            return;
        }
        sumSoFar += node.val;
        path.add(node.val);
        if (node.left == null && node.right == null) {
            if (sumSoFar == sum) {
                paths.add(path);
            }
        } else {
            List<Integer> path2 = new ArrayList<>(path);
            pathSum(node.left, sumSoFar, sum, path, paths);
            pathSum(node.right, sumSoFar, sum, path2, paths);
        }
    }

    public static void main(String[] args) {
        PathSum2 s = new PathSum2();
        TreeNode root = new TreeNode(0);
        System.out.println(s.pathSum(root, 0));
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        System.out.println(s.pathSum(root, 2));
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(2);
        System.out.println(s.pathSum(root, 1));
        System.out.println(s.pathSum(root, 3));
        root.left.right.left = new TreeNode(3);
        root.right.left.left = new TreeNode(3);
        root.right.left.right = new TreeNode(3);
        System.out.println(s.pathSum(root, 5));
    }
}
