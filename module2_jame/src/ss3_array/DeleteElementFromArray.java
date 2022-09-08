package ss3_array;

import java.util.Scanner;

public class DeleteElementFromArray {
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
        int delete;
        System.out.print("Nhập vào phần tử cần xóa: ");
        delete = scanner.nextInt();
        int location = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == delete){
                location = i;
            }
        }
        int[] arr1 = new int[arr.length];
        for (int i = 0; i < location; i++) {
            arr1[i] = arr[i];
        }
        for (int i = location + 1; i < arr.length; i++) {
            arr1[i - 1] = arr[i];
        }
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }
    }
}
