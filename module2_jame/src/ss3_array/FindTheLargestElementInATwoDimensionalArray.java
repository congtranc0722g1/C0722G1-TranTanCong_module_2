package ss3_array;

import java.util.Scanner;

public class FindTheLargestElementInATwoDimensionalArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        do {
            System.out.print("Nhập số hàng: ");
            n = Integer.parseInt(scanner.nextLine());
            if(n < 0){
                System.out.print("Bạn phải nhập số nguên dương, Nhập lại");
            }
        }while (n < 0);
        int m;
        do {
            System.out.print("Nhập số cột: ");
            m = Integer.parseInt(scanner.nextLine());
            if(m < 0){
                System.out.print("Bạn phải nhập số nguên dương, Nhập lại");
            }
        }while (m < 0);
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print("Nhập vào arr[]" + i + j + " :  ");
                arr[i][j] = Integer.parseInt(scanner.nextLine());
            }
        }
        int max = arr[0][0];
        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr[i].length; j++) {
                if (arr[i][j] >= max){
                    max = arr[i][j];
                    index1 = i;
                    index2 = j;
                }
            }
        }
        System.out.print("Số lớn nhất là: " + max + " .Tại vị trí: " + index1 + "," + index2);
    }
}