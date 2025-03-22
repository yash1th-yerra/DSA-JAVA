package src.heaps;

import java.util.*;

public class TopKFrequentNumbers {

    /*
        You are given an array which may contain duplicates so task is to identify top k frequently occured elements
        for example:
        arr = [1,1,1,2,2,3]
        k = 2
        output = [1,2]
        because 1-3times
        2 - 2times
        3 - 1 time
        hence we need top 2 [1,2] are selected
        How do we approach ?
        simple keep minHeap and add elements according to their frequency


        but how to manage that frequency so we need some map data structure to get the frequency of element



    */

    // Time Complexity - O(NlogK)
    // Space Complexity  - O(N+K)

    public static int[] topKFreq(int[] arr,int k){
        Map<Integer,Integer> freq = new HashMap<>();
        for(int ele:arr){
            freq.put(ele,freq.getOrDefault(ele,0)+1);
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                (a,b)->a[1]-b[1]
        );

        for(Map.Entry<Integer,Integer> entry : freq.entrySet()){
            minHeap.add(new int[]{entry.getKey(), entry.getValue()});
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }

        int[] result = new int[k];
        int index=0;
        while(!minHeap.isEmpty()){
            result[index++] = minHeap.poll()[0];
        }
        return result;
    }


    // to reduce it further we can go for bucket solution

    public static int[] optimalKFreq(int[] arr, int k ){

        Map<Integer,Integer> freq = new HashMap<>();
        for(int ele:arr){
            freq.put(ele,freq.getOrDefault(ele,0)+1);
        }

        List<Integer>[] bucket = new List[arr.length+1];
        for(int key:freq.keySet()){
            int frequency = freq.get(key);
            if(bucket[frequency]==null){
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        List<Integer> result = new ArrayList<>();
        for(int i=arr.length-1;i>=0 && result.size()<k;i--){
            if(bucket[i]!=null){
                result.addAll(bucket[i]);
            }
        }
       return  result.stream().mapToInt(i ->i).toArray();

    }

    // Time Complexity - O(N)
    // Space Complexity  - O(N)

    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,4,3};
        int k = 2;
//        int[] res = topKFreq(arr,k);
        int[] res = optimalKFreq(arr,k);
        for(int i:res){
            System.out.print(i+" ");

        }
        System.out.println();
    }
}
