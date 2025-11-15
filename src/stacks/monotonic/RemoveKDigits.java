package src.stacks.monotonic;

import java.util.Stack;

public class RemoveKDigits {

    static String removeKdigits(String nums,int k){
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<nums.length();i++){
            char digit = nums.charAt(i);
            while(!stack.isEmpty() && k>0 && stack.peek()>digit){
                stack.pop();
                k--;
            }
            stack.push(digit);
        }

        while(k>0 ){
            stack.pop();
            k--;
        }
        if(stack.isEmpty()) return "0";

        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()){
            res.append(stack.pop());
        }

        while(!res.isEmpty() && res.charAt(res.length()-1)=='0'){
            res.deleteCharAt(res.length()-1);
        }

        res.reverse();

        if(res.isEmpty()) return "0";
        return res.toString();
    }

    static void main() {
        String nums = "541892"; // Input number as string
        int k = 2; // Number of digits to remove



        // Call the function to find the smallest number after removing k digits
        String ans = removeKdigits(nums, k);

        // Print the result
        System.out.println("The smallest possible integer after removing k digits is: " + ans);
    }
}
