package ss3_array;

import java.util.Scanner;

public class FindMinimumValueInArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        do {
            System.out.print("Nhập số phần tử trong mảng: ");
            n = Integer.parseInt(scanner.nextLine());
            if(n < 0){
                System.out.print("Bạn phải nhập số nguên dương, Nhập lại");
            }
        }while (n < 0);
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Nhập vào arr[]" + i + " ");
            arr[i] = Integer.parseInt(scanner.nextLine());
        }
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(min >= arr[i]){
                min = arr[i];
            }
        }
        System.out.print("Số bé nhất là: " + min);
    }
}
