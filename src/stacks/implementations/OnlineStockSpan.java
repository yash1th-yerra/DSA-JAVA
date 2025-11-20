package src.stacks.implementations;

import java.util.Stack;

public class OnlineStockSpan {



    static int[] stockSpan(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            int currSpan = 0;
            for(int j=i;j>=0;j--){
                if(arr[j]<=arr[i]) currSpan++;
                else break;
            }
            ans[i]  = currSpan;
        }
        return ans;
    }

    static int[] findPge(int[] arr){
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && arr[stack.peek()]<=arr[i]) stack.pop();
            ans[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return ans;
    }

    static int[] stockSpanOptimal(int[] arr){
        int n =arr.length;
        int[] ans = new int[n];
        int[] PGE = findPge(arr);
        for(int i=0;i<n;i++){
            ans[i] = i-PGE[i];
        }
        return ans;
    }

    static void main() {

        int[] arr = {120, 100, 60, 80, 90, 110, 115};

        int[] ans = stockSpan(arr);
        System.out.print("The span of stock prices is: ");
        for(int i = 0; i < arr.length; i++) {
            System.out.print(ans[i] + " ");
        }

       ans = stockSpanOptimal(arr);
        System.out.print("The span of stock prices is: ");
        for(int i = 0; i < arr.length; i++) {
            System.out.print(ans[i] + " ");
        }

    }
}
