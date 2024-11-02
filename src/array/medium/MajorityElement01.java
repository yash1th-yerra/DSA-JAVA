package src.array.medium;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement01 {

//    public static int majorityNaive(int[] nums) {                 //Time Complexity - O(n^2)
//        int count;
//        for( int i=0;i<nums.length;i++){
//            count = 0;
//            for(int j=0;j<nums.length;j++){
//                if(nums[i]==nums[j]){
//                    count++;
//
//                }
//                if(count>nums.length/2){
//                    return nums[i];
//                }
//            }
//        }
//        return -1;
//    }


//    public static int majorityHashing(int[] nums){                      // Time Complexity - O(n)
//        HashMap<Integer,Integer> map = new HashMap<>();                 //Space COmplexity - O(n)
//        for(int i=0;i<nums.length;i++){
//            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
//        }
//        for(Map.Entry<Integer,Integer> it: map.entrySet()){
//            if(it.getValue()>nums.length/2){
//                return it.getKey();
//            }
//
//        }
//        return -1;
//
//
//    }


    public static int majorityMooreVoting(int[] nums){          //Overall Time Complexity - O(n)
        int count = 0;
        int candidate = nums[0];
        for(int i=0;i<nums.length;i++){
            if(count==0){
                count = 1;
                candidate = nums[i];

            }
           else if(candidate==nums[i]){
               count++;
            }
           else count--;

        }

        return candidate;
    }



    public static void main(String[] args) {
        int[] nums = {3,2,3,2,1,2,2};
//        int result = majorityNaive(nums);
//        int result = majorityHashing(nums);
        int result = majorityMooreVoting(nums);
        System.out.println(result);
    }
}
