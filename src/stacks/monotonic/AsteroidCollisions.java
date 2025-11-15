package src.stacks.monotonic;

import java.util.Stack;

public class AsteroidCollisions {


    static int[] asteroidCollision(int[] arr){
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++){
            if(arr[i]>0){
                stack.push(arr[i]);
            }else{
                while(!stack.isEmpty() && stack.peek()>0 && stack.peek()<Math.abs(arr[i])) stack.pop();
                if(!stack.isEmpty() && stack.peek()==Math.abs(arr[i])) stack.pop();
                else if (stack.isEmpty() || stack.peek()<0) stack.push(arr[i]);
            }
        }

        int[] result = new int[stack.size()];
        for(int i=stack.size()-1;i>=0;i--){
            result[i] = stack.pop();
        }
        return result;

    }
    static void main() {
        int[] arr = {10, 20, -10};



        // Call the asteroidCollision function
        int[] ans = asteroidCollision(arr);

        // Print the final state of asteroids
        System.out.print("The state of asteroids after collisions is: ");
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
