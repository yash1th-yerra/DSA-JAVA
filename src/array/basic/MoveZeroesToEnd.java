package src.array.basic;

public class MoveZeroesToEnd {


    // let's say arr = {1,2,0,3,5,0,2,6,2,0,2}
    // output should be = {1,2,3,5,2,6,2,2,0,0,0}

    // Naive Approach
    // first collect all non zeroes into temp array
    // then add zeroes at the end of that temp array till end of arr length

//    public static int[] bruteMoveZeroes(int[] nums){  // Overall Time Complexity - O(N)
//        int[] temp = new int[nums.length];            // Overall Space Complexity - O(N)
//        int j=0;
//        for(int i=0;i<nums.length;i++){               // Time Complexity - O(n-x) if x is no.of zeroes
//            if(nums[i]!=0){                           // space Complexity- O(n-x)
//                temp[j] = nums[i];
//                j++;
//            }
//        }
//        for(int i=j;i<nums.length;i++){               // Time Complexity - O(x)
//            temp[i] = 0;                              // Space Complexity - O(x)
//        }
//
//        for(int i=0;i<nums.length;i++){               // Time Complexity  - O(N)
//            nums[i] = temp[i];                       // Space Complexity  - O(N)
//        }
//
//        return nums;
//    }

    // Optimal Approach

    /*
    *   1. take one pointer j and traverse until first zero occurs
    *   2. then take another i = j+1 and check if element at i
    *   3. if element at i is non zero then swap it with element at j and increment j
    *   4. at first step if there is no zero in array return original array
    *   5. else continue till end.
    * */


    public static int[] optimalMoveZeroes(int[] nums){          // Overrall Time Complexity = O(nums.length)
        int j=-1;                                               // Overall Space Complexity = O(1)
        for(int i=0;i<nums.length;i++){         // Time Complexity - O(nums.length)
            if(nums[i]==0){
                j = i;
                break;
            }
        }

        if(j==-1){
            return nums;
        }

        for(int i=j+1;i<nums.length;i++){           // Time Complexity - O(nums.length-j-1)
            if(nums[i]!=0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }

        return nums;
    }

    public static void main(String[] args) {

        int[] nums  = {1,2,0,3,5,0,2,6,2,0,2};

//        nums = bruteMoveZeroes(nums);

        nums = optimalMoveZeroes(nums);


        for(int i:nums){
            System.out.print(i+" ");
        }


    }
}
