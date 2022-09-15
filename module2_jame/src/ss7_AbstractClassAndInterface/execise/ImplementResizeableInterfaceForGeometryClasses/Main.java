package ss7_AbstractClassAndInterface.execise.ImplementResizeableInterfaceForGeometryClasses;

public class Main {
    public static void main(String[] args) {
        Resizeable[] resizeable = new Resizeable[3];
        resizeable[0] = new Circle(4,"blue", true);
        resizeable[1] = new Rectangle(5,4,"red",false);
        resizeable[2] = new Square(5,"pink", true);
        System.out.println("Trước khi thay đổi:");

        for (Resizeable resizable : resizeable) {
            System.out.println(resizable);
        }
        System.out.println("Sau khi thay đổi:");
//        resizeable[0].resize(25);
//        System.out.println(resizeable[0]);
//        resizeable[1].resize(20);
//        System.out.println(resizeable[1]);
//        resizeable[2].resize(15);
//        System.out.println(resizeable[2]);
        for (Resizeable resizable : resizeable){
            double randomDouble = Math.random();
            randomDouble = randomDouble * 100 + 1;
            resizable.resize(randomDouble);
            System.out.println(resizable + "\nTỉ lệ thay đổi: " + randomDouble + "%");
        }
    }
}
