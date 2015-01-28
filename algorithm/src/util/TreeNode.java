package util;

/**
 * Created by Jeff on 1/15/15.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for binary tree
 **/
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }

    public static TreeNode fromString(String s) {
        TreeNode[] nodes = fromStrings(s.split(","));
        for (int i = 1; i <= (nodes.length - 1) / 2; i++) {
            if (nodes[i] != null) {
                nodes[i].left = nodes[2*i];
                nodes[i].right = 2*i+1 < nodes.length ? nodes[2*i+1] : null;
            }
        }

        return nodes[1];
    }

    private static final int NULL = Integer.MAX_VALUE;

    public static TreeNode[] fromStrings(String[] strs) {
        int last = strs.length - 1;
        TreeNode[] treeNodes = new TreeNode[last + 2];
        for (int i = 0; i <= last; i++) {
            treeNodes[i + 1] = strs[i].equals("#") ? null : new TreeNode(Integer.parseInt(strs[i]));
        }
        return treeNodes;
    }

    public static String toString(TreeNode node) {
        boolean more = true;
        List<TreeNode> nodes = new ArrayList<>(1);
        nodes.add(node);
        StringBuilder b = new StringBuilder();
        int i = 1;
        while (more) {
            List<TreeNode> nextNodes = new ArrayList<>(2^i);
            more = false;
            for (TreeNode aNode : nodes) {
                if (aNode != null) {
                    more = true;
                    b.append(aNode.val);
                    b.append(",");
                    nextNodes.add(aNode.left);
                    nextNodes.add(aNode.right);
                } else {
                    b.append("#");
                    b.append(",");
                    nextNodes.add(null);
                    nextNodes.add(null);
                }
            }
            if (containsAllNulls(nextNodes)) {
                break;
            }
            nodes = nextNodes;
        }
        int j = b.length() - 1;
        while (b.charAt(j) == '#' || b.charAt(j) == ',') {
            b.deleteCharAt(j);
            j--;
        }
        return b.toString();
    }

    private static boolean containsAllNulls(List<TreeNode> nodes) {
        for (TreeNode node : nodes) {
            if (node != null) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode node = fromString("1,2,#,3,4,#,#,5");
        System.out.println(node);
        System.out.println(TreeNode.toString(node));
    }
}
