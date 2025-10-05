package src.array.binarysearch;

public class SearchInSortedArray {
    /*
         given array = {7,8,9,1,2,3,4,5,6}
         target = 1
         output: 3


         approach:
         1. identify sorted part
         2. check if target exists in that
         3. if no move to other part

     */


    public static int findTarget(int[] arr,int target,int n){
        int low = 0,high = n-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid]==target) return mid;
            if (arr[low]<=arr[mid]){
                if(arr[low]<=target && target<=arr[mid]) high = mid-1;
                else low = mid+1;
            }
            else{
                if(arr[mid]<=target && target<=arr[high]) low = mid+1;
                else high = mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {7,8,9,1,2,3,4,5,6};
        int target = 1;
        System.out.println(findTarget(arr,target,arr.length));
    }
}
