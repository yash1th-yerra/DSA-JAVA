package src.heaps;

public class CheckMinHeap {

    public static boolean checkMinHeap(int[] arr){
        int n = arr.length;
        for(int i=0;i<(n/2)-1;i++){
            int left = 2*i+1;
            int right = 2*i+2;

            if(left<n && arr[left]<arr[i]) return false;
            if(right<n && arr[right]<arr[i]) return false;

        }
        return true;
    }
}
