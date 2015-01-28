import util.ListNode;

/**
 * Created by Jeff on 1/21/15.
 */
public class AddTwoNumbersWrong {
    public static void main(String[] args) {
        AddTwoNumbersWrong s = new AddTwoNumbersWrong();
        ListNode.printList(s.addTwoNumbers(ListNode.createList(new int[]{9, 9, 9}), ListNode.createList(new int[]{1, 1})));
        ListNode.printList(s.addTwoNumbers(ListNode.createList(new int[] {9,8,7}), ListNode.createList(new int[] {2,3,4,5})));
        ListNode.printList(s.addTwoNumbers(ListNode.createList(new int[] {9,8,7}), null));
        ListNode.printList(s.addTwoNumbers(null, ListNode.createList(new int[] {9,8,7})));
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l2 == null) {
            return l1;
        }
        l1 = reverse(l1);
        l2 = reverse(l2);
        if (l1 == null) {
            l1 = new ListNode(0);
        }
        ListNode p1 = l1;
        boolean carryover = false;
        while (l2 != null) {
            if (carryover) {
                carryover = false;
                p1.val += 1;
            }
            p1.val += l2.val;
            if (p1.val > 9) {
                p1.val = p1.val - 10;
                carryover = true;
            }
            l2 = l2.next;
            if (p1.next == null) {
                if (carryover || l2 != null) {
                    p1.next = new ListNode(0);
                }
            }
            p1 = p1.next;
        }
        if (carryover) {
            p1.val += 1;
        }
        while (p1 != null) {
            if (p1.val > 9) {
                p1.val = p1.val - 10;
                if (p1.next != null) {
                    p1.next.val += 1;
                } else {
                    p1.next = new ListNode(1);
                }
            }
            p1 = p1.next;
        }
        return reverse(l1);
    }
    private ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode n1 = head;
        ListNode n2 = head.next;
        n1.next = null;
        while (n2 != null) {
            ListNode temp = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = temp;
        }
        return n1;
    }
}
