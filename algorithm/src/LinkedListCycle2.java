import util.ListNode;

/**
 * Created by Jeff on 1/23/15.
 */
public class LinkedListCycle2 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                fast = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        while (slow != null && fast != null) {
            if (slow == fast) {
                break;
            }
            if (fast.next == null) {
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return null;
    }

    public static void main(String[] args) {
        LinkedListCycle2 s = new LinkedListCycle2();
        ListNode head = new ListNode(0);
        head.next = head;
        System.out.println(s.detectCycle(head).val);
        ListNode node1 = new ListNode(1);
        head.next = node1;
        System.out.println(s.detectCycle(head));
        head.next = node1;
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        System.out.println(s.detectCycle(head));
        head.next = node1;
        node1.next = node2;
        ListNode node3 = new ListNode(3);

        node2.next = node3;
        node3.next = head;
        System.out.println(s.detectCycle(head).val);
    }
}
