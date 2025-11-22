package src.slidingwindow_twopointer.medium;

public class MaxPointsFromCards {



    static int maxScore(int[] arr,int k){
        int n = arr.length;
        int maxSum = 0;
        for(int i=0;i<=k;i++){
            int tempSum = 0;
            for(int j=0;j<i;j++){
                tempSum+=arr[j];

            }

            for(int j=0;j<k-i;j++){
                tempSum+=arr[n-1-j];
            }

            maxSum = Math.max(maxSum,tempSum);
        }
        return maxSum;
    }

    static int maxScoreOptimal(int[] arr,int k){
        int n = arr.length;
        int total = 0;

        for(int i=0;i<k;i++){
            total+=arr[i];
        }

        int maxPoints = total;
        for(int i=0;i<k;i++){
            total-=arr[k-i-1];
            total+=arr[n-i-1];
            maxPoints = Math.max(maxPoints,total);
        }
        return maxPoints;
    }

    static void main() {
        int[] arr = {1,2,3,4,5,6,1};
        int k = 4;
        System.out.println(maxScore(arr,k));
        System.out.println(maxScore(arr,k));
    }

}
