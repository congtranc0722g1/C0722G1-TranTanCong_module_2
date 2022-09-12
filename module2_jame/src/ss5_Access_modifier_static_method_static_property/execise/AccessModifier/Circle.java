package ss5_Access_modifier_static_method_static_property.execise.AccessModifier;

public class Circle {
    private double radius = 1.0;
    private String color = "red";
    public  Circle(){

    }
    public Circle(double radius, String color){
        this.radius = radius;
        this.color = color;
    }
    public double getRadius(){
        return radius;
    }
    public void setRadius(double radius){
        this.radius = radius;
    }
    public double getArea(){
        double aRea = Math.pow(getRadius(), 2) * Math.PI;
        return  aRea;
    }
    @Override
    public String toString(){
        return "Diện tích: " + getArea();
    }
}
