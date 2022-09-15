package ss7_AbstractClassAndInterface.execise.ImplementResizeableInterfaceForGeometryClasses;

public class Square extends Geometry implements Resizeable {
    private double width;
    public Square() {

    }

    public Square(double width, String color, boolean filled) {
        super(color, filled);
        this.width = width;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getArea() {

        return getWidth() * getWidth();
    }

    public double getPerimeter() {
        return 4 * getWidth();
    }

    @Override
    public String toString() {
        return "Hình vuông" +
                "\nMàu sắc: " + getColor() +
                "\nChiều rộng: " + getWidth() +
                "\nDiện tích: " +getArea();
    }

    @Override
    public void resize(double percent) {
        setWidth(getWidth() + getWidth() * percent / 100);
    }
}
