package ss11_dsa_stack_queue.execise.palindrome_string_using_queue;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập biểu thức: ");
        String str = scanner.nextLine();
        String[] arrStr = str.split("");
        Palindrome palindrome = new Palindrome(arrStr);
        palindrome.checkPalindrome();
    }
}
