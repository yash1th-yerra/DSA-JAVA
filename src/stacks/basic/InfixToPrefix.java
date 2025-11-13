package src.stacks.basic;

import java.util.Stack;

public class InfixToPrefix {
    private static boolean isAlpha(char c){
        if(c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') return true;
        return false;

    }

    private static boolean isDigit(char c){
        if (c >= '0' && c <= '9') {
            return true;
        }
        return false;

    }
    private static boolean isOperator(char c)
    {
        return (!isAlpha(c) && !isDigit(c));
    }
    private static int getPriority(char C)
    {
        if (C == '-' || C == '+')
            return 1;
        else if (C == '*' || C == '/')
            return 2;
        else if (C == '^')
            return 3;

        return 0;
    }
    private static String infixToPostfix(String infix){
        int n = infix.length();
        Stack<Character> s = new Stack<>();
        String output="";
        for(int i=0;i<n;i++){
            if(isAlpha(infix.charAt(i))||isDigit(infix.charAt(i)))
                output+=infix.charAt(i);
            else if(infix.charAt(i)=='(') s.add('(');
            else if(infix.charAt(i)==')'){
                while(!s.isEmpty()&&s.peek()!='('){
                    output+=s.pop();
                }
                s.pop();
            }
            else{
                if(infix.charAt(i)=='^'){
                    while(!s.isEmpty() && getPriority(infix.charAt(i))<=getPriority(s.peek())) output+=s.pop();
                }
                else{
                    while(!s.isEmpty() && getPriority(infix.charAt(i))<getPriority(s.peek())) output+=s.pop();
                }
                s.push(infix.charAt(i));
            }
        }

        while(!s.isEmpty()){
            output+=s.pop();
        }
        return output;

    }


    private static String reverse(char[] arr,int start,int end){
        char temp;
        while(start<end){
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return String.valueOf(arr);

    }
    public static String infixToPrefix(char[] infix){
        int n = infix.length;
        String infix1 = reverse(infix,0,n-1);
        infix = infix1.toCharArray();
        for(int i=0;i<n;i++){
            if(infix[i]=='('){
                infix[i] = ')';
                i++;
            }
            else if(infix[i]==')'){
                infix[i] = '(';
                i++;
            }
        }
        String prefix = infixToPostfix(String.valueOf(infix));
        prefix = reverse(prefix.toCharArray(),0,n-1);
        return prefix;
    }

    public static void main(String[] args) {
        String s = ("x+y*z/w+u");

        // Function call
        System.out.print(infixToPrefix(s.toCharArray()));
     }
}
