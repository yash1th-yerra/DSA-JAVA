package src.sorting.brute;

public class BubbleSort {



    static int[] bubbleSort(int[] arr){


        for(int i=arr.length-1;i>=0;i--){
            int didSwap = 0;
            for(int j=0;j<=i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1] ;
                    arr[j+1] = temp;
                    didSwap=1;
                }
            }
            if (didSwap==0) {
                System.out.println("Breaking Out");
                break;
            }
        }



        return arr;
    }

    static void main() {
        int[] arr = {4,2,7,1,5,7,1,5};
//        int[] arr = {1,2,3,4,5};

        int[] res = bubbleSort(arr);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]+" ");
        }
    }

}
