import util.ListNode;

/**
 * Created by Jeff on 1/21/15.
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        AddTwoNumbers s = new AddTwoNumbers();
        ListNode.printList(s.addTwoNumbers(ListNode.createList(new int[]{9, 9, 9}), ListNode.createList(new int[]{1, 1})));
        ListNode.printList(s.addTwoNumbers(ListNode.createList(new int[] {9,8,7}), ListNode.createList(new int[] {2,3,4,5})));
        ListNode.printList(s.addTwoNumbers(ListNode.createList(new int[] {9,8,7}), null));
        ListNode.printList(s.addTwoNumbers(null, ListNode.createList(new int[] {9,8,7})));
        ListNode.printList(s.addTwoNumbers(ListNode.createList(new int[] {5}), ListNode.createList(new int[] {5})));
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l2 == null) {
            return l1;
        }
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
        return l1;
    }
}
