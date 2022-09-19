package ss11_dsa_stack_queue.execise.reverse_elements_in_integer_array_using_stack;

import java.util.Scanner;
import java.util.Stack;

public class IntegerStack {
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

        Stack<Integer> stack= new Stack<>();

        for (int value : arr) {
            stack.push(value);
        }
        
        System.out.println("mảng đảo ngược");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(stack.pop() + "\t");
            
        }
    }
}
