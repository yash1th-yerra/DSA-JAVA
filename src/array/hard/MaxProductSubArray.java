package src.array.hard;

public class MaxProductSubArray {

    // Problem Statement: Given an array that contains both negative and positive integers. Find the maximum product subarray
    /*
        Example:
        input: nums = [1,2,3,4,5,0]
        output : 120
        Explanation: In the given array , we can see 1 * 2 * 3 * 4 * 5 = 120
        Example 2:
        Input: nums = [1,2,-3,0,-4,-5]
        Output : 20
        Explanation: In the given array, we can see (-4)×(-5) gives maximum product value.
    */

    // BruteForce Approach
    // Run two loops for starting and ending points
    // take prod variable and run another loop for window and do prod of elements within that range
    // compare max for each window and return maximum out of it
    // Time Complexity - O(N^3)
    // Space Complexity - O(1)
    private static int bruteMaxProductSubArray(int[] nums){
        int result = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                int prod = 1;
                for(int k=i;k<=j;k++){
                    prod = prod * nums[k];
                }
                result = Math.max(result,prod);
            }
        }
        return result;
    }

    // Better Approach
    // instead of three loops just take two loops while selecting start and end points we calculate prod and compare it with maximum
    // Time  Complexity - O(N^2)
    // Space Complexity - O(1)
    private static int betterMaxProductSubArray(int[] arr){
        int result = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            int prod = arr[i];
            for(int j=i+1;j<arr.length;j++){
                result = Math.max(result,prod);
                prod = prod * arr[j];
            }
            result = Math.max(result,prod);
        }

        return result;
    }

    // Optimal Approach
    // we will declare two variables pre and suff
    // each do product from diff ends
    // we'll compare max out of them and previous answer to get maximum product subarray
    // if we encouter 0 in any (pre or suff) we'll set it to 1 since it is new starting point of subarray since we can't have 0 in max prod subarray
    // Time Complexity - O(N)
    // Space Complexity - O(1)
    private static int optimalMaxProductSubArray(int[] arr){
        int result = Integer.MIN_VALUE;
        int pre=1,suff=1;
        for(int i=0;i<arr.length;i++){
            if(pre==0) pre=1;
            if(suff==0) suff=1;
            pre = pre * arr[i];
            suff = suff * arr[arr.length-i-1];
            result = Math.max(result,Math.max(pre,suff));
        }
        return result;
    }


    // another Optimal approach that i can think of is kadane's algorithm
    // so calculate max prod and min prod at each point
    // compare that with current element and also compare that entirely with max prod i.e. result
    // once you got the maximum we store it in result variable

    // Why normal kadane doesn't work?
    // because in max sum subarray any negative or 0 can only add up to existing but in product it will impact previous answer completely
    // so we need to maintain both min and max subarray products incase if min prod may flip to max at end . so that's why....
    // Time Complexity - O(N)
    // Space Complexity - O(1)

    private static int optimalMaxProductSubArray2(int[] arr){
        int result = arr[0],prod1=arr[0],prod2=arr[0];
        for(int i=1;i<arr.length;i++){
            int temp = Math.max(arr[i],Math.max(arr[i]*prod1,prod2*arr[i]));
            prod2 = Math.min(arr[i],Math.min(arr[i]*prod1,arr[i]*prod2));
            prod1 = temp;
            result = Math.max(result,prod1);
        }
        return result;

    }





    public static void main(String[] args) {
        int nums[] = {1,2,-3,0,-4,-5};
//        int answer = bruteMaxProductSubArray(nums);
//        int answer = betterMaxProductSubArray(nums);
//        int answer = optimalMaxProductSubArray(nums);
        int answer = optimalMaxProductSubArray2(nums);
        System.out.print("The maximum product subarray is: "+answer);
    }
}
