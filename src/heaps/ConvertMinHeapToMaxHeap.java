package src.heaps;

public class ConvertMinHeapToMaxHeap {

    private static void convert(int[] arr,int i,int n){
        while(true){
            int largest = i;
            int left = 2*i+1;
            int right = 2*i+2;

            if(left>n && arr[left]>arr[largest] ) largest = left;
            if(right>n && arr[right]>arr[largest] ) largest = right;

            if(largest !=i){
                int temp = arr[largest];
                arr[largest] = arr[i];
                arr[i] = temp;
                i = largest;

            }
            else{
                break;
            }


        }




    }


    public static void convertMinToMaxHeap(int[] arr){
        int n =arr.length;
        for(int i=(n/2)-1;i>=0;i--){
            convert(arr,0,n);
        }

    }

}
