package src.array.basic;

import java.util.HashMap;

public class LongestSubarraySumWithK {

//    public static int maxSubArraySumBrute(int[] arr, int k) {
//        int max = 0;
//        for(int i=0;i<arr.length;i++){
//            for(int j=i;j<arr.length;j++){
//                int sum = 0;
//                for(int l=i;l<=j;l++){
//                    sum+=arr[l];
//
//                }
//                if(sum==k){
//                    max = Math.max(max,j-i+1);
//                    break;
//                }
//
//            }
//        }
//    return max;
//
//    }

//    public static int maxPreSumSubarray(int[] arr, int k) {
//        HashMap<Integer,Integer> preSumMap = new HashMap<>();
//        int sum=0;
//        int maxLen=0;
//        for(int i=0;i<arr.length;i++){
//            sum+=arr[i];
//            if(sum==k){
//                maxLen=i+1;
//            }
//            int rem = sum-k;
//            if(preSumMap.containsKey(rem)){
//                int len = i-preSumMap.get(rem);
//                maxLen = Math.max(maxLen,len);
//            }
//            if(!preSumMap.containsKey(sum)){
//                preSumMap.put(sum,i);
//            }
//
//        }
//        return maxLen;
//    }


    public static int maxSubarrayPointer(int[] arr, int k) {
        int left=0;
        int right=0;
        int sum=arr[0];
        int maxLen=0;
        while(right<arr.length){
            while(left<=right && sum>k){
                sum-=arr[left];
                left++;
            }
            if(sum==k){
                maxLen = Math.max(maxLen,right-left+1);
            }
            right++;
            if(right<arr.length){
                sum+=arr[right];
            }

        }



        return maxLen;
    }



    public static void main(String[] args) {

        int[] arr = {1,2,3,1,1,1,1,4,2,3};
        int[] arr2 = {3,0,0,1,4,5,2};
        int k =3;
        //Naive Brute approach will be generating subarrays and calculate sum .
//        int max=maxSubArraySumBrute(arr,k);         // Time Cmoplexity ~ O(n^3)

        //Hashing Approach
//        int max=maxPreSumSubarray(arr,k);         // Time Cmoplexity ~ O(n) ,space Complexity - O(n)

        //Two Pointer Approach

        int max=maxSubarrayPointer(arr2,k);
        System.out.println(max);


    }
}
