import util.Point;

import java.util.*;

/**
 * Created by Jeff on 1/20/15.
 */
public class MaxPointsOnLine {
    private static Point[] points1 = new Point[] {
            new Point(40,-23),
            new Point(9,138),
            new Point(429,115),
            new Point(50,-17),
            new Point(-3,80),
            new Point(-10,33),
            new Point(5,-21),
            new Point(-3,80),
            new Point(-6,-65),
            new Point(-18,26),
            new Point(-6,-65),
            new Point(5,72),
            new Point(0,77),
            new Point(-9,86),
            new Point(10,-2),
            new Point(-8,85),
            new Point(21,130),
            new Point(18,-6),
            new Point(-18,26),
            new Point(-1,-15),
            new Point(10,-2),
            new Point(8,69),
            new Point(-4,63),
            new Point(0,3),
            new Point(-4,40),
            new Point(-7,84),
            new Point(-8,7),
            new Point(30,154),
            new Point(16,-5),
            new Point(6,90),
            new Point(18,-6),
            new Point(5,77),
            new Point(-4,77),
            new Point(7,-13),
            new Point(-1,-45),
            new Point(16,-5),
            new Point(-9,86),
            new Point(-16,11),
            new Point(-7,84),
            new Point(1,76),
            new Point(3,77),
            new Point(10,67),
            new Point(1,-37),
            new Point(-10,-81),
            new Point(4,-11),
            new Point(-20,13),
            new Point(-10,77),
            new Point(6,-17),
            new Point(-27,2),
            new Point(-10,-81),
            new Point(10,-1),
            new Point(-9,1),
            new Point(-8,43),
            new Point(2,2),
            new Point(2,-21),
            new Point(3,82),
            new Point(8,-1),
            new Point(10,-1),
            new Point(-9,1),
            new Point(-12,42),
            new Point(16,-5),
            new Point(-5,-61),
            new Point(20,-7),
            new Point(9,-35),
            new Point(10,6),
            new Point(12,106),
            new Point(5,-21),
            new Point(-5,82),
            new Point(6,71),
            new Point(-15,34),
            new Point(-10,87),
            new Point(-14,-12),
            new Point(12,106),
            new Point(-5,82),
            new Point(-46,-45),
            new Point(-4,63),
            new Point(16,-5),
            new Point(4,1),
            new Point(-3,-53),
            new Point(0,-17),
            new Point(9,98),
            new Point(-18,26),
            new Point(-9,86),
            new Point(2,77),
            new Point(-2,-49),
            new Point(1,76),
            new Point(-3,-38),
            new Point(-8,7),
            new Point(-17,-37),
            new Point(5,72),
            new Point(10,-37),
            new Point(-4,-57),
            new Point(-3,-53),
            new Point(3,74),
            new Point(-3,-11),
            new Point(-8,7),
            new Point(1,88),
            new Point(-12,42),
            new Point(1,-37),
            new Point(2,77),
            new Point(-6,77),
            new Point(5,72),
            new Point(-4,-57),
            new Point(-18,-33),
            new Point(-12,42),
            new Point(-9,86),
            new Point(2,77),
            new Point(-8,77),
            new Point(-3,77),
            new Point(9,-42),
            new Point(16,41),
            new Point(-29,-37),
            new Point(0,-41),
            new Point(-21,18),
            new Point(-27,-34),
            new Point(0,77),
            new Point(3,74),
            new Point(-7,-69),
            new Point(-21,18),
            new Point(27,146),
            new Point(-20,13),
            new Point(21,130),
            new Point(-6,-65),
            new Point(14,-4),
            new Point(0,3),
            new Point(9,-5),
            new Point(6,-29),
            new Point(-2,73),
            new Point(-1,-15),
            new Point(1,76),
            new Point(-4,77),
            new Point(6,-29)
    };

    private static Point[] points2 = new Point[] {
            new Point(-1,-15),
            new Point(-1,-15),
            new Point(-1,-45),
            new Point(-10,-81),
            new Point(-10,-81),
            new Point(-10,33),
            new Point(-10,77),
            new Point(-10,87),
            new Point(-12,42),
            new Point(-12,42),
            new Point(-12,42),
            new Point(-14,-12),
            new Point(-15,34),
            new Point(-16,11),
            new Point(-17,-37),
            new Point(-18,-33),
            new Point(-18,26),
            new Point(-18,26),
            new Point(-18,26),
            new Point(-2,-49),
            new Point(-2,73),
            new Point(-20,13),
            new Point(-20,13),
            new Point(-21,18),
            new Point(-21,18),
            new Point(-27,-34),
            new Point(-27,2),
            new Point(-29,-37),
            new Point(-3,-11),
            new Point(-3,-38),
            new Point(-3,-53),
            new Point(-3,-53),
            new Point(-3,77),
            new Point(-3,80),
            new Point(-3,80),
            new Point(-4,-57),
            new Point(-4,-57),
            new Point(-4,40),
            new Point(-4,63),
            new Point(-4,63),
            new Point(-4,77),
            new Point(-4,77),
            new Point(-46,-45),
            new Point(-5,-61),
            new Point(-5,82),
            new Point(-5,82),
            new Point(-6,-65),
            new Point(-6,-65),
            new Point(-6,-65),
            new Point(-6,77),
            new Point(-7,-69),
            new Point(-7,84),
            new Point(-7,84),
            new Point(-8,43),
            new Point(-8,7),
            new Point(-8,7),
            new Point(-8,7),
            new Point(-8,77),
            new Point(-8,85),
            new Point(-9,1),
            new Point(-9,1),
            new Point(-9,86),
            new Point(-9,86),
            new Point(-9,86),
            new Point(-9,86),
            new Point(0,-17),
            new Point(0,-41),
            new Point(0,3),
            new Point(0,3),
            new Point(0,77),
            new Point(0,77),
            new Point(1,-37),
            new Point(1,-37),
            new Point(1,76),
            new Point(1,76),
            new Point(1,76),
            new Point(1,88),
            new Point(10,-1),
            new Point(10,-1),
            new Point(10,-2),
            new Point(10,-2),
            new Point(10,-37),
            new Point(10,6),
            new Point(10,67),
            new Point(12,106),
            new Point(12,106),
            new Point(14,-4),
            new Point(16,-5),
            new Point(16,-5),
            new Point(16,-5),
            new Point(16,-5),
            new Point(16,41),
            new Point(18,-6),
            new Point(18,-6),
            new Point(2,-21),
            new Point(2,2),
            new Point(2,77),
            new Point(2,77),
            new Point(2,77),
            new Point(20,-7),
            new Point(21,130),
            new Point(21,130),
            new Point(27,146),
            new Point(3,74),
            new Point(3,74),
            new Point(3,77),
            new Point(3,82),
            new Point(30,154),
            new Point(4,-11),
            new Point(4,1),
            new Point(40,-23),
            new Point(429,115),
            new Point(5,-21),
            new Point(5,-21),
            new Point(5,72),
            new Point(5,72),
            new Point(5,72),
            new Point(5,77),
            new Point(50,-17),
            new Point(6,-17),
            new Point(6,-29),
            new Point(6,-29),
            new Point(6,71),
            new Point(6,90),
            new Point(7,-13),
            new Point(8,-1),
            new Point(8,69),
            new Point(9,-35),
            new Point(9,-42),
            new Point(9,-5),
            new Point(9,138),
            new Point(9,98)
    };

    static class LineGroupKey {
        int i;
        int gradient;
        LineGroupKey(int pointIdx, int gradient) {
            this.i = pointIdx;
            this.gradient = gradient;
        }
        @Override
        public int hashCode() {
            int prime = 31;
            int result = 1;
            result = prime * result + i;
            result = prime * result + gradient;
            return result;
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != getClass()) {
                return false;
            }
            LineGroupKey group = (LineGroupKey)obj;
            return i == group.i && gradient == group.gradient;
        }
    }

    static class LineGroups {
        private Point[] pts;
        private List<List<Integer>> allLines = new ArrayList<>();
        Map<LineGroupKey, List<List<Integer>>> lineGroups = new HashMap<>();

        LineGroups(Point[] pts) {
            this.pts = pts;
        }

        List<Integer> add(int existing, int coming) {
            List<Integer> visited = new ArrayList<>();
            int gradient = calculateGradient(existing, coming);
            List<List<Integer>> pointLists = get(existing, gradient);
            if (pointLists != null) {
                boolean found = false;
                for (List<Integer> pointList : pointLists) {
                    int anotherPoint = pointList.get(0) == existing ? pointList.get(1) : pointList.get(0);
                    if (onSameLine(existing, coming, anotherPoint)) {
                        found = true;
                        pointList.add(coming);
                        lineGroups.put(new LineGroupKey(coming, gradient),
                                new ArrayList<>(Arrays.asList(pointList)));
                        visited.addAll(pointList);
                    }
                }
                if (!found) {
                    List<Integer> pointList = createList(existing, coming);
                    lineGroups.put(new LineGroupKey(coming, gradient), new ArrayList<>(Arrays.asList(pointList)));
                    pointLists.add(pointList);
                }
            } else {
                List<Integer> pointList = createList(existing, coming);
                lineGroups.put(new LineGroupKey(existing, gradient), new ArrayList<>(Arrays.asList(pointList)));
                add(coming, gradient, existing);
            }
            return visited;
        }

        void add(int pointIdx, int gradient, int anotherPointIdx) {
            List<List<Integer>> pointLists = get(pointIdx, gradient);
            if (pointLists == null) {
                lineGroups.put(new LineGroupKey(pointIdx, gradient),
                        new ArrayList<>(Arrays.asList(createList(pointIdx, anotherPointIdx))));
            } else {
                pointLists.add(createList(pointIdx, anotherPointIdx));
            }
        }

        int getMostPoints(Map<Integer, Integer> occurrences) {
            int max = 0;
            int idx = -1;
            int i = 0;
            for (List<Integer> line : allLines) {
                int size = getSize(line, occurrences);
                if (size > max) {
                    max = size;
                    idx = i;
                }
                i++;
            }
            System.out.println(allLines.get(idx));
            return max;
        }

        int getSize(List<Integer> line, Map<Integer, Integer> occurrences) {
            int i = 0;
            for (Integer idx : line) {
                i += occurrences.get(idx);
            }
            return i;
        }

        List<List<Integer>> get(int pointIdx, int gradient) {
            return lineGroups.get(new LineGroupKey(pointIdx, gradient));
        }



        private boolean onSameLine(int idx1, int idx2, int idx3) {
            Point p1 = pts[idx1];
            Point p2 = pts[idx2];
            Point p3 = pts[idx3];
            return (p3.x - p1.x)*(p2.y - p1.y) == (p3.y - p1.y)*(p2.x - p1.x);
        }

        private List<Integer> createList(int... ints) {
            List<Integer> list = new ArrayList<>();
            for (int i : ints) {
                list.add(i);
            }
            allLines.add(list);
            return list;
        }

        private int calculateGradient(int idx1, int idx2) {
            Point p1 = pts[idx1];
            Point p2 = pts[idx2];
            if (p1.y == p2.y) {
                return Integer.MAX_VALUE;
            }
            return (p1.x-p2.x)/(p1.y-p2.y);
        }
    }


    private static long signature(Point p1) {
        return (p1.x + "," + p1.y).hashCode();
//        long signature = 0L;
//        signature = signature | p1.x;
//        signature = signature << 32 | p1.y;
//        return signature;
    }

    private static Point[] deDup(Point[] points, Map<Integer, Integer> occurrences) {
        Map<Long, Integer> pointMap = new HashMap<>();
        int j = 0;
        List<Point> deDuped = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            long signature = signature(points[i]);
            if (pointMap.containsKey(signature)) {
                int idx = pointMap.get(signature);
                occurrences.put(idx, occurrences.get(idx)+1);
            } else {
                pointMap.put(signature, j);
                occurrences.put(j, 1);
                deDuped.add(points[i]);
                j++;
            }
        }
        return deDuped.toArray(new Point[0]);
    }

    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        if (points.length == 1 || points.length == 2) {
            return points.length;
        }
        Map<Integer, Integer> occurrences = new HashMap<>();
        Point[] deDuped = deDup(points, occurrences);
        LineGroups lineGroups = new LineGroups(deDuped);
        if (deDuped.length == 1) {
            return occurrences.get(0);
        }
        lineGroups.add(0, 1);
        for (int i = 2; i < deDuped.length; i++) {
            boolean[] visited = new boolean[i+1];
            for (int j = 0; j < i; j++) {
                if (visited[j]) {
                    continue;
                }
                List<Integer> visitedIndices = lineGroups.add(j, i);
                for (int visitedIndex : visitedIndices) {
                    visited[visitedIndex] = true;
                }
            }
        }
        return lineGroups.getMostPoints(occurrences);
    }

    public static void main(String[] args) {
        MaxPointsOnLine s = new MaxPointsOnLine();


        MaxPointsOnLine s2 = new MaxPointsOnLine();
        List<Point> list1 = new ArrayList<>(Arrays.asList(points1));
        List<Point> list2 = new ArrayList<>(Arrays.asList(points2));
        System.out.println(s.maxPoints(list1.toArray(new Point[0])));
        System.out.println(s.maxPoints(list2.toArray(new Point[0])));
//        int toRemove = 0;
//        while (toRemove < list1.size()) {
//            List<Point> l1 = new ArrayList<>(list1);
//            List<Point> l2 = new ArrayList<>(list2);
//
//            Point p1 = l1.remove(toRemove);
//            for (int i = 0; i < l2.size(); i++) {
//                Point p2 = l2.get(i);
//                if (p2.x == p1.x && p2.y == p1.y) {
//                    l2.remove(i);
//                    break;
//                }
//            }
//
//            if (s.maxPoints(l1.toArray(new Point[0])) != s2.maxPoints(l2.toArray(new Point[0]))) {
//                list1 = l1;
//                list2 = l2;
//            } else {
//                toRemove++;
//            }
//        }
//        System.out.println(list1);
//        System.out.println(list2);
//        System.out.println(s.maxPoints(list1.toArray(new Point[0])));
//        System.out.println(s.maxPoints(list2.toArray(new Point[0])));
//        System.out.println(s.maxPoints(new Point[] {
//                new Point(1,2),
//                new Point(2,3),
//                new Point(3,4),
//                new Point(0,2),
//                new Point(1,3),
//                new Point(3,5),
//                new Point(4,6),
//                new Point(4,7)
//        }));

//        System.out.println(s.maxPoints(new Point[] {
//                new Point(1,2),
//                new Point(2,3),
//                new Point(3,4),
//                new Point(0,2),
//                new Point(1,3),
//                new Point(3,5),
//                new Point(4,6),
//                new Point(4,7),
//                new Point(5,7),
//                new Point(6,7),
//                new Point(7,7),
//                new Point(8,7),
//                new Point(9,7),
//        }));

//        System.out.println(s.maxPoints(new Point[] {
//                new Point(1,1),
//                new Point(1,1),
//                new Point(2,2),
//                new Point(2,2)
//        }));
//
//        System.out.println(s.maxPoints(new Point[] {
//                new Point(1,1),
//                new Point(1,1),
//                new Point(2,2),
//                new Point(2,2),
//                new Point(3,3),
//                new Point(3,3)
//        }));

        System.out.println(s.maxPoints(new Point[] {
                new Point(6, -17),
                new Point(10, -1),
                new Point(10, -1),
                new Point(-5, -61),
                new Point(5, -21),
                new Point(0, -17)
        }));

    }
}
