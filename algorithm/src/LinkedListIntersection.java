import util.ListNode;

/**
 * Created by Jeff on 1/22/15.
 */
public class LinkedListIntersection {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int lengthA = length(headA);
        int lengthB = length(headB);
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        int diff = lengthA - lengthB;
        if (lengthB > lengthA) {
            nodeA = headB;
            nodeB = headA;
            diff = -diff;
        }
        for (int i = 0; i < diff; i++) {
            nodeA = nodeA.next;
        }
        while (nodeA != null && nodeB != null) {
            if (nodeA == nodeB) {
                return nodeA;
            }
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
        return null;
    }

    private static int length(ListNode head) {
        if (head == null) {
            return 0;
        }
        int i = 0;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            i++;
        }
        return i;
    }
}
