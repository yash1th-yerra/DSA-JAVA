package src.sorting.brute;

public class SelectionSort {


    static int[] selectionSort(int[] arr){

        for(int i=0;i<arr.length;i++){
            int mini = i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[mini]){
                    mini = j;
                }
            }
            int temp = arr[mini];
            arr[mini] = arr[i];
            arr[i] = temp;
        }


        return arr;
    }


    static void main() {
        int[] arr = {4,2,7,1,5,7,1,5};

        int[] res = selectionSort(arr);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]+" ");
        }
    }


}
