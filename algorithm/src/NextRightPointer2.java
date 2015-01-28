import util.TreeLinkNode;

/**
 * Created by Jeff on 1/15/15.
 */
public class NextRightPointer2 {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        root.next = null;
        connectRight(root);
    }

    private void connectRight(TreeLinkNode node) {
        if (node.left == null && node.right == null) {
            return;
        }
        TreeLinkNode nextRight = findRight(node);
        if (node.right != null) {
            node.right.next = nextRight;
            if (node.left != null) {
                node.left.next = node.right;
            }
        } else if (node.left != null) {
            node.left.next = nextRight;
        }
        if (node.right != null) {
            connectRight(node.right);
        }
        if (node.left != null) {
            connectRight(node.left);
        }
    }

    private TreeLinkNode findRight(TreeLinkNode node) {
        TreeLinkNode right = null;
        while (node.next != null && right == null) {
            right = node.next.left == null ? node.next.right : node.next.left;
            node = node.next;
        }
        return right;
    }

    public static void main(String[] args) {
        TreeLinkNode root = new TreeLinkNode(nextInt());
        root.left = new TreeLinkNode(nextInt());
        root.right = new TreeLinkNode(nextInt());
        root.left.left = new TreeLinkNode(nextInt());
        root.left.right = new TreeLinkNode(nextInt());
        root.right.right = new TreeLinkNode(nextInt());
        root.left.left.left = new TreeLinkNode(nextInt());
        root.right.right.right = new TreeLinkNode(nextInt());

        NextRightPointer2 s = new NextRightPointer2();
        s.connect(root);
        System.out.println(root);

    }
    private static int i = 1;
    private static int nextInt() {
        return i++;
    }
}
