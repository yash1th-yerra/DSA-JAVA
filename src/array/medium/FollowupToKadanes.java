package src.array.medium;

public class FollowupToKadanes {

    public static void main(String[] args) {

            int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

            int sum = 0;
            int max = nums[0];
            int start = 0;
            int ansStart = -1;
            int ansEnd = -1;
            // Now maintain a pointer to calculate sum and chekc if it is maximum or not
            // if sum is negative make it 0 otherwise calculate max sum
            for(int i=0; i<nums.length; i++){
                if(sum==0) start=i;
                sum+=nums[i];
                if(sum>max){

                    max = Math.max(max, sum);
                    ansStart = start;
                    ansEnd = i;
                }
                if(sum<0){
                    sum=0;
                }
            }
            System.out.println(max);


            for(int i=ansStart; i<=ansEnd; i++){
                System.out.print(nums[i]+" ");
            }




    }
}
