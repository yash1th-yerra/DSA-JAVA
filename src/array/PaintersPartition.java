package src.array;

import java.util.Arrays;

public class PaintersPartition {


    public static int minArea(int[] arr,int mid){
        int cntPart=1,area = 0;
        for(int i=0;i<arr.length;i++){
            if(area+arr[i]<=mid){
                area+=arr[i];
            }
            else{
                area = arr[i];
                cntPart+=1;
            }
        }
        return cntPart;
    }

    public static void main(String[] args){
        int[] arr = {10,20,30,40};
        int low = Arrays.stream(arr).max().getAsInt();
        int high = Arrays.stream(arr).sum();
        int k=2;

        while(low<=high){
            int mid = low+(high-low)/2;
            int cntParts = minArea(arr,mid);
            if(cntParts>k) low = mid+1;
            else high = mid-1;
        }
        System.out.println(low);


    }
}
