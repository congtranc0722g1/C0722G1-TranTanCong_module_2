package ss3_array;

public class FindTheLargestElementInATwoDimensionalArray {
    public static void main(String[] args) {
        int[][] arr = {{5,6,7,8,9}, {0,1,100,3,4}};
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