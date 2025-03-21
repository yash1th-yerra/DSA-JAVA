package src.array.medium;

public class KadanesAlgo {

    //kadane Algorithm is defined to find maximum subarray sum.
    // sum of contiguous elements should be maximum

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        //BruteForce approach will need three loops
        // 1 loop to pick left element
        // 2 loop to pick right element
        // 3 loop to iterate over lefft and right
        // overall Time Complexity - O(n^3)
        // Not optimal

        int sum = 0;
        int max = nums[0];
        // Now maintain a pointer to calculate sum and chekc if it is maximum or not
        // if sum is negative make it 0 otherwise calculate max sum
        for(int i=0; i<nums.length; i++){
            sum+=nums[i];
            max = Math.max(max, sum);
            if(sum<0){
                sum=0;
            }
        }
        System.out.println(max);


    }


    /*
        follow up can how to print those subarrays
        for(i=0;i<nums.length;i++){
            sum+=a[i];
            if(sum>max){
                end = i;
                max = sum;
            }
            if (sum<0){
                start = i;
                sum = 0;
            }

            for(int j=start;j<end-1;j++){
                System.out.println(a[j]);
            }
    */
}