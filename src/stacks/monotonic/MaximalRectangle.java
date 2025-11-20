package src.stacks.monotonic;

import java.util.Stack;

public class MaximalRectangle {

    static int maxAreaRectangle(int[] arr){
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = arr.length;
        for(int i=0;i<=n;i++){
            while(!stack.isEmpty() && (i==n || arr[stack.peek()]>=arr[i])){
                int height = arr[stack.peek()];
                stack.pop();
                int width;
                if(stack.isEmpty()) width = i;
                else width = i-stack.peek()-1;
                maxArea = Math.max(maxArea,height*width);

            }
            stack.push(i);
        }

        return maxArea;
    }

    static int maximalRectangle(int[][] arr){
        int n  = arr.length;
        int m = arr[0].length;
        int[][] prefixSum = new int[n][m];
        for(int j=0;j<m;j++){
            int sum = 0;
            for(int i=0;i<n;i++){
                sum+=arr[i][j];
                if(arr[i][j]==0) {
                    prefixSum[i][j] = 0;
                    sum = 0;
                }else{
                    prefixSum[i][j]=sum;
                }
            }
        }

        int maxArea=0;
        for(int i=0;i<n;i++){
            int area = maxAreaRectangle(prefixSum[i]);
            maxArea = Math.max(area,maxArea);
        }
        return maxArea;
    }

    static void main() {
        int[][] input = {
                {1, 0, 1, 0, 0},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 0, 0, 1, 0}
        };

        int area = maximalRectangle(input);
        System.out.println(area);
    }


}
