package shurmanov.points;

public class Point {
    private double x;
    private double y;
    private double z;

    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString() {
        return "{" + x + " ; " + y + " ; " + z + "}";
    }

    public static void test() {
        Point p1  = new Point(1, 2, 3);
        Point p2 = new Point(-1, 0, 5);
        Point p3 = new Point(0, 0, 0);

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

    }
}
