package ss14_sort_algorithm.execise.install_insertion_sort_algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        do {
            System.out.print("Nhập số phần tử trong mảng: ");
            n = Integer.parseInt(sc.nextLine());
            if(n < 0){
                System.out.print("Bạn phải nhập số nguên dương, Nhập lại");
            }
        }while (n < 0);
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Nhập vào arr[]" + i + " ");
            arr[i] = Integer.parseInt(sc.nextLine());
        }
        insertionSort(arr);
    }
    public static void insertionSort(int[] list){
        for (int i = 0; i < list.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < list.length; j++) {
                if(list[j] < list[minIndex]){
                    minIndex = j;
                }
            }
            if (minIndex != i){
                int temp = list[minIndex];
                list[minIndex] = list[i];
                list[i] = temp;

            }
        }
        System.out.println(Arrays.toString(list));
    }
}
