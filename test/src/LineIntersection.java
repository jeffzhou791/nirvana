import util.Point;
import util.PointPair;

/**
 * Created by Jeff on 1/17/15.
 */
public class LineIntersection {
    public static void main(String[] args) {
        LineIntersection sect = new LineIntersection();
        System.out.println(sect.intersect(1,0,1,2,0,1,0,2));
        System.out.println(sect.intersect(-1,0,1,0,0,1,0,2));
        System.out.println(sect.intersect(-1,0,1,0,0,0,0,2));
    }
    public boolean intersect(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        Point p1 = new Point(x1, y1);
        Point p2 = new Point(x2, y2);
        Point p3 = new Point(x3, y3);
        Point p4 = new Point(x4, y4);
        PointPair pair1 = new PointPair(p1, p2);
        PointPair pair2 = new PointPair(p3, p4);
        return intersect(pair1, pair2);
    }
    public boolean intersect(PointPair pair1, PointPair pair2) {
        int product1 = product(pair2.p2, pair1.p2, pair1.p1);
        int product2 = product(pair1.p1, pair1.p2, pair2.p1);
        int product3 = product(pair1.p1, pair2.p2, pair2.p1);
        int product4 = product(pair2.p1, pair2.p2, pair1.p2);
        if (product1 * product2 > 0 && product3 * product4 > 0) {
            return true;
        }
        if (product1 == 0) {
            return onSegment(pair1, pair2.p2);
        }
        if (product2 == 0) {
            return onSegment(pair1, pair2.p1);
        }
        if (product3 == 0) {
            return onSegment(pair2, pair1.p1);
        }
        if (product4 == 0) {
            return onSegment(pair2, pair1.p2);
        }
        return false;
    }

    private int product(Point start, Point pivot, Point end) {
        return (end.x - pivot.x) * (start.y - pivot.y) - (start.x - pivot.x) * (end.y - pivot.y);
    }

    private boolean onSegment(PointPair pair, Point p) {
        Point a = pair.p1;
        Point b = pair.p2;
        return p.x >= min(a.x, b.x) && p.x <= max(a.x, b.x) &&
                p.y >= min(a.y, b.y) && p.y <= max(a.y, b.y);
    }

    private int min(int x, int y) {
        return x > y ? y : x;
    }

    private int max(int x, int y) {
        return x > y ? x : y;
    }
}
