package src.stacks.monotonic;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementCircular {

    static int[] nextGreaterElementBrute(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        Arrays.fill(ans,-1);
        for(int i =0;i<n;i++){
            int currElement = arr[i];
            for(int j=1;j<n;j++){
                int ind = (i+j)%n;
                if(arr[ind]>currElement){
                    ans[i] = arr[ind];
                    break;
                }
            }
        }
        return ans;
    }


    static int[] nextGreaterElementOptimal(int[] arr){
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=2*n-1;i>=0;i--){
            int ind = i%n;
            int currEle = arr[ind];
            while(!stack.isEmpty() && stack.peek()<=currEle) stack.pop();
            if(i<n){
                if(stack.isEmpty()) res[ind]=-1;
                else res[ind] = stack.peek();
            }
            stack.push(currEle);
        }
        return res;
    }
    static void main() {
        int[] input = {3, 10, 4, 2, 1, 2, 6, 1, 7, 2, 9};
        int[] output = nextGreaterElementOptimal(input);
        for(int i: output) System.out.print(i+" ");

    }
}
