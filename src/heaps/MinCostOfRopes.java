package src.heaps;

import java.util.PriorityQueue;

public class MinCostOfRopes {

    // you are given lengths of ropes in array
    // you are task is to merge/tie those ropes such that cost should be minimum
    // cost is nothing but sum of lengths of ropes that are connecting
    // how to approach this?
    // if we select min length ropes and add it then we have to keep them aside
    // again select any two min elements and do the same
    // meanwhile the sums that are generated will also be minimum so we should keep an eye on them as well
    // solution is have a minHeap and get top two min elements from minHeap and add them
    // after summing add that result back to minHeap
    // do this process until minHeap contains single element


    public static int costOfRopes(int[] arr){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int a:arr){
            minHeap.add(a);
        }
        int totalCost =0;
        while(minHeap.size()>1){
            int first = minHeap.poll();
            int second = minHeap.poll();
            int cost = first+second;
            totalCost+=cost;
            minHeap.add(cost);
        }
        return totalCost;
    }

    public static void main(String[] args) {
        int[] arr = {4,3,2,6};
        System.out.println(costOfRopes(arr));
    }
}
