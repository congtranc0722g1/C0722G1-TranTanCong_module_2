package ss7_AbstractClassAndInterface.execise.ImplementColorableInterfaceForGeometryClasses;

import ss7_AbstractClassAndInterface.execise.ImplementResizeableInterfaceForGeometryClasses.Rectangle;

public class Square implements Colorable {
    private double width;
    private String color;
    private boolean filled;
    public Square(){

    }
    public Square(double width, String color, boolean filled){
        this.width = width;
        this.color = color;
        this.filled = filled;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
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

        return getWidth() * getWidth();
    }
    public void howToColor(){
    }

    @Override
    public String toString() {
        return "Hình vuông" +
                "\nChiều rộng: " + getWidth() +
                "\nMàu sắc: " +getColor();
    }
}
