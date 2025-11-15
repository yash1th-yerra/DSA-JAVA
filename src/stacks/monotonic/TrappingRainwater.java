package src.stacks.monotonic;

public class TrappingRainwater {


    static int trapRainWaterBrute(int[] arr){
        int n = arr.length;
        int waterTrapped=0;
        for(int i=0;i<n;i++){
            int j=i;
            int leftMax=0,rightMax=0;
            while(j>=0){
                leftMax = Math.max(leftMax,arr[j]);
                j--;
            }
            j=i;
            while(j<n){
                rightMax = Math.max(rightMax,arr[j]);
                j++;
            }
            waterTrapped+=Math.min(leftMax,rightMax)-arr[i];
        }
        return waterTrapped;
    }

    static int trapWaterBetter(int[] arr){
        int waterTrapped=0;
        int n = arr.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        prefix[0] = arr[0];
        for(int i=1;i<n;i++){
            prefix[i] = Math.max(prefix[i-1],arr[i]);
        }
        suffix[n-1] = arr[n-1];
        for(int i=n-2;i>=0;i--){
            suffix[i] = Math.max(suffix[i+1],arr[i]);
        }

        for(int i=0;i<n;i++){
            waterTrapped+=Math.min(prefix[i],suffix[i]) - arr[i];
        }

        return waterTrapped;
    }

    static int trapWaterOptimal(int[] arr){
        int n = arr.length;
        int left=0 , right= n-1;

        int maxLeft = 0 , maxRight = 0;
        int res=0;
        while(left<=right){
            if(arr[left]<=arr[right]){
                if(arr[left]>=maxLeft) maxLeft = arr[left];
                else res+=maxLeft-arr[left];
                left++;
            }else{
                if(arr[right]>=maxRight) maxRight = arr[right];
                else res+=maxRight-arr[right];
                right--;
            }
        }
        return res;
    }
    static void main() {
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("The trapped water is " + trapRainWaterBrute(arr));
        System.out.println("The trapped water is " + trapWaterBetter(arr));
        System.out.println("The trapped water is " + trapWaterOptimal(arr));
    }
}
