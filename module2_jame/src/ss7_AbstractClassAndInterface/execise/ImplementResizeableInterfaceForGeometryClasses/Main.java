package ss7_AbstractClassAndInterface.execise.ImplementResizeableInterfaceForGeometryClasses;

public class Main {
    public static void main(String[] args) {
        Resizeable[] resizeables = new Resizeable[3];
        resizeables[0] = new Circle(4,"blue", true);
        resizeables[1] = new Rectangle(5,4,"red",false);
        resizeables[2] = new Square(5, "black",true);
        System.out.println("Trước khi thay đổi:");
//        System.out.println(resizeables[0]);
//        System.out.println(resizeables[1]);
//        System.out.println(resizeables[2]);
        for (Resizeable resizeable : resizeables) {
            System.out.println(resizeable);
        }
        System.out.println("Sau khi thay đổi:");
        resizeables[0].resize(25);
        System.out.println(resizeables[0]);
        resizeables[1].resize(20);
        System.out.println(resizeables[1]);
        resizeables[2].resize(15);
        System.out.println(resizeables[2]);
    }
}
