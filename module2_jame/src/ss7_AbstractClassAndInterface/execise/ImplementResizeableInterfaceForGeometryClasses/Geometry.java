package ss7_AbstractClassAndInterface.execise.ImplementResizeableInterfaceForGeometryClasses;

public abstract class Geometry implements Resizeable {
    private String color = "green";
    private boolean filled = true;
    public Geometry(){

    }
    public Geometry(String color, boolean filled){
        this.color = color;
        this.filled = filled;
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

    @Override
    public void resize(double percent) {

    }
}
