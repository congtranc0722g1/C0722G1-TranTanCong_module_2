package ss7_AbstractClassAndInterface.execise.ImplementResizeableInterfaceForGeometryClasses;

public class Circle {
    private double radius = 1.0;
    private String color = "green";
    private boolean filled = true;
    public Circle() {
    }
    public Circle( String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }


    public Circle(double radius, String color, boolean filled) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }
    public void resize(double percent){
        setRadius(getRadius() * percent / 100);
    }

    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    @Override
    public String toString() {
        return "Hình tròn\nBán kính: "
                + getRadius()
                + "\nMàu sắc: "
                + getColor()
                + "\nĐầy: "
                + isFilled()
                + "\nDiện tích: "
                + getArea()
                + "\nChu vi: "
                + getPerimeter()
                ;
    }
}
