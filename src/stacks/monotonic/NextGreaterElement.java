package src.stacks.monotonic;

import java.util.Stack;

public class NextGreaterElement {

    // Input : [1,3,2,4]    -> Output : [3,4,4,-1]
    static int[] nextGreaterElement(int[] arr){
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int[] res = new int[n];
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek()<=arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()) res[i]=-1;
            else res[i] = stack.peek();

            stack.push(arr[i]);
        }
        return res;
    }

    static void main() {
        int[] input = {1,3,2,4};
        int[] output = nextGreaterElement(input);
        for(int i:output) System.out.print(i+" ");
    }
}
