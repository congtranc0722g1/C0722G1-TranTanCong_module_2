package ss3_array;

import java.util.Scanner;

public class AddElementToArray {
    public static void main(String[] args) {
        int[] arr = {10,4,6,7,8,0,0,0,0};
        int add;
        int location;
        int[] arr1 = new int[arr.length];
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào vị trí cần chèn: ");
        location = scanner.nextInt();
        System.out.print("Nhập vào phần tử cần thêm: ");
        add = scanner.nextInt();
        for (int i = 0; i < arr.length; i++) {
            if(i == location){
                for (int j = 0; j < location; j++) {
                    arr1[j] = arr[j];
                }
                arr1[location] = add;
                for (int j = location + 1; j < arr.length; j++) {
                    arr1[j] = arr[j - 1];
                }
            }
        }
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }
    }
}
