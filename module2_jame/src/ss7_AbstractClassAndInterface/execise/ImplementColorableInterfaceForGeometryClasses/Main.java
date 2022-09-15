package ss7_AbstractClassAndInterface.execise.ImplementColorableInterfaceForGeometryClasses;

public class Main {
    public static void main(String[] args) {
        Colorable[] colorables = new Colorable[2];
        colorables[0] = new Square(5, "black",true);
        colorables[1] = new Square(10, "red", false);
        for (Colorable colorable : colorables) {
            System.out.println(colorable);
            if (colorable instanceof Square) {
                System.out.println(colorable.howToColor());
            }
        }
    }
}
