package src.stacks.basic.conversions;

import java.util.Stack;

public class PrefixToInfix {


    static String prefixToInfix(String exp){
        StringBuilder res = new StringBuilder();
        Stack<String> stack = new Stack<>();
        for(int i=exp.length()-1;i>=0;i--){
            char ch = exp.charAt(i);
            if(Character.isLetterOrDigit(ch)) stack.push(String.valueOf(ch));
            else{
                String op1 = stack.pop();
                String op2 = stack.pop();
                stack.push('('+op1+ch+op2+')');

            }

        }
        return stack.peek();
    }

    static void main() {


        String prefix = "*-A/BC-/AKL";
        System.out.println("Infix Expression: " + prefixToInfix(prefix));

    }
}
