package ss11_dsa_stack_queue.execise.convert_from_decimal_to_binary;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1;
        System.out.print("Nhập vào một số: ");
        num1 = scanner.nextInt();
        DecimalToBinaryExample decimalToBinaryExample = new DecimalToBinaryExample(num1);
        decimalToBinaryExample.convertBinary();
    }
}
