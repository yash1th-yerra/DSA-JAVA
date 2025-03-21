package src.array.medium;

public class Sort012 {

    public static void main(String[] args) {
        int[] nums = {0,1,2,0,2,1,1,0,1};
        // First Approach is Just sort an array

        // Second Approach make count of each number and fill them based on count


        // Third approach is using pointers.

        int low = 0,mid=0,high=nums.length-1;
        while(mid<=high){
            if(nums[mid]==0){
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            }
            else if(nums[mid]==1) mid++;
            else{
                int temp = nums[high];
                nums[high] = nums[mid];
                nums[mid] =temp;
                high--;
            }
        }

        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]);
        }
    }
}
