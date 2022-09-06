package ss2_loop.exercise;

import java.util.Scanner;

public class DisplayGeometry {
    public static void main(String[] args) {
        // In hình chữ nhật
        int width = 10;
        int height = 3;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print('*');
            }
            System.out.print("\n");
        }
        System.out.print("\n");
        System.out.print("\n");

        // In hình tam giác vuông, có cạnh góc vuông ở botton-left
        int height1 = 5;
        for (int i = 1; i <= height1; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print('*');
            }
            System.out.print("\n");
        }
        System.out.print("\n");
        System.out.print("\n");

        // In hình tam giác vuông, có cạnh góc vuông ở top-left
        int height2 = 5;
        for (int i = 1; i <= height2; i++) {
            for (int j = 1; j <= height2 - i + 1; j++) {
                System.out.print('*');
            }
            System.out.print("\n");

        }
        System.out.print("\n");
        System.out.print("\n");

        // In hình tam giác cân
        int height3 = 6;
        for (int i = 1; i <= height3; i++) {
            for (int j = 1; j <= height3 - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print('*');

            }
            for (int j = 1; j <= height3 - i; j++) {
                System.out.print(" ");
            }
            System.out.print("\n");
            }
        }
    }
