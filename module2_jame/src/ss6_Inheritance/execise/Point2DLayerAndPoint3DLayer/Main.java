package ss6_Inheritance.execise.Point2DLayerAndPoint3DLayer;

import ss6_Inheritance.execise.PointClassAndMoveablePoint.Point;

public class Main {
    public static void main(String[] args) {
        Point3D point3D1 = new Point3D();
        point3D1 = new Point3D(1, 2, 3);
        Point2D point2D1 = new Point2D(4,5);
        System.out.println(point3D1);
        System.out.println(point2D1);
    }
}
