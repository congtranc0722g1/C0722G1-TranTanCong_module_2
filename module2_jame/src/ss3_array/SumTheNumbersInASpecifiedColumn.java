package ss3_array;

import java.util.Scanner;

public class SumTheNumbersInASpecifiedColumn {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        do {
            System.out.print("Nhập số cột: ");
            n = Integer.parseInt(scanner.nextLine());
            if(n < 0){
                System.out.print("Bạn phải nhập số nguên dương, Nhập lại");
            }
        }while (n < 0);
        int m;
        do {
            System.out.print("Nhập số hàng: ");
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
        int location;
        System.out.print("Nhập vào vị trí cột cần tính tổng: ");
        location = scanner.nextInt();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == location){
                for (int j = 0; j < arr[location].length; j++) {
                    sum += arr[location][j];
                }
            }
        }
        System.out.print("Kết quả là: " + sum);
    }
}
