package src.array.binarysearch;

public class FirstOccurence {
    // we will be given a sorted array and key element we need to find out the first occurence of that key in array
    /*
        ex: arr = {2,4,6,8,8,8,11,13}
        key = 8
        found at index 3

     */

    // Note : If question states First Occurence or Lower Bound it still same


    /*
        BruteForce:
        1. run a loop from front and return first index where we found key element
        however it takes TC-O(N) in worst case
     */

    /*
        Optimal:
        1. we know the optimal searching algorithm i.e. binary search
        2. we implement binary search to find first occurence i.e. find lowerbound

     */

    public static int firstOccurence(int[] arr,int key,int n){
        int low = 0,high = n-1,first = -1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid]==key){
                first = mid ;
                high = mid-1;

            }
            else if(arr[mid]<key){
                low  = mid+1;
            }
            else high = mid-1;
        }
        return first;
    }

    public static void main(String[] args) {
//        int[] arr = {2,4,6,8,8,8,11,13};
        int[] arr = {1,2,2,3};
        int key= 2;
        System.out.println(firstOccurence(arr,key,arr.length));
    }
}
