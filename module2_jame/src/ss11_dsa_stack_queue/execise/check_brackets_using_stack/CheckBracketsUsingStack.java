package ss11_dsa_stack_queue.execise.check_brackets_using_stack;

import java.util.Stack;

public class CheckBracketsUsingStack {
    String[] arr1;
    public CheckBracketsUsingStack(String[] arr1){
        this.arr1 = arr1;
    }

    public String[] getArr1() {
        return arr1;
    }

    public void setArr1(String[] arr1) {
        this.arr1 = arr1;
    }

    public boolean checkBrackets(){
        Stack<String> bStack = new Stack<>();
        for (int i = 0; i < getArr1().length; i++) {
            if(getArr1()[i].equals("(")){
                bStack.push(getArr1()[i]);
            } else if(getArr1()[i].equals(")")){
                if(bStack.isEmpty()){
                    return false;
                } else {
                    bStack.pop();
                }
            }

        }
        if(bStack.isEmpty()) {
            return true;
        }
        else {
            return false;
        }
    }
}
