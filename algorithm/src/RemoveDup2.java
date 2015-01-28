import util.ListNode;

/**
 * Created by Jeff on 1/14/15.
 */
//Remove dup 2
public class RemoveDup2 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode left = dummyHead;
        ListNode right = head;
        boolean dup = false;
        while (right != null) {
            if (right.next != null && right.val == right.next.val) {
                dup = true;
            } else {
                if (dup) {
                    left.next = right.next;
                    dup = false;
                } else {
                    left = right;
                }
            }
            right = right.next;
        }
        return dummyHead.next;
    }
    public static final void main(String[] args) {
        RemoveDup2 s = new RemoveDup2();
        test(ListNode.createRandomList(100), s);
        test(ListNode.createList(new int[] {0,0}), s);
        test(ListNode.createList(new int[] {1}), s);
        test(ListNode.createList(new int[] {1,1,1,1,1,2}), s);
    }

    private static final void test(ListNode head, RemoveDup2 s) {
        ListNode.printList(head);
        head = s.deleteDuplicates(head);
        ListNode.printList(head);
    }
}
