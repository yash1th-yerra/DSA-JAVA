package src.array.basic;

import java.util.HashMap;

public class LongestSubArrayWithSumK {

    // BruteForce
//    public static int findSubarray(int[] arr,int k){      // Time Complexity - O(N^2)
//        int len= 0;                                       // Space Complexity - O(1)
//        for(int i=0;i<arr.length;i++){
//            int sum =0;
//            for(int j =i;j<arr.length;j++){
//                sum+=arr[j];
//                if(sum==k) len = Math.max(len,j-i+1);
//
//            }
//
//        }
//        return len;
//    }


    //Hashing Approach

//    public static int findSubarray(int[] arr,int k){                  // Time Complexity - O(N*logN)
//        HashMap<Integer,Integer> preSum = new HashMap<>();            // Space Complexity - O(N)
//        int sum =0;
//        int maxLen = 0;
//        for(int i=0;i<arr.length;i++){
//            sum+=arr[i];
//            if(sum==k) maxLen = Math.max(maxLen,i+1);
//
//            int rem= sum-k;
//
//            if(preSum.containsKey(rem)){
//                maxLen = Math.max(maxLen,i-preSum.get(rem));
//            }
//
//            if(!preSum.containsKey(sum))
//                preSum.put(sum,i);
//
//        }
// return maxLen;
//    }


    // Two Pointers Approach
    public static int findSubarray(int[] arr, int k){           // Time Complexity - O(N)
        int left = 0,right=0;                                   // Space Complexity - O(1)
        int sum = arr[0];
        int maxLen = 0;
        while(right<arr.length){
            while(left<=right && sum>k){
                sum -=arr[left];
                left++;
            }
            if(sum==k) maxLen = Math.max(maxLen,right-left+1);
            right++;
            if(right<arr.length) sum+=arr[right];

        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,5,1,9};
        int k = 10;
        int ans = findSubarray(arr,k);
        System.out.println(ans);
    }


}
