package src.heaps;

import java.util.PriorityQueue;

public class KthSmallestInArray {
    public static int findKthSmallest(int[] arr, int k){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b)->b-a);

        for (int j : arr) {
            maxHeap.add(j);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }

        }
        return maxHeap.peek();

    }

    public static void main(String[] args) {
        int[] nums = {7, 10, 4, 3, 20, 15};
        int k = 3;

        int kth = findKthSmallest(nums,k);
        System.out.println(kth);


        int[] nums2 ={2, 3, 1, 20, 15};
        int k2 = 4;
        int kth2 = findKthSmallest(nums2,k2);
        System.out.println(kth2);
    }
}
