package ss4_OOP.exercise.Build_the_Fan_class;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Fan fan1 = new Fan();
        fan1.setStatus(true);
        fan1.setSpeed(fan1.FAST);
        fan1.setRadius(10);
        fan1.setColor("red");
        System.out.print(fan1);
    }
}
