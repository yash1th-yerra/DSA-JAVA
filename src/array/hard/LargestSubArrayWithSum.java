package src.array.hard;
//Problem Statement: Given an array containing both positive and negative integers,
// we have to find the length of the longest subarray with the sum of all elements equal to zero.
/*

    Example 1:
    Input Format: N = 6, array[] = {9, -3, 3, -1, 6, -5}
    Result: 5
    Explanation: The following subarrays sum to zero:
    {-3, 3} , {-1, 6, -5}, {-3, 3, -1, 6, -5}
    Since we require the length of the longest subarray, our answer is 5!

    Example 2:
    Input Format: N = 8, array[] = {6, -2, 2, -8, 1, 7, 4, -10}
    Result: 8
    Subarrays with sum 0 : {-2, 2}, {-8, 1, 7}, {-2, 2, -8, 1, 7}, {6, -2, 2, -8, 1, 7, 4, -10}
    Length of longest subarray = 8

    Example 3:
    Input Format: N = 3, array[] = {1, 0, -5}
    Result: 1
    Subarray : {0}
    Length of longest subarray = 1

    Example 4:
    Input Format: N = 5, array[] = {1, 3, -5, 6, -2}
    Result: 0
    Subarray: There is no subarray that sums to zero
*/



// bruteforce :
/*
    1. take two pointers and run for each element
    2. sum elements between two pointers
    3. if sum =0 then calculate length and compare it with maxLen
    4. if it is maximum replace it with maxLen
    5. do this process for all kind of combinations
    6. return maximum length

        public int BruteForceLargestSubArrayWithSum(int[] arr){
        int maxLen = -1;
        int sum =0;
        int n = arr.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                sum+=arr[i];
                if(sum==0){
                    maxLen = Math.max(maxLen,j-i+1);
                }
            }
        }
        return maxLen;
    }


 */


/*
    Optimal approach:
    1. maintain a prefix sum using some hashmap datastructure
    2. as you iterate over array calculate sum and check if it exists in hashmap
    3. if it doesn't exist add sum as key and index as value into hashmap
    4. if exists consider it as prefix sum , using that take index and calculate length from curr index of array to that index in hashmap
 */

import java.util.HashMap;

public class LargestSubArrayWithSum {

    public static int findSubarrayWith0(int[] arr){
        int n = arr.length;
        HashMap<Integer,Integer> pSum = new HashMap<>();
        int maxLen = 0;
        int sum = 0;
        pSum.put(0,-1);
        for(int i=0;i<n;i++){
            sum+=arr[i];
            if(pSum.containsKey(sum)){
                maxLen = Math.max(maxLen,i-pSum.get(sum));
            }else{
                pSum.put(sum,i);
            }
        }

        return maxLen;
    }


    public static void main(String[] args) {
        int array[] = {9, -3, 3, -1, 6, -5};
        System.out.println("1-TestCase: "+findSubarrayWith0(array));

        int array2[] = {6, -2, 2, -8, 1, 7, 4, -10};
        System.out.println("2-TestCase: "+findSubarrayWith0(array2));

        int array3[] = {1, 3, -5, 6, -2};
        System.out.println("3-TestCase: "+findSubarrayWith0(array3));

    }



}
