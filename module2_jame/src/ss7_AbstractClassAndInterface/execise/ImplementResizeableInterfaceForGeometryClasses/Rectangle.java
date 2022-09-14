package ss7_AbstractClassAndInterface.execise.ImplementResizeableInterfaceForGeometryClasses;

public class Rectangle extends Circle {
    private double width = 1.0;
    private double length = 1.0;

    public Rectangle() {
    }
    public Rectangle(double width, String color, boolean filled){
        super(color, filled);
        this.width = width;

    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle(double width, double length, String color, boolean filled) {
//        super.getColor();
//        super.isFilled();
        super(color,filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getArea() {
        return width * this.length;
    }

    public double getPerimeter() {
        return 2 * (width + this.length);
    }

    @Override
    public String toString() {
        return "Hình chữ nhật\nChiều rộng: "
                + getWidth()
                + "\nChiều dài: "
                + getLength()
                + "\nDiện tích: "
                + getArea()
                + "\nChu vi: "
                + getPerimeter();
    }
}
