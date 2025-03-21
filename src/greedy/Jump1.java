package src.greedy;

public class Jump1 {

    // will be given an array nums with each element represents maximum we can jump to index i
    // nums[i] is not greater than size of array if so you can return true;
    // so in this we can jump to maximum. also we can make minimal steps upto range of maximum
    // so if take minimal steps if it get element contains maxjumps greater than array size return true
    // else find maximum you can reach using value inside it
    // if i+nums[i] =1 and nums[i+1] = 0 then we can't reach nums[i+2] because max we can reach is 1 and next is 0
    // so if i > maximum we can reach then return false



    public static boolean  canJump(int[] nums) {
        int maxInd =0;
        for(int i=0;i<nums.length;i++){
            if(i>maxInd) return false;
            maxInd = Math.max(maxInd,i+nums[i]);
            if(maxInd>nums.length) break;
        }
        return true;
    }


    public static void main(String[] args) {

    }
}
