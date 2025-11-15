package src.stacks.basic.conversions;

import java.util.Stack;

public class PostfixToInfix {


    static String postfixToInfix(String exp){
        Stack<String> stack = new Stack<>();
        for(int i=0;i<exp.length();i++){
            char ch = exp.charAt(i);
            if(Character.isLetterOrDigit(ch)) stack.push(String.valueOf(ch));
            else{
                String op1 = stack.pop();
                String op2 = stack.pop();
                stack.push('('+op2+ch+op1+')');

            }
        }
        return stack.peek();
    }

    static void main() {
        String postfix = "AB*C+";
        System.out.println("Infix Expression: " + postfixToInfix(postfix));
    }
}
