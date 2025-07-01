package src.array.hard;

import java.util.ArrayList;

public class CountInversions {

    // given an array and we have to find out the count of inversions
    // arr = {5,3,2,4,1}
    // a pair is inversion pair if a[i] > a[j] where i<j

    // brute force
    // run two loops and check this condition for each pair


    public static int countInversionsBrute(int[] arr){
        int cnt = 0;
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]>arr[j]) cnt++;
            }
        }
        return cnt;
    }           // TC - O(n^2) SC - O(1)


    // optimal approach
    // do follow merge sort algorithm
    // and in that algorithm whenever we find low index element with high value than higher index value
    // while swaping them also increment count


    private static int merge(int[] arr,int low,int mid ,int high){
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid+1;
        int cnt = 0;

        while(left<=mid && right<=high){
            if(arr[left]<=arr[right]){
                temp.add(arr[left]);
                left++;
            }
            else{
                temp.add(arr[right]);
                cnt+=(mid-left+1);
                right++;
            }
        }


        while(left<=mid){
            temp.add(arr[left]);
            left++;
        }
        while(right<=high){
            temp.add(arr[right]);
            right++;
        }

        for(int i=low;i<=high;i++){
            arr[i]= temp.get(i-low);
        }
        return cnt;
    }

    private static int mergeSort(int[] arr,int low,int high){
        if(low>=high) return 0;
        int mid = low+(high-low)/2;
        int cnt = 0;
        cnt+= mergeSort(arr,low,mid);
        cnt+=mergeSort(arr,mid+1,high);
        cnt+=merge(arr,low,mid,high);
        return cnt;

    }
    public static int countInversionsOptimal(int[] arr){

        int left = 0;
        int right = arr.length;

        return mergeSort(arr,left,right);

    }



    public static void main(String[] args) {
        int[] arr = {5,3,2,4,1};
        System.out.println(countInversionsBrute(arr));
    }

}
