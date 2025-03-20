package src.heaps;

import java.util.PriorityQueue;

public class KthLargestInArray {

    public static int findKthLargest(int[] arr,int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int j : arr) {
            minHeap.add(j);
            if (minHeap.size() > k) {
                minHeap.poll();
            }

        }
        return minHeap.peek();

    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;

        int kth = findKthLargest(nums,k);
        System.out.println(kth);


        int[] nums2 ={3,2,3,1,2,4,5,5,6};
        int k2 = 4;
        int kth2 = findKthLargest(nums2,k2);
        System.out.println(kth2);
    }
}
