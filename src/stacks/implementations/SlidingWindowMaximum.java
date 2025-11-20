package src.stacks.implementations;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class SlidingWindowMaximum {
    static void getMax(int[] arr,int l,int r ,ArrayList<Integer> res){
        int i=0,maxi=Integer.MIN_VALUE;
        for(i=l;i<=r;i++){
            maxi = Math.max(maxi,arr[i]);


        }
        res.add(maxi);
    }
    static ArrayList<Integer> slidingWindowMaxBrute(int[] arr ,int k){
        int left=0,right=0;
        ArrayList<Integer> res = new ArrayList<>();
        while(right<k-1){
            right++;
        }

        while(right<arr.length){
            getMax(arr,left,right,res);
            left++;
            right++;
        }
        return res;
    }


    static ArrayList<Integer> slidingWindowMaxOptimal(int[] arr,int k){
        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>();
        int index=0;
        Deque<Integer> q = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            if(!q.isEmpty() && q.peek()==i-k) q.poll();
            while(!q.isEmpty() && arr[q.peek()]<=arr[i]) q.pollLast();
            q.offer(i);
            if(i>=k-1)  res.add(arr[q.peek()]);
        }
        return res;

    }

    static void main() {
        int i, j, n, k = 3, x;
        int arr[]={4,0,-1,3,5,3,6,8};
        ArrayList < Integer > ans;

        ans = slidingWindowMaxBrute(arr, k);
        System.out.println("Maximum element in every " + k + " window ");
        for (i = 0; i < ans.size(); i++)
            System.out.print(ans.get(i) + "  ");

        System.out.println();
        ans = slidingWindowMaxOptimal(arr, k);
        System.out.println("Maximum element in every " + k + " window ");
        for (i = 0; i < ans.size(); i++)
            System.out.print(ans.get(i) + "  ");
    }
}
