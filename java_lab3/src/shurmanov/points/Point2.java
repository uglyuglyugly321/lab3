package shurmanov.points;

public class Point2 implements Cloneable {
    private final int x;
    private final int y;

    public Point2(int x, int y) {
        this.x = x;
        this.y = y;

    }

    @Override
    public Point2 clone() {
        return new Point2(this.x, this.y);
    }
    @Override
    public String toString() {
        return "(" + x + "," + y + ")";

    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        Point2 other = (Point2) obj;
        return x == other.x && y == other.y;

    }
    @Override
    public int hashCode() {
        return 31  * x + y;
    }

    public static void test() {
        Point2 p1 = new Point2(3, 5);
        Point2 p2 = new Point2(25, 6);
        Point2 p3 = new Point2(7, 8);
        Point2 p4 = new Point2(3, 5);

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

        System.out.println("p1 == p4 : " + (p1 == p4));
        System.out.println("p1 equals p4 : " + p1.equals(p4));

    }
}
