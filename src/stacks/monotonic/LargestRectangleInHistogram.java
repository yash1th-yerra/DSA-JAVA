package src.stacks.monotonic;

import java.util.Stack;

public class LargestRectangleInHistogram {



    static int largestRectangle(int[] arr){
        int maxArea = 0;
        for(int i=0;i<arr.length;i++){
            int minHeight = arr[i];
            for(int j=i;j<arr.length;j++){
                minHeight = Math.min(minHeight,arr[j]);
                maxArea = Math.max(maxArea,minHeight*(j-i+1));

            }
        }
        return maxArea;
    }

    static int largestRectangleOptimal1(int[] arr){
        int maxArea =0;
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int[] leftSmall = new int[n];
        int[] rightSmall = new int[n];
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && arr[stack.peek()]>arr[i]){
                stack.pop();

            }
            leftSmall[i] = stack.isEmpty() ?0:stack.peek()+1;
            stack.push(i);

        }

        while(!stack.isEmpty()) stack.pop();

        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && arr[stack.peek()]>arr[i]) stack.pop();
            rightSmall[i] = stack.isEmpty()?n-1:stack.peek()-1;
            stack.push(i);
        }

        for(int i=0;i<n;i++){
            maxArea = Math.max(maxArea,arr[i]*(rightSmall[i]-leftSmall[i]+1));

        }

        return maxArea;
    }

    static int largestRectangleOptimal2(int[] arr){
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int maxArea =0;
        for(int i=0;i<=n;i++){
            while(!stack.isEmpty() && ( i==n || arr[stack.peek()]>=arr[i])){
                int height = arr[stack.peek()];
                stack.pop();
                int width;
                if(stack.isEmpty()) width = i;
                else  width = i - stack.peek()-1;
                maxArea = Math.max(maxArea,width*height);
            }
            stack.push(i);
        }
        return maxArea;
    }



    static void main() {
        int[] input = {2,1,5,6,2,3};
        System.out.println(largestRectangle(input));
        System.out.println(largestRectangleOptimal1(input));
        System.out.println(largestRectangleOptimal2(input));

    }
}
