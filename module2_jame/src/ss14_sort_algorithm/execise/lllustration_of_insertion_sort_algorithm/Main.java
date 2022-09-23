package ss14_sort_algorithm.execise.lllustration_of_insertion_sort_algorithm;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1,3,2,5,7,4,8,9,6,0,-1,99,1000000,-100909};
        System.out.println(Arrays.toString(insertionSort(arr)));;
    }
    public static int[] insertionSort(int[] arr1){
        for (int i = 1; i < arr1.length; i++) {
            int key = arr1[i];
            int j;
            for (j = i - 1; j >= 0 && arr1[j] > key ; j--) {
                arr1[j+1] = arr1[j];
            }
            arr1[j + 1] = key;
        }
        return arr1;
    }
}
