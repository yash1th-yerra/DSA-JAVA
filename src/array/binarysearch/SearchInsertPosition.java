package src.array.binarysearch;

public class SearchInsertPosition {

    // You are given a sorted array arr of distinct values and target value x .
    // You need to search for index of target value in the array.
    // If the value is present in the array, then return its index.
    // Otherwise, determine the index where it would be inserted in the array while maintaining the sorted order.


    /*
        Example 1:
        Input Format: arr[] = {1,2,4,7}, x = 6
        Result: 3
        Explanation: 6 is not present in the array. So, if we will insert 6 in the 3rd index(0-based indexing), the array will still be sorted. {1,2,4,6,7}.

        Example 2:
        Input Format: arr[] = {1,2,4,7}, x = 2
        Result: 1
        Explanation: 2 is present in the array and so we will return its index i.e. 1.
     */


    private static int searchInsert(int[] arr,int x){
        int n = arr.length;
        int low = 0,high = n-1;
        int ans = n;

        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid]>=x){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }

    static void main() {
        int[] arr = {1, 2, 4, 7};
        int x = 0;
        int ind = searchInsert(arr, x);
        System.out.println("The index is: " + ind);
    }

}
