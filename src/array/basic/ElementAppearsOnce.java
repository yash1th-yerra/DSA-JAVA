package src.array.basic;

// Problem - Given a non empty array of integers arr, eveery element appears twice except one element . you have to find it

// arr = {1,2,2}    output - 1
// arr = {4,1,2,2,1} output - 4


import java.util.HashMap;
import java.util.Map;

public class ElementAppearsOnce {

    // Brute Force
    // 1. run i loop to select element
    // 2. for every element we have to do linear search using another loop and count their occurrence.
    // 3. if any element count is 1 then return it

//    public static int bruteElementAppearsOnce(int[] arr){       // Time Complexity - O(N^2)
//        for(int i=0;i<arr.length;i++){                          // Space Complexity - O(1)
//            int cnt = 0;
//            for(int j=0;j<arr.length;j++){
//                if(arr[j]==arr[i]){
//                    cnt+=1;
//                }
//            }
//            if(cnt==1) return arr[i];
//        }
//        return -1;
//    }


    // Better Approach
    /*
    *   1. declare map
    *   2. now using loop store each element as key and its frequency as value
    *   3. now using another loop check if any element's value is 1 if so then return key
    * */
//    public static int betterElementOnce(int[] nums){        // Time Complexity - O(N*logM ) + O(M)
//        int max = 0;                                        // Space Complexity - O(M)
//        HashMap<Integer,Integer> map = new HashMap<>();
//        for(int i=0;i<nums.length;i++){
//            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
//        }
//
//        for(Map.Entry<Integer,Integer> it: map.entrySet()){
//            if(it.getValue()==1){
//                return it.getKey();
//            }
//        }
//        return -1;
//    }


    // Optimal Approach
    /*
    *   if we do xor operation on two same numbers it will  0.
    *   as array contains only one unique element and everything else appears twice
    *   if we perform xor on each element at the end only unique element will be remained.
    * */

    public static int optimalElementAppearsOnce(int[] nums){            // Time Complexity - O(N)
        int xor = 0;                                                    // Space Complexity - O(1)
        for(int i=0;i<nums.length;i++){
            xor^=nums[i];

        }
        return xor;
    }

    public static void main(String[] args) {

        int[] arr = {4,1,2,2,1};

        int singleElement = optimalElementAppearsOnce(arr);
        System.out.println(singleElement);

    }
}
