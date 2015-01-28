import util.ListNode;

import java.util.*;

/**
 * Created by Jeff on 1/12/15.
 */
public class KMergeSort {
    static class MergingNode {
        int val;
        int from;
        MergingNode(int val, int from) {
            this.val = val;
            this.from = from;
        }
    }
    static class Heap {
        MergingNode[] heap;
        int last;
        Heap(int size) {
            heap = new MergingNode[size + 1];
            last = 0;
        }
        void add(MergingNode node) {
            heap[++last] = node;
            int i = last;
            while (i/2 > 0) {
                if (heap[i/2].val > heap[i].val) {
                    swap(i/2, i);
                }
                i = i/2;
            }
        }
        MergingNode remove() {
            if (last == 0) {
                return null;
            }
            if (last == 1) {
                return heap[last--];
            }
            MergingNode result = heap[1];
            heap[1] = heap[last--];
            rebalance();
            return result;
        }
        void rebalance() {
            int i = 1;
            while (i <= last / 2) {
                int indexOfMinChild = indexOfMin(2*i, 2*i+1);
                if (heap[i].val <= heap[indexOfMinChild].val) {
                    break;
                }
                swap(i, indexOfMinChild);
                i = indexOfMinChild;
            }
        }
        void swap(int i, int j) {
            MergingNode temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }
        private int indexOfMin(int i, int j) {
            return heap[i].val > heap[j].val ? j : i;
        }
        private boolean isEmpty() {
            return last == 0;
        }
    }

    public ListNode mergeKLists(List<ListNode> lists) {
        Heap heap = new Heap(lists.size());
        List<ListNode> workingLists = new ArrayList<ListNode>();
        int i = 0;
        for (ListNode list : lists) {
            if (list != null) {
                heap.add(new MergingNode(list.val, i++));
                workingLists.add(list.next);
            }
        }
        ListNode sortedTail = new ListNode(0);
        ListNode sortedHead = sortedTail;
        while (!heap.isEmpty()) {
            MergingNode node = heap.remove();
            sortedTail = add(sortedTail, node.val);
            int moreFrom = node.from;
            ListNode moreFromNode = workingLists.get(moreFrom);
            if (moreFromNode != null) {
                heap.add(new MergingNode(moreFromNode.val, moreFrom));
                workingLists.set(moreFrom, moreFromNode.next);
            }
        }
        return sortedHead.next;
    }

    private ListNode add(ListNode node, int val) {
        ListNode nextNode = new ListNode(val);
        node.next = nextNode;
        return nextNode;
    }
}