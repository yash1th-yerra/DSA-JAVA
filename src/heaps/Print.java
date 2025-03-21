package src.heaps;

import java.util.PriorityQueue;

public class Print {
    public static PriorityQueue<Integer> print(int[] arr){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int j : arr) {
            minHeap.add(j);


        }
        return minHeap;

    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,1,6,2};



        System.out.println(print(nums));

    }
}
