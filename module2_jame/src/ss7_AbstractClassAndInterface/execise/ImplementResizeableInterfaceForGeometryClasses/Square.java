package ss7_AbstractClassAndInterface.execise.ImplementResizeableInterfaceForGeometryClasses;

public class Square extends Rectangle {
    private double with;
    public Square() {

    }

    public Square(double width, String color, boolean filled) {
        super(width, color, filled);
    }

    public double getArea() {

        return getWidth() * getWidth();
    }

    public double getPerimeter() {
        return 4 * getWidth();
    }

    @Override
    public String toString() {
        return "Hình vuông\nChiều rộng: "
                + getWidth()
                + "\nDiện tích: "
                + getArea()
                + "\nChu vi: "
                + getPerimeter();
    }
}
