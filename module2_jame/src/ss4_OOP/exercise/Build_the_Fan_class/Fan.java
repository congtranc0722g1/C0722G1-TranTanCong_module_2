package ss4_OOP.exercise.Build_the_Fan_class;

public class Fan {
    final int SLOW = 1;
    final int MEDIUM = 2;
    final int FAST = 3;
    int speed = SLOW;
    boolean status = false;
    double radius = 5;
    String color = "blue";
    public Fan(){

    }
    public Fan(int speed, boolean status, double radius,String color){
        this.speed = speed;
        this.status = status;
        this.radius = radius;
        this.color = color;
    }
    public int getSpeed() {

        return this.speed;
    }
    public boolean getStatus() {
        return this.status;
    }
    public double getRadius() {
        return this.radius;
    }
    public String getColor() {
        return this.color;
    }
}
