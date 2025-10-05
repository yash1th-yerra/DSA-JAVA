package src.array.binarysearch;

public class LastOccurence {
    // similar to first occurence just find out upperbound index

    public static int lastOccurence(int[] arr, int key,int n){
        int low = 0,high= n-1,last = -1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid]==key){
                last = mid;
                low = mid+1;
            }
            else if(arr[mid]<key) low = mid+1;
            else high = mid-1;
        }

        return last;
    }

    public static void main(String[] args) {
        int[] arr = {2,4,6,8,8,8,11,13};
        int key = 8;
        System.out.println(lastOccurence(arr,key,arr.length));
    }

}
