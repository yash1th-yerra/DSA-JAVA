package src.stacks.monotonic;

import java.util.Stack;

public class MinElemSumOfSubarrays {


    static int sumSubarrayMins(int[] arr){
        int n = arr.length;
        int mod = (int)1e9 + 7;
        int sum  = 0;
        for(int i=0;i<n;i++){
            int mini = arr[i];
            for(int j =i;j<n;j++){
                mini = Math.min(mini,arr[j]);
                sum = (sum+mini)%mod;
            }
        }

        return sum;
    }

    static int[] findNse(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]){
                stack.pop();
            }

            if(!stack.isEmpty()) ans[i] = stack.peek();
            else ans[i] = n;

            stack.push(i);
        }

        return ans;

    }

    static int[] findPse(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]) stack.pop();

            ans[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        return ans;
    }

    static int sumSubarrayMinsOptimal(int[] arr){
        int n = arr.length;
        int mod = (int)1e9+7;
        int sum =0;

        int[] nse = findNse(arr); // get indices not values
        int[] pse = findPse(arr);

        for(int i=0;i<n;i++){
            int left = i-pse[i];
            int right = nse[i]-i;
            long freq = (long) left * right;
            int val = (int)(freq*arr[i])%mod;
            sum = (sum + val)%mod;
        }

        return sum;

    }

    static void main() {
        int[] input = {3,1,2,5};
        System.out.println(sumSubarrayMins(input));
        System.out.println(sumSubarrayMinsOptimal(input));
    }
}
