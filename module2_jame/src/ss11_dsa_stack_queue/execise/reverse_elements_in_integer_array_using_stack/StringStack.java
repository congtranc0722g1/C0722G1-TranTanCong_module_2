package ss11_dsa_stack_queue.execise.reverse_elements_in_integer_array_using_stack;

import java.util.Scanner;
import java.util.Stack;

public class StringStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào một chuỗi: ");
        String str = scanner.nextLine();

        Stack<String> stack = new Stack();

        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i) + "");
        }

        for (int i = 0; i < str.length(); i++) {
            System.out.print(stack.pop());
        }
    }
}
