package ss11_dsa_stack_queue.execise.convert_from_decimal_to_binary;

import java.util.Stack;

public class DecimalToBinaryExample {
    int num;
    public DecimalToBinaryExample(int num) {
        this.num = num;
    }

    public void convertBinary (){
        Stack<Integer> stack= new Stack<>();
        while (this.num != 0){
            int n = this.num % 2;
            stack.push(n);
            this.num /= 2;
        }
        System.out.print("\n");
        while(!(stack.isEmpty())){

            System.out.print(stack.pop());

        }
    }
}

