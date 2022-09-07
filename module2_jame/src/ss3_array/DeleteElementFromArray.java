package ss3_array;

import java.util.Scanner;

public class DeleteElementFromArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        int delete;
        Scanner scanner = new Scanner(System.in);
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
