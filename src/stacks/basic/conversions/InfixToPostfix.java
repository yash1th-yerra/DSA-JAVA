package src.stacks.basic.conversions;

import java.util.Stack;

public class InfixToPostfix {

    static int getPriority(char ch){
        if(ch=='+' || ch=='-') return 1;
        if(ch=='*' || ch=='/') return 2;
        if(ch=='^') return 3;
        return -1;
    }

    static String infixToPostfix(String infix){
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        for(int i=0;i<infix.length();i++){
            char ch = infix.charAt(i);
            if(Character.isLetterOrDigit(ch)) result.append(ch);
            else if(ch=='(') stack.push(ch);
            else if(ch==')'){
                while(!stack.isEmpty() && stack.peek()!='('){
                    result.append(stack.pop());


                }
                stack.pop();
            }
            else{
                while(!stack.isEmpty() && getPriority(ch)<=getPriority(stack.peek())) result.append(ch);
                stack.push(ch);
            }
        }
        while(!stack.isEmpty()){
            if(stack.peek()=='(') return"Invalid Expression";
            result.append(stack.pop());
        }
        return result.toString();
    }

    static void main() {

    }
}
