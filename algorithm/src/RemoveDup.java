import util.ListNode;

public class RemoveDup {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode a = head;
        ListNode b;
        while (a != null && a.next != null) {
            b = a.next;
            while (b.val == a.val) {
                b = b.next;
            }
            a.next = b;
            a = b;
        }
        return head;
    }
}
