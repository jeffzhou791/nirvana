package util;

/**
 * Created by Jeff on 1/14/15.
 */
import java.util.Arrays;
import java.util.Random;

/**
* Definition for singly-linked list.
 **/
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) {
        val = x;
        next = null;
    }

    public static ListNode createRandomList(int numberOfNodes) {
        return createList(createRandomSortedArray(numberOfNodes));
    }

    private static int[] createRandomSortedArray(int numberOfElements) {
        if (numberOfElements <= 0) {
            return null;
        }
        Random rand = new Random();
        int[] array = new int[numberOfElements];
        for (int i = 0; i < numberOfElements; i++) {
            array[i] = rand.nextInt(1000);
        }
        Arrays.sort(array);
        return array;
    }

    public static ListNode createList(int[] intArray) {
        ListNode head = new ListNode(0);
        ListNode tail = head;
        for (int element : intArray) {
            tail = add(tail, element);
        }
        return head.next;
    }

    private static ListNode add(ListNode node, int val) {
        ListNode nextNode = new ListNode(val);
        node.next = nextNode;
        return nextNode;
    }

    public static void printList(ListNode node) {
        System.out.println();
        int i = 0;
        while (node != null) {
            System.out.print(node.val);
            System.out.print(",");
            node = node.next;
            i++;
        }
        System.out.println();
        System.out.println("total of " + i);
    }
}
