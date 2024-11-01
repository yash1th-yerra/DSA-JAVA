package src.array.basic;

import java.util.Arrays;

public class SmallestInArray {

//    public static int bruteSmall(int[] arr){    //Time Complexity - O(nlogn)
//        Arrays.sort(arr);
//        return arr[0];
//
//    }


    public static int optimiseSmall(int[] arr){             //Time Complexity - O(n)
        int min = arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]<min){
                min=arr[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] arr = {5,2,4,1,3};

//      int min = bruteSmall(arr);
        int min = optimiseSmall(arr);
        System.out.println(min);

    }
}
