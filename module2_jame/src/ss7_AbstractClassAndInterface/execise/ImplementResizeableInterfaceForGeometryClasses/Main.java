package ss7_AbstractClassAndInterface.execise.ImplementResizeableInterfaceForGeometryClasses;

public class Main {
    public static void main(String[] args) {
        Circle[] circles = new Circle[3];
        circles[0] = new Circle(4,"blue", true);
        circles[1] = new Rectangle(5,4,"red",false);
        circles[2] = new Square(5, "black",true);
    }
}
