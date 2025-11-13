package src.stacks.basic;

import java.util.Stack;

public class BalancedParanthesis {

    static boolean isValid(String s){
        Stack<Character> st = new Stack<>();
        for(char it:s.toCharArray()){
            if(it=='(' || it=='{' || it=='[') st.push(it);
            else{
                if(st.isEmpty()) return false;
                char ch = st.pop();
                if((it==')' && ch=='(') || (it=='}' && ch=='{') || (it==']' && ch=='[')) continue;
                else return false;
            }
        }
        return true;
    }
    static void main() {
        String s = "()[{}()]";
        if(isValid(s)) System.out.println("balanced");
        else System.out.println("imbalanced");
    }
}
