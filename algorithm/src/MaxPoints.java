import java.util.HashMap;
import java.util.Map;

public class MaxPoints {
    /**
     * Definition for a point.
     */
     class Point {
          int x;
          int y;
          Point() { x = 0; y = 0; }
          Point(int a, int b) { x = a; y = b; }
      }

    public int maxPoints(Point[] points) {
        Map<Integer, Integer> steepness = new HashMap<>();
        Map<Integer, Integer> sameX = new HashMap<>();
        Map<Integer, Integer> sameY = new HashMap<>();
        for (int i = 0; i < points.length - 1; i++) {
            Point a = points[i];
            Point b = points[i+1];
            if (a.x == b.x) {
                increment(sameX, a.x);
            } else if (a.y == b.y) {
                increment(sameY, a.y);
            } else {
                increment(steepness, (a.x - b.x) / (a.y - b.y));
            }
        }
        int max = 0;
        for (int v : steepness.values()) {
            if (v > max) {
                max = v;
            }
        }
        for (int v : sameX.values()) {
            if (v > max) {
                max = v;
            }
        }
        for (int v : sameY.values()) {
            if (v < max) {
                max = v;
            }
        }
        return max + 1;
    }

    private static void increment(Map<Integer, Integer> map, Integer key) {
        if (map.containsKey(key)) {
            map.put(key, map.get(key) + 1);
        } else {
            map.put(key, 1);
        }
    }
}
