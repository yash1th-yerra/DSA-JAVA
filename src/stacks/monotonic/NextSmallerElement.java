package src.stacks.monotonic;

import java.util.Arrays;
import java.util.Stack;

public class NextSmallerElement {


    static int[] nextSmallerElementBrute(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        Arrays.fill(ans,-1);
        for(int i=0;i<n;i++){
            int currElement = arr[i];
            for(int j=i+1;j<n;j++){
                if(arr[j]<currElement){
                    ans[i] = arr[j];
                    break;
                }
            }
        }
        return ans;
    }

    static int[] nextSmallerElementOptimal(int[] arr){
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];
        Arrays.fill(ans,-1);
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek()>=arr[i]){
                stack.pop();
            }
            if(!stack.isEmpty()) ans[i] = stack.peek();

            stack.push(arr[i]);
        }

        return ans;


    }
    static void main() {
        int[] arr = {1, 3, 2, 4};
        int[] ans = nextSmallerElementOptimal(arr);

        // Print result
        System.out.print("The next smaller elements are: ");
        for (int val : ans) {
            System.out.print(val + " ");
        }
    }
}
