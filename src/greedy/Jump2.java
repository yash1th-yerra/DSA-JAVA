package src.greedy;

public class Jump2 {



    // given an array where a[i] contains maximum jump you can take from index i
    // i.e. maxJump  = i+a[i]
    // you will be at a[maxIndex]
    // 0<=i<n
    // 0<=a[i]<=n
    // we need to get minimum no of jumps it take to reach end of array

    // a[] = {2,3,1,1,4]
    // 2-> 3 -> 1 -> 1 -> 4
    // 2 -> 1 -> 1 -> 4
    // 2 -> 3 -> 1 -> 4
    // 2 -> 3 -> 4 (this is minimum )
    // return 3

    // how to do this?

    // we can try out all positions we can jump from i
    // think of recursion
    // base case can be we if ind>n return jumps;
    // for(i=0 -> n)
    // mini = min(mini,f(ind+1,jump+1)
    // this will cost to exponential time complexity - O(n^n) and aux space - O(N)


    // memoize above recursion to reduce time complexity


    // we can use greedy approach
    // how? if we maintain range for each maxjump
    // then we can take 1 jump added to jumps until that range


    public static int findMinJumps(int[] arr){
        int jumps = 0,l=0,r=0;
        while(r<arr.length-1){
            int farthest = 0;
            for(int i = l;i<=r;i++){
                farthest = Math.max(farthest,i+arr[i]);
            }
            l = r+1;
            r= farthest;
            jumps++;
        }


        return jumps;


    }


    public static void main(String[] args) {
        int[] arr = {2,3,1,1,4};
        System.out.println(findMinJumps(arr));
    }





}
