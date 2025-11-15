package src.stacks.basic.conversions;

import java.util.Stack;

public class PostfixToPrefix {



    static String postFixToPrefix(String exp){
        int n = exp.length();
        if(n==0 ) return "";
        Stack<String> stack = new Stack<>();
        for(int i=0;i<n;i++){
            char ch = exp.charAt(i);
            if(Character.isLetterOrDigit(ch)) stack.push(String.valueOf(ch));
            else{
                String op1 = stack.pop();
                String op2 = stack.pop();
                stack.push(ch+op2+op1);
            }
        }
        return stack.peek();
    }
    static void main() {
        String prefix = "ABC/-AK/L-*";
        System.out.println("Postfix Expression: " + postFixToPrefix(prefix));
    }
}
