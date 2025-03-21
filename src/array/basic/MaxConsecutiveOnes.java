package src.array.basic;

public class MaxConsecutiveOnes {
    // Approach
    /*  Two Pointer
    *   1. take two variables counter and max and initialize with 0
    *   2. run loop from 0 to n-1
    *   3. check if arr[i]==1 if so increment count by 1 else make count =0
    *   4. after each iteration compare count with max
    *   5. continue till end and return max
    * */

    public static int bruteMaxConsOnes(int[] arr){              //Time Complexity = O(N)
        int max = 0;                                            //Space Complexity - O(1)
        int count = 0;
        for(int i= 0;i<arr.length;i++){
            if(arr[i]==1){
                count+=1;
            }
            else{
                count =0;
            }
            max = Math.max(max,count);
        }
        return max;
    }






    public static void main(String[] args) {

        int[] arr = {1,1,0,1,1,1,1,0,1,1,1};

        int count = bruteMaxConsOnes(arr);
        System.out.println(count);

    }
}
