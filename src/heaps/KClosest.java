package src.heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class KClosest {


    // you are given an sorted array, key and k value . your task is to find out k closest elements in that given array

    // ex:arr[1,2,3,4,5] x = 3 k = 4
    // output : 1,2,3,4 why?
    // at first 2 and 4 are closer to 3
    // and at second 1 and 5 are next closer to 3
    // however we require only four elements including element itself hence we took smaller out of 1 and 5

    // How to solve this?
    // Intuition : closest element is nothing but the element having absolute difference as less as possible than others
    // 1,2,3,4,5  we need elements closer to 3 so we need to find out distance of elements from 3
    // 3 3 3 3 3 subtract
    // 2,1,0,1,2   now we need to take less distance elements
    // to select like that we need to use maxHeap since it removes max at top after k

    // Time Complexity - O(NlogK)
    // space complexity - O(2K)

    // can we reduce this? yes
    // How ?
    // since array is sorted we can use two pointer approach and we'll continue till we end up having k elements
    // this will take
    // Time Complexity - O(N)
    // Space Complexity - O(K)
    public static List<Integer> optimalKClosest(int[] arr, int x, int k){
        int left = 0;
        int right = arr.length-1;

        while(right-left+1>k){
            if((arr[left]-x)>(arr[right]-x)){
                left++;
            }
            else{
                right--;
            }
        }

        List<Integer> result = new ArrayList<>();
        for(int i=left;i<=right;i++){
            result.add(arr[i]);
        }
        return result;
    }

    public static List<Integer> findKClosest(int[] arr,int x,int k){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
                (a,b) -> Math.abs(b-x)==Math.abs(a-x)? b-a : Math.abs(b-x)-Math.abs(a-x)
        );



        for(int ele:arr){
            maxHeap.add(ele);
            if(maxHeap.size()>k){
                maxHeap.poll();
            }
        }

        List<Integer> result = new ArrayList<>();
         while(!maxHeap.isEmpty()){
             result.add(maxHeap.poll());
         }
        Collections.sort(result);

         return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,2,3,4,5};
        int k = 4,x=-1;
        List<Integer> res = findKClosest(arr,x,k);
        int[] arr2 = {1,2,3,4,5};
        int k2 = 4,x2=3;
        List<Integer> res2 = findKClosest(arr2,x2,k2);

        for(int i:res){
            System.out.print(i+" ");
        }
        System.out.println();

        for(int i:res2){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
