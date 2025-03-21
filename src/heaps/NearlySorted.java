package src.heaps;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class NearlySorted {

    // You are given an array in which each element is atmost k steps away from its actual position
    // so you have to find out algorithm that sorts the array suffering such situation


    // given arr = [ 6,5,3,2,8,10,9]
    // here it is said k = 3 each element at most 3 steps away from its actual position
    // that is may be the 1st element in the array shifted 1 step 2 steps or 3 steps aways we don't know how many steps but it can upto k
    // the to sort such arrays we need to think of finding smallest number in the array
    // since merge sort can sort in O(NLOGN) we need to think of solution in much better complexity
    // only option i can think of is heaps
    // we need to maintain a minHeap
    // so we need to store k+1 elements in the minHeap as we traverse through array
    // if it reaches more than k+1 then we need to get top of heap and add it to result

    // if we ended up traversing the entire array then we just keep on adding elemetns from heap to resultant list
    // until that heap get empty

    public static List<Integer> sortHeap(int[] arr,int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        List<Integer> result = new ArrayList<>();
        for(int ele : arr){
            minHeap.add(ele);
            if(minHeap.size()>k+1){
                result.add(minHeap.poll());
            }
        }
        while(!minHeap.isEmpty()){
            result.add(minHeap.poll());
        }

        return result;
    }


    public static void main(String[] args) {
        int[] arr = {6,5,3,2,8,10,9};
        int k = 3;

        List<Integer> res = sortHeap(arr,k);
        for(int ele : res){
            System.out.print(ele+" ");

        }
            System.out.println();
    }

}
