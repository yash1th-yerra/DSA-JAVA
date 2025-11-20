package src.slidingwindow_twopointer.medium;

public class MaxConsecutiveOnes3 {




    static int maxConsecutiveOnesBrute(int[] arr,int  k){
        int maxLen = 0;
        int n = arr.length;
        for(int i=0;i<n;i++){
            int zeroCount = 0;
            for(int j=i;j<n;j++){
                if(arr[j]==0) zeroCount++;
                if(zeroCount>k) break;
                int len = j-i+1;
                maxLen = Math.max(maxLen,len);
            }

        }

        return maxLen;
    }

    static int maxConsecutiveOnesOptimal(int[] arr,int  k){
        int maxLen = 0;
        int n = arr.length;
        int left=0;
        int zeros=0;
        for(int right=0;right<n;right++){
            if(arr[right]==0) zeros++;
            while(zeros>k){
                if(arr[left]==0) zeros--;
                left++;
            }
            maxLen = Math.max(maxLen,right-left+1);
        }


        return maxLen;
    }


    static void main() {
        int[] input = {1,1,1,0,0,1,1,1,1,1,1};
        int k =1;
        System.out.println("max consecutive ones in arrays are: "+maxConsecutiveOnesBrute(input,k));
        System.out.println("max consecutive ones in arrays are: "+maxConsecutiveOnesOptimal(input,k));
    }
}
