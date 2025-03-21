package src.array.medium;

public class ArrangePosNeg {


//    public static int[] arrangeBrute(int[] arr){
//        int[] pos = new int[arr.length];
//        int[] neg = new int[arr.length];
//        int i=0;
//        int j=0;
//        for(int k=0;k<arr.length;k++){
//            if(arr[k]<0){
//                neg[j]=arr[k];
//                j++;
//            }else{
//                pos[i]=arr[k];
//                i++;
//            }
//        }
//        for(int k=0;k<arr.length/2;k++){
//            arr[2*k] = pos[k];
//            arr[2*k+1] = neg[k];
//
//        }
//        return arr;
//    }

    public static int[] optimiseArrangeBrute(int[] arr){

        int[] ans = new int[arr.length];
        int posIndex = 0;
        int negIndex = 1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<0){
                ans[negIndex] = arr[i];
                negIndex+=2;
            }
            else{
                ans[posIndex] = arr[i];
                posIndex+=2;
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        int[] arr = {-1, 2, 4, -5, 7, -8};

        //BruteForce approach
//        int[] res = arrangeBrute(arr);      // Time Complexity - O(2*n)         // Space Complexity - O(n)
        int[] res = optimiseArrangeBrute(arr);  // Time Complexity - O(n)       // Space Complexity - O(n)
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+" ");
        }

    }
}
