package ss11_dsa_stack_queue.execise.palindrome_string_using_queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Palindrome {
    String[] arr;

    public Palindrome(String[] arr) {
        this.arr = arr;
    }

    public String[] getArr() {
        return arr;
    }

    public void setArr(String[] arr) {
        this.arr = arr;
    }

    public void checkPalindrome() {
        Stack<String> stack = new Stack<>();
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < getArr().length; i++) {
            stack.push(getArr()[i]);
            queue.add(getArr()[i]);
        }
        boolean check = false;
        for (int i = 0; i < getArr().length; i++) {
            if(stack.pop().equals(queue.poll())){
                check = true;
            }
            else {
                check =false;
            }
        }
        if (check){
            System.out.print("Đây là chuỗi Palindrome");
        } else {
            System.out.print("Đây không phải chuỗi Palindrome");
        }
    }
}
