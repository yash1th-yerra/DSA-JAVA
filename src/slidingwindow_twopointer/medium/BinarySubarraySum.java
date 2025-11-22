package src.slidingwindow_twopointer.medium;

import java.util.HashMap;
import java.util.Map;

public class BinarySubarraySum {

    static int binarySubArraySumBrute(int[] arr,int goal){
        int count =0;
        int n = arr.length;
        for(int i =0;i<n;i++){
            int sum = 0;
            for(int j=i;j<n;j++){
                sum += arr[j];
                if(sum==goal) count++;
            }
        }
        return count;
    }

    static int binarySubArraySumBetter(int[] arr,int goal){
        Map<Integer,Integer> prefixSumCount = new HashMap<>();
        int count=0,sum=0;
        prefixSumCount.put(0,1);
        for(int num: arr){
            sum+=num;
            if(prefixSumCount.containsKey(sum-goal)) count+=prefixSumCount.get(sum-goal);
            prefixSumCount.put(sum,prefixSumCount.getOrDefault(sum,0)+1);
        }
        return count;

    }
    static int atMost(int[] arr,int k){
        if(k<0) return 0;
        int left = 0,sum=0,count=0;
        for(int right=0;right<arr.length;right++){
            sum+=arr[right];
            while(sum>k){
                sum-=arr[left];
                left++;
            }
            count+=(right-left+1);
        }
        return count;
    }
    static int binarySubArraySumOptimal(int[] arr,int goal){
        return atMost(arr,goal) - atMost(arr,goal-1);
    }

    static void main() {
        int[] arr = {1,0,1,0,1};
        int goal = 2;
        System.out.println(binarySubArraySumBrute(arr,goal));
        System.out.println(binarySubArraySumBetter(arr,goal));
        System.out.println(binarySubArraySumOptimal(arr,goal));
    }
}
