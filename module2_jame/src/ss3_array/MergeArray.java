package ss3_array;

import java.util.Scanner;

public class MergeArray {
    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4};
        int[] arr1 = {5,6,7,8,9};
        int[] arr2 = new int[arr.length + arr1.length];
        for (int i = 0; i < arr.length; i++) {
            arr2[i] = arr[i];
        }
        for (int i = 0; i < arr1.length; i++) {
            arr2[arr.length+i] = arr1[i];
        }
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
    }
}
