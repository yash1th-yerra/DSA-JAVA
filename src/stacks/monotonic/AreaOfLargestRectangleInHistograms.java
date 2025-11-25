package src.stacks.monotonic;

import java.util.Stack;

public class AreaOfLargestRectangleInHistograms {


    static int largestArea(int[] arr,int n){
        int maxArea =0;
        for(int i=0;i<n;i++){
            int minHeight = Integer.MAX_VALUE;
            for(int j =i;j<n;j++){
                minHeight = Math.min(minHeight,arr[j]);
                maxArea = Math.max(maxArea,minHeight*(j-i+1));
            }
        }
        return maxArea;
    }

    static int largestAreaOptimal1(int[] arr,int n){
        Stack<Integer> stack = new Stack<>();
        int[] leftSmall = new int[n];
        int[] rightSmall = new int[n];
        for(int i =0;i<n;i++){
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]) stack.pop();
            leftSmall[i] = stack.isEmpty()?0:stack.peek()+1;
            stack.push(i);
        }

        while(!stack.isEmpty()) stack.pop();

        for(int i= n-1;i>=0;i--){
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i])stack.pop();
            rightSmall[i] = stack.isEmpty()?n-1:stack.peek()-1;
            stack.push(i);
        }

        int maxA = 0;
        for(int i=0;i<n;i++){
            maxA = Math.max(maxA,arr[i]*(rightSmall[i]-leftSmall[i]+1));
        }
        return maxA;
    }

    static int largestAreaOptimal2(int[] arr,int n){
        Stack<Integer> stack = new Stack<>();
        int maxA = 0;
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && (i==n || arr[stack.peek()]>=arr[i])) {
                int height = arr[stack.peek()];
                stack.pop();
                int width;
                if(stack.isEmpty()) width = i;
                else width = i-stack.peek()-1;
                maxA  = Math.max(maxA,width*height);
            }
            stack.push(i);
        }
        return maxA;
    }

    static void main() {
        int[] arr = {2,1,5,6,2,3,1};
        int n = 7;
        System.out.println("Largest area of rectangle in histogram is: "+largestArea(arr,n));
        System.out.println("Largest area of rectangle in histogram is: "+largestAreaOptimal1(arr,n));
        System.out.println("Largest area of rectangle in histogram is: "+largestAreaOptimal2(arr,n));
    }
}
