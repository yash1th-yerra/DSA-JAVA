package src.array.basic;

public class LeftRotateByKDigits {
//    public static int[] rotate(int[] arr, int k) {          //Time Complexity - O(n)
//        int n = arr.length;                                 //Space Complexity - O(k)
//        if(n==0) return arr;
//        k = k%n;
//        if(k==0) return arr;
//        int[] temp = new int[k];                            //space
//        for(int i=0;i<k;i++){
//            temp[i] = arr[i];
//        }
//        for(int i=0;i<n-k;i++){
//            arr[i] = arr[i+k];
//        }
//        for(int i=n-k;i<n;i++){
//            arr[i] = temp[i-n+k];
//        }
//
//        return arr;
//    }

    public static void reverse(int[] arr,int start,int end){
        while(start<end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp ;
            start++;
            end--;
        }
    }


    public static int[] rotate(int[] arr,int n,int k){
        reverse(arr,0,k-1);     // Time Complexity - O(k) + O(n) + O(n-k)
        reverse(arr,k,n-1);           // Space Complexity - O(1)
        reverse(arr,0,n-1);
        return arr;


    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int k = 2;
        int n = arr.length;
        int[] arr1 = rotate(arr,n,k);
        for(int i=0;i<arr1.length;i++){
            System.out.println(arr1[i]);
        }


    }
}
