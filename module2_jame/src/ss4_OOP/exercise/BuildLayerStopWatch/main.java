package ss4_OOP.exercise.BuildLayerStopWatch;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        StopWatch stopWatch1 = new StopWatch ();
        stopWatch1.start();
        for (int i = 1; i < 1000000; i++) {
            System.out.print("");
        }
        stopWatch1.stop();
        System.out.print(stopWatch1.getElapsedTime());
    }
}
