import util.ListNode;

/**
 * Created by Jeff on 1/23/15.
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode p1 = head;
        ListNode p2 = head.next;
        while (p1 != null && p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
            if (p2 != null) {
                p2 = p2.next;
            }
            if (p1 == p2) {
                return true;
            }
        }
        return false;
    }
}
