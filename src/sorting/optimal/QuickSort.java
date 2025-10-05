package src.sorting.optimal;

public class QuickSort {


    private static int partition(int[] arr,int low,int high){
        int pivot = arr[low];
        int i=low;
        int j= high;
        while(i<j){
            while(arr[i]<=pivot && i<=high-1) i++;
            while(arr[j]>pivot && j>=low+1) j--;

            if(i<j){
                int temp = arr[i];
                arr[i] =arr[j];
                arr[j] = temp;
            }


        }
        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;
        return j;
    }




    private static void quickSort(int[] arr,int low,int high){
        if(low>=high) return ;
        int pIndex = partition(arr,low,high);
        quickSort(arr,low,pIndex-1);
        quickSort(arr,pIndex+1,high);
    }


    public static void main() {
        int[] arr = {4,2,7,1,5,7,1,5};
        quickSort(arr,0,arr.length-1);

//        int[] res =
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
