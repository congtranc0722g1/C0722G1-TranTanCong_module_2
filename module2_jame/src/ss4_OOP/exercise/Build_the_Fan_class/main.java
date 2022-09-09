package ss4_OOP.exercise.Build_the_Fan_class;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Fan fan1 = new Fan(2, true, 10, "red");
        System.out.print("Trạng thái: " + fan1.getStatus() + "\nTốc độ: " + fan1.getSpeed() + "\nBán kính : " + fan1.getRadius() + "\nMàu sắc: " + fan1.getColor());
    }
}
