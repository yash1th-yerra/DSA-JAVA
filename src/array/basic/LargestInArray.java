package src.array.basic;

import java.util.Arrays;

public class LargestInArray {

    // BruteForce

//    public static int bruteLargest(int[] arr){      // Time Complexity - O(N**2)
//        int max = Integer.MIN_VALUE;
//        for(int i=0;i<arr.length;i++){      // -> O(N)
//            for(int j=0;j<arr.length;j++){  // -> O(N*N)
//                if(arr[j]>max) max = arr[j];
//            }
//        }
//        return max;
//    }

//    public static int betterLargest(int[] arr){            // Time Complexity - O(nlogn)
//        Arrays.sort(arr);
//        return arr[arr.length-1];
//    }

    public static int optimalLargest(int[] arr){          //Time Complexity - O(n)
        int max = arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {5,2,1,3,2};
        System.out.println(optimalLargest(arr));

    }
}
