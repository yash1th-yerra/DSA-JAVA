package src.array.binarysearch;

public class CountOccurences {
    // You are given a sorted array containing N integers and a number x , you have to find the occurences of x in the given array
//    Example 1:
//    Input: N = 7,  X = 3 , array[] = {2, 2 , 3 , 3 , 3 , 3 , 4}
//    Output: 4
//    Explanation: 3 is occurring 4 times in
//    the given array so it is our answer.
//
//    Example 2:
//    Input: N = 8,  X = 2 , array[] = {1, 1, 2, 2, 2, 2, 2, 3}
//    Output: 5
//    Explanation: 2 is occurring 5 times in the given array so it is our answer.


    // BruteForce approach (linear search)
    // run a loop from 0 to n-1
    // maintain a counter and increase it whenever there is an match found in array to that target value
    // at last return that counter

    // Time Complexity - O(N)
    // Space Complexity - O(1)

    private static int bruteCountOccurences(int[] arr,int n,int x){
        int count=0;
        for(int i=0;i<n;i++){
            if(arr[i]==x) count++;
        }
        return count;
    }


    // can we optimize this?
    // yes using binary search
    // find first occurence and last occurence of target value in the array using binary search
    // then return lastOccurenceIndex - firstOccurenceIndex + 1


    private static int firstOccurence(int[] arr,int n ,int x){
        int first = -1;
        int low = 0,high = n-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid]==x) {
                first = mid;
                high = mid-1;
            }else if(arr[mid]<x) {
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return first;
    }

    private static int lastOccurence(int[] arr,int n ,int x){
        int last = -1;
        int low = 0,high = n-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid]==x) {
                last = mid;
                low = mid+1;
            }else if(arr[mid]<x) {
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return last;
    }


    private static int[] findFirstAndLastPosition(int[] arr,int n,int x){
        int first = firstOccurence(arr,n,x);
        if(first==-1) return new int[]{-1,-1};
        int last = lastOccurence(arr,n,x);
        return new int[]{first,last};

    }

    private static int optimalCountOccurences(int[] arr,int n,int x){
        int[] positions = findFirstAndLastPosition(arr,n,x);
       if(positions[0]==-1) return 0;
       return (positions[1]-positions[0]+1);
    }


    static void main() {
        int[] arr =  {2, 4, 6, 8, 8, 8, 11, 13};
        int n = 8, x = 8;
//        int ans = bruteCountOccurences(arr, n, x);
        int ans = optimalCountOccurences(arr,n,x);
        System.out.println("The number of occurrences is: " + ans);
    }
}
