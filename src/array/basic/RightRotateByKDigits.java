package src.array.basic;

public class RightRotateByKDigits {
//    public static int[] rotate(int[] arr, int k) {          //Time Complexity - O(n)
//        int n = arr.length;                                 //Space Complexity - O(k)
//        if(n==0) return arr;
//        k = k%n;
//        if(k==0) return arr;
//        int[] temp = new int[k];                            //space
//        for(int i=n-k;i<n;i++){
//            temp[i-n+k] = arr[i];
//        }
//        for(int i=n-k-1;i>=0;i--){
//            arr[i+k] = arr[i];
//        }
//        for(int i=0;i<k;i++){
//            arr[i] = temp[i];
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
        reverse(arr,n-k,n-1);     // Time Complexity - O(k) + O(n) + O(n-k)
        reverse(arr,0,n-k-1);           // Space Complexity - O(1)
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
