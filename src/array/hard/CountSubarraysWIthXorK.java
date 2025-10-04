package src.array.hard;


/*
     Problem Statement: Given an array of integers A and an integer B.
     Find the total number of subarrays having bitwise XOR of all elements equal to k.
*/


import java.util.HashMap;
import java.util.Map;

/*
        Example 1:
        Input Format: A = [4, 2, 2, 6, 4] , k = 6
        Result: 4
        Explanation: The subarrays having XOR of their elements as 6 are  [4, 2], [4, 2, 2, 6, 4], [2, 2, 6], [6]

        Example 2:
        Input Format: A = [5, 6, 7, 8, 9], k = 5
        Result: 2
        Explanation: The subarrays having XOR of their elements as 5 are [5] and [5, 6, 7, 8, 9]


 */
public class CountSubarraysWIthXorK {


    // BruteForce Approach
    // Run loops fixing starting and ending points

    private static int bruteCountSubArraysWithXorK(int[] arr, int k) {
        // Time Complexity - O(N^3)
        // Space Complexity - O(1)
        int cnt = 0;

        for (int i = 0; i < arr.length; i++) {          // pick start index
            for (int j = i; j < arr.length; j++) {      // pick end index
                int xor = 0;
                for (int l = i; l <= j; l++) {          // compute XOR from i..j
                    xor ^= arr[l];
                }
                if (xor == k) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    // Better Solution
    private static int betterCountSubArraysWithXorK(int[] arr,int k){

        // Time Complexity - O(N^2)
        // Space Complexity - O(1)
        int cnt=0;

        for(int i=0;i<arr.length;i++){

            int xor = 0;
            for(int j=i;j<arr.length;j++){
                xor = xor ^ arr[j];
                if(xor==k){
                    cnt++;
                }
            }
        }



        return cnt;
    }



    // Optimal Solution ( optimal hashmap + prefix xor)
    /*
        1. First try to get xor of each subarray and store them in map (data structure)(you can keep this xor at end in step 4 , it is not necessary to keep at start)
        2. do xor of that xor with k
        3. now find the final xor in map
        4. if found increment count else continue and put final xor in map
     */


    private static int optimalCountSubArraysWithXorK(int[] arr,int k){
        // Time Complexity - O(N)
        // Space Complexity - O(N)
        int cnt=0;
        int xr = 0;
        int x = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++) {
            xr = xr ^ arr[i];
            // case 1 : subarray from start itself a xor of k
            if (xr == k) {
                cnt++;
            }
            x = xr ^ k;
            // case 2: subarray with xor x exists in map such it will make xor k with current xr
            if (map.containsKey(x)) {
                cnt += map.get(x);
            }
            map.put(x, map.getOrDefault(x,0)+1);
        }
        return cnt;
    }

    public static void main(String[] args){
        int arr[] = {4, 2, 2, 6, 4};
        int k = 6;
//        System.out.println(bruteCountSubArraysWithXorK(arr,k));
        System.out.println(optimalCountSubArraysWithXorK(arr,k));
    }

}
