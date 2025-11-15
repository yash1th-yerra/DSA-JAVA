package src.stacks.monotonic;

import java.util.Stack;

public class SumSubarrayRanges {


    static int sumSubarrayRangesBrute(int[] arr){
        int n = arr.length;
        int sum = 0;


        for(int i=0;i<n;i++){
            int smallest = arr[i];
            int largest = arr[i];
            for(int j=i;j<n;j++){
                smallest = Math.min(smallest,arr[j]);
                largest = Math.max(largest,arr[j]);
                sum+=largest-smallest;
            }

        }
        return sum;
    }


    static int[] nse(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]) stack.pop();
            ans[i] = stack.isEmpty()? n : stack.peek();

            stack.push(i);
        }
        return ans;

    }

    static int[] pse(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && arr[stack.peek()]>arr[i]) stack.pop();
            ans[i] = stack.isEmpty()?-1:stack.peek();
            stack.push(i);
        }
        return ans;

    }

    static int[] nge(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && arr[stack.peek()]<=arr[i]) stack.pop();
            ans[i] = stack.isEmpty()? n : stack.peek();

            stack.push(i);
        }
        return ans;
    }

    static int[] pge(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && arr[stack.peek()]<arr[i]) stack.pop();
            ans[i] = stack.isEmpty()?-1:stack.peek();
            stack.push(i);
        }
        return ans;
    }


    static long maxSubarraysSum(int[] arr){
        int n = arr.length;
        int[] pge = pge(arr);
        int[] nge = nge(arr);
        long sum = 0 ;
        for(int i=0;i<n;i++){
            int left = i - pge[i];
            int right = nge[i] - i;
            long freq = ((long) left *right);
            sum += freq*arr[i];
        }
        return sum;

    }

    static long minSubarraysSum(int[] arr){
        int n = arr.length;
        int[] pse = pse(arr);
        int[] nse = nse(arr);
        long sum = 0 ;
        for(int i=0;i<n;i++){
            int left = i - pse[i];
            int right = nse[i] - i;
            long freq = ( (long)left*right);
            sum += freq*arr[i];
        }
        return sum;
    }


    static long sumSubarrayRanges(int[] arr){
        return maxSubarraysSum(arr) - minSubarraysSum(arr);
    }

    static void main() {
        int[] input = {1, 2, 3};
        System.out.println(sumSubarrayRanges(input));
    }
}
