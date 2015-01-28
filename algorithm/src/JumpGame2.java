import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jeff on 1/12/15.
 */
public class JumpGame2 {
    static class Node {
        int val;
        int index;
        Node(int index, int jumpLength) {
            this.index = index;
            this.val = index + jumpLength;
        }
    }
    static class Heap {
        Node[] heap;
        int last;
        Heap(int size) {
            heap = new Node[size + 1];
            last = 0;
        }
        void add(Node node) {
            heap[++last] = node;
            int i = last;
            while (i/2 > 0) {
                if (heap[i/2].val < heap[i].val) {
                    swap(i/2, i);
                }
                i = i/2;
            }
        }
        Node peek() {
            if (last == 0) {
                return null;
            }
            return heap[1];
        }
        Node remove() {
            if (last == 0) {
                return null;
            }
            if (last == 1) {
                return heap[last--];
            }
            Node result = heap[1];
            heap[1] = heap[last--];
            rebalance();
            return result;
        }
        void rebalance() {
            int i = 1;
            while (i <= last / 2) {
                int indexOfMinChild = indexOfMax(2*i, 2*i+1);
                if (heap[i].val >= heap[indexOfMinChild].val) {
                    break;
                }
                swap(i, indexOfMinChild);
                i = indexOfMinChild;
            }
        }
        void swap(int i, int j) {
            Node temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }
        private int indexOfMax(int i, int j) {
            return heap[i].val > heap[j].val ? i : j;
        }
        private boolean isEmpty() {
            return last == 0;
        }
    }

    public int jump(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }
        if (A.length == 1) {
            return 0;
        }
        int n = A.length;
        int target = n - 1;
        List<Node> relayList = new ArrayList<>();
        for (int i = n - 2; i >= 0; i--) {
            if (A[i] >= target - i) {
                target = i;
                relayList.add(new Node(i, A[i]));
            }
        }
        if (target != 0) {
            return -1;
        }
        Heap heap = new Heap(relayList.size());
        for (Node node : relayList) {
            heap.add(node);
        }
        target = n - 1;
        int steps = 0;
        while (target > 0) {
            int smallestIndex = Integer.MAX_VALUE;
            while (!heap.isEmpty() && heap.peek().val >= target) {
                Node node = heap.remove();
                if (node.index < smallestIndex) {
                    smallestIndex = node.index;
                }
            }
            steps++;
            target = smallestIndex;
        }

        return steps;
    }

    public static void main(String[] args) {
        System.out.println(new JumpGame2().jump(new int[]{2,3,1,1,4,5,0,2,3,0}));
    }
}
