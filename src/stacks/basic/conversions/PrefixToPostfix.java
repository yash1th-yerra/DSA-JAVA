package src.stacks.basic.conversions;

import java.util.Stack;

public class PrefixToPostfix {

    static String prefixToPostfix(String exp){
        Stack<String> stack = new Stack<>();
        int n = exp.length();
        for(int i=n-1;i>=0;i--){
            char ch = exp.charAt(i);
            if(Character.isLetterOrDigit(ch)) stack.push(String.valueOf(ch));
            else{
                String op1 = stack.pop();
                String op2 = stack.pop();
                stack.push(op1+op2+ch);
            }
        }
        return stack.peek();
    }

    static void main() {
        String prefix = "*-A/BC-/AKL";
        System.out.println("Postfix Expression: " + prefixToPostfix(prefix));
    }


}
