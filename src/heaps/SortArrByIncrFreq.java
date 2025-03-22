package src.heaps;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortArrByIncrFreq {

    public static  int[] frequencySort(int[] nums) {
        Map<Integer,Integer> freqMap = new HashMap<>();
        for(int num:nums){
            freqMap.put(num,freqMap.getOrDefault(num,0)+1);
        }

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a,b) -> a[1]==b[1]? b[0]-a[0] : a[1]-b[1]
        );

        for(Map.Entry<Integer,Integer> entry : freqMap.entrySet()){
            maxHeap.add(new int[]{entry.getKey(),entry.getValue()});
        }
        int[] result = new int[nums.length];
        int index=0;
        while(!maxHeap.isEmpty()){
            int[] current = maxHeap.poll();
            int freq = current[1];
            int key = current[0];
            for(int i=0;i<freq;i++){
                result[index++] = key;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,2,2,3};
        int[] nums2 = {2,3,1,3,2};
        int[] nums3 = {-1,1,-6,4,5,-6,1,4,1};

        int[] res = frequencySort(nums);
        for(int i:res){
            System.out.print(i+" ");
        }
        System.out.println();
        int[] res2 = frequencySort(nums2);
        for(int i:res2){
            System.out.print(i+" ");
        }
        System.out.println();
        int[] res3 = frequencySort(nums3);
        for(int i:res3){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
