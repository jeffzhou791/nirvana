import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Jeff on 1/22/15.
 */
public class TrappedWater {
    static class Node {
        int height;
        List<Integer> locations;
        Node(int height, List<Integer> locations) {
            this.height = height;
            this.locations = locations;
        }
    }

    static class Heap {
        Node[] nodes = new Node[1000];
        int last = 0;
        void add(Node node) {
            last++;
            nodes[last] = node;
            int i = last;
            while (i/2 > 0) {
                if (nodes[i].height > nodes[i/2].height) {
                    swap(i, i/2);
                    i = i/2;
                }
            }
        }
        Node next() {
            if (!hasNext()) {
                return null;
            }
            Node node = nodes[1];
            nodes[1] = nodes[last];
            last--;
            rebalance();
            return node;
        }

        Node peek() {
            if (!hasNext()) {
                return null;
            }
            return nodes[1];
        }

        private void rebalance() {
            int i = 1;
            while (true) {
                if (i * 2 > last) {
                    break;
                }
                if (i * 2 == last) {
                    if (nodes[i].height < nodes[i*2].height) {
                        swap(i, i*2);
                    }
                    break;
                }

                if (nodes[i].height < max(nodes[i*2].height, nodes[i*2+1].height)) {
                    if (nodes[i*2].height < nodes[i*2+1].height) {
                        swap(i, i*2+1);
                        i = i*2+1;
                    } else {
                        swap(i, i*2);
                        i = i*2;
                    }
                }
            }
        }

        private void swap(int i, int j) {
            Node temp = nodes[i];
            nodes[i] = nodes[j];
            nodes[j] = temp;
        }

        boolean hasNext() {
            return last > 0;
        }
        private int max(int i, int j) {
            return i > j ? i : j;
        }
    }

    private static final int EXIST = -1;

    public int trap(int[] A) {
        Map<Integer, List<Integer>> walls = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            List<Integer> locs = walls.get(A[i]);
            if (locs == null) {
                locs = new ArrayList<>();
                locs.add(i);
                walls.put(A[i], locs);
            } else {
                locs.add(i);
            }
        }
        Heap heap = new Heap();
        for (Map.Entry<Integer, List<Integer>> entry : walls.entrySet()) {
            heap.add(new Node(entry.getKey(), entry.getValue()));
        }
        int water = 0;
        int[] B = new int[A.length];
        while (heap.hasNext()) {
            Node node = heap.next();
            List<Integer> locs = node.locations;
            for (Integer loc : locs) {
                B[loc] = EXIST;
            }
            int i = 0;
            while (i < B.length) {
                int left = nextLeft(B, i);
                if (left == -1) {
                    break;
                }
                int right = nextRight(B, left+1);
                if (right == -1) {
                    break;
                }
                if (B[right] > 0) {
                    i = B[right];
                } else {
                    i++;
                }
                B[left] = right;
                water += node.height * (right-left-1);
                for (int j = left+1; j < right; j++) {
                    water -= A[j];
                }
            }
        }
        return water;
    }

    private int nextRight(int[] B, int start) {
        int i = start;
        while (i < B.length) {
            if (B[i] != 0) {
                return i;
            }
            i++;
        }
        return -1;
    }

    private int nextLeft(int[] B, int start) {
        int i = start;
        while (i < B.length) {
            if (B[i] == EXIST) {
                return i;
            }
            if (B[i] != 0) {
                i = B[i];
            } else {
                i++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        TrappedWater s = new TrappedWater();
        System.out.println(s.trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
