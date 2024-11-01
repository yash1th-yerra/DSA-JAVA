package src.array.basic;

import java.util.Arrays;

public class SecondLargest {


//    public static int findLargest(int[] arr) {
//        Arrays.sort(arr);           // Time complexity - O(nlogn)
//        for(int i=arr.length-2;i>=0;i--){
//            if(arr[i]!=arr[i+1])
//                return arr[i];
//        }
//        return arr[0];
//    }



    public static int findLargest(int[] arr) {          //Time Complexity - O(n)
        int large = Integer.MIN_VALUE;
        int secondLarge = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>large){
                large=arr[i];
            }
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]>secondLarge && arr[i]!=large){
                secondLarge = arr[i];
            }
        }
        return secondLarge;
    }

    public static void main(String[] args) {
        int[] arr = {5,3,1,2,2,7,7};
        int max = findLargest(arr);
        System.out.println(max);
    }
}
