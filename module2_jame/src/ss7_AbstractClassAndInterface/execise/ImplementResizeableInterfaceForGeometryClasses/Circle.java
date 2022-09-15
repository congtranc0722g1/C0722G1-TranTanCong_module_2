package ss7_AbstractClassAndInterface.execise.ImplementResizeableInterfaceForGeometryClasses;

public class Circle extends Geometry implements Resizeable {
    private double radius = 1.0;
    public Circle() {
    }


    public Circle(double radius, String color, boolean filled) {
        super(color,filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }

    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }
    @Override
    public String toString() {
        return "Hình tròn" +
                "\nMàu sắc: " + getColor() +
                "\nBán kính: " + getRadius() +
                "\nDiện tích: " +getArea();
    }


    @Override
    public void resize(double percent) {
        setRadius(getRadius() + getRadius() * percent / 100);
    }
}
