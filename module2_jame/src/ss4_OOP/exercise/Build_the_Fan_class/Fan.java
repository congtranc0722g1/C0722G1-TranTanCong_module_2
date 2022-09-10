package ss4_OOP.exercise.Build_the_Fan_class;

public class Fan {
    final int SLOW = 1;
    final int MEDIUM = 2;
    final int FAST = 3;
    int speed = SLOW;
    boolean status = false;
    double radius = 5;
    String color = "blue";

    public Fan() {

    }

    public int getSpeed() {

        return speed;
    }

    public void setSpeed(int speed) {

        this.speed = speed;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString() {
        if (this.status) {
            return "Quạt đang bật\nTốc độ: " + this.speed + "\nBán kính : " + this.radius + "\nMàu sắc: " + this.color;
        }else {
            return "Quạt đang tắt\nBán kính: "+ this.radius + "\nMàu sắc: " + this.color ;
        }
    }
}
