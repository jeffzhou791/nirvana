package util;

/**
 * Created by Jeff on 1/20/15.
 */
public class Point {
    public int x;
    public int y;
    public Point() {
        x = 0;
        y = 0;
    }

    public Point(int a, int b) {
        x = a;
        y = b;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
