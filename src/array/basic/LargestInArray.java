package src.array.basic;

import java.util.Arrays;

public class LargestInArray {

//    public static int BruteLargest(int[] arr){            // Time Complexity - O(nlogn)
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
