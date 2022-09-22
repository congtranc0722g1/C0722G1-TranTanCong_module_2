package ss13_search_algorithm.execise.implement_binary_search_algorithm_using_recursion;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
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
        System.out.println("Nhập vào số cần tìm");
        int m = Integer.parseInt(scanner.nextLine());
        int left = 0;
        int right = arr.length - 1;
        System.out.println(binarySearch(arr, m, left, right));;

    }
    static int binarySearch(int[] array,int m, int left, int right){
        if(right >= left){
            int mid = (left + right) / 2;
            if (array[mid] == m){
                return mid;
            }
            if(m < array[mid]){
                return binarySearch(array, m, left, mid- 1);
            }
            return binarySearch(array, m, mid + 1, right);

        }
        return -1;
    }
}
