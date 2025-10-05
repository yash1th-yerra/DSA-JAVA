package src.sorting.brute;

public class InsertionSort {


    static int[] insertionSort(int[] arr){

        for(int i=0;i<=arr.length-1;i++){
            int j =i;
            while(j>0 && arr[j-1]>arr[j]){
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                j--;
            }

        }
        return arr;
    }


    static void main() {
        int[] arr = {4,2,7,1,5,7,1,5};

        int[] res = insertionSort(arr);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]+" ");
        }
    }
}
