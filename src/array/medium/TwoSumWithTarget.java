package src.array.medium;

import javax.print.attribute.HashPrintJobAttributeSet;
import java.util.Arrays;
import java.util.HashMap;

public class TwoSumWithTarget {

//    public static int[] findTwoSum(int[] nums, int target) {        //Overall Time Complexity - O(n^2)
//        int[] result = {-1,-1};
//        for(int i=0;i<nums.length;i++){
//            for(int j =0;j<nums.length;j++){
//                if(i==j) continue;
//                if(nums[i]+nums[j]==target){
//                    result[0] = i;
//                    result[1] = j;
//                    return result;
//                }
//            }
//
//        }
//        return result;
//    }


//    public static int[] findTwoSum(int[] nums,int target){
//        int[] result = {-1,-1};
//        HashMap<Integer,Integer> map = new HashMap<>();
//        for(int i=0;i<nums.length;i++){
//            if(map.containsKey(target-nums[i])){
//                result[0]=map.get(target-nums[i]);
//                result[1] = i;
//                return result;
//            }
//            map.put(nums[i],i);
//        }
//
//        return result;
//    }

    public static int[] findTwoSum(int[] nums,int target){
        int[] result = {-1,-1};
        Arrays.sort(nums);
        int left=0;
        int right=nums.length-1;
        while(left<right){
            if(nums[left]+nums[right]==target){
                result[0]=left;
                result[1] = right;
                return result;
            }
            else if(nums[left]+nums[right]>target){
                right--;
            }
            else{
                left++;
            }

        }
        return result;


    }

    public static void main(String[] args) {
        int[] nums = {2,6,5,8,11};
        int target = 14;
        int[] result = new int[2];

        result = findTwoSum(nums,target);
        System.out.println(result[0]+" "+result[1]);


    }
}
