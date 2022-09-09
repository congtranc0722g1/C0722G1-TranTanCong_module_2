package ss4_OOP.exercise.BuildLayerStopWatch;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        long start1 = 0;
        long start2 = 0;
        StopWatch stopWatch1 = new StopWatch (start1, start2);
        stopWatch1.start();
        for (int i = 1; i < 100000000; i++) {
            System.out.print("");
        }
        stopWatch1.stop();
        System.out.print(stopWatch1.getElapsedTime());
    }
}
