package src.slidingwindow_twopointer.medium;

import java.util.HashMap;
import java.util.Map;

public class NiceSubarrays {

    static int niceSubarraysBrute(int[] arr,int k){
        int count=0;
        for(int i=0;i<arr.length;i++){
            int oddCount = 0;
            for(int j=i;j<arr.length;j++){
                if(arr[j]%2!=0) oddCount++;
                if(oddCount>k) break;
                if(oddCount==k) count++;
            }
        }
        return count;
    }

    static int niceSubarraysBetter(int[] arr,int k){
        Map<Integer,Integer> freqMap = new HashMap<>();
        freqMap.put(0,1);
        int result=0;
        int oddCount = 0;
        for(int num:arr){
            if(num%2==1) oddCount++;
            if(freqMap.containsKey(oddCount-k)) result+=freqMap.get(oddCount-k);
            freqMap.put(oddCount,freqMap.getOrDefault(oddCount,0)+1);

        }
        return result;
    }

    static int niceSubarraysOptimal(int[] arr,int k){
        int left = 0,res = 0;
        for(int right=0;right<arr.length;right++){
            if(arr[right]%2!=0) k--;
            while(k<0){
                if(arr[left]%2!=0) k++;
                left++;
            }
            res+=(right-left+1);
        }
        return res;
    }


    static void main() {
        int[] arr = {1,1,2,1,4,1,1};
        int k = 3;
        System.out.println(niceSubarraysBrute(arr,k));
        System.out.println(niceSubarraysBetter(arr,k));
    }
}
