package src.slidingwindow_twopointer.hard;

import java.util.HashMap;
import java.util.Map;

public class SubarrayWithKDiffIntegers {



    static int subarraysWithKIntegersBrute(int[] arr,int k){
        int count = 0;
        for(int i=0;i<arr.length;i++){
            Map<Integer,Integer> freqMap = new HashMap<>();
            for(int j=i;j<arr.length;j++){
                freqMap.put(arr[j],freqMap.getOrDefault(arr[j],0)+1);
                if(freqMap.size()==k) count++;
                if(freqMap.size()>k) break;


            }

        }
        return count;
    }

    static int atmostK(int[] arr,int k){
        int count =0,left=0;
        Map<Integer,Integer> freq = new HashMap<>();
        for(int right= 0;right<arr.length;right++){
            freq.put(arr[right],freq.getOrDefault(arr[right],0)+1);
            if(freq.get(arr[right])==1) k--;
            while(k<0){
                freq.put(arr[left],freq.get(arr[left])-1);
                if(freq.get(arr[left])==0) k++;
                left++;
            }
            count+=(right-left+1);
        }
        return count;
    }
    static int subarraysWithKIntegersOptimal(int[] arr,int k){
        return atmostK(arr,k) - atmostK(arr,k-1);
    }


    static void main() {
        int[] arr = {1,2,1,2,3};
        int k = 2;
        System.out.println(subarraysWithKIntegersBrute(arr,k));
        System.out.println(subarraysWithKIntegersOptimal(arr,k));
    }
}
