package ss11_dsa_stack_queue.execise.convert_from_decimal_to_binary;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        int num1 = 11;
        DecimalToBinaryExample decimalToBinaryExample = new DecimalToBinaryExample(num1);
        decimalToBinaryExample.convertBinary();
    }
}
