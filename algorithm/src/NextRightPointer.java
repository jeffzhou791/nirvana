import util.TreeLinkNode;

/**
 * Created by Jeff on 1/15/15.
 */
public class NextRightPointer {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        root.next = null;
        connectRight(root);
    }

    private void connectRight(TreeLinkNode node) {
        if (node.left == null || node.right == null) {
            return;
        }
        node.left.next = node.right;
        node.right.next = node.next == null ? null : node.next.left;
        connectRight(node.right);
        connectRight(node.left);
    }

    public static void main(String[] args) {
        TreeLinkNode root = new TreeLinkNode(nextInt());
        root.left = new TreeLinkNode(nextInt());
        root.right = new TreeLinkNode(nextInt());
        root.left.left = new TreeLinkNode(nextInt());
        root.left.right = new TreeLinkNode(nextInt());
        root.right.left = new TreeLinkNode(nextInt());
        root.right.right = new TreeLinkNode(nextInt());

        NextRightPointer s = new NextRightPointer();
        s.connect(root);
        System.out.println(root);

    }
    private static int i = 1;
    private static int nextInt() {
        return i++;
    }
}
