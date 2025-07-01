package src.array.hard;

import src.heaps.Main;

import java.util.ArrayList;

public class ReversePairs {

    // almost similar to count inversion pairs
    // reverse pair is just a condition change
    // where arr[i] > 2*arr[j] then it is reverse pair where i<j




        private int countAndMerge(int[] nums, int left, int mid, int right) {
            int count = 0;
            int j = mid + 1;
            for (int i = left; i <= mid; i++) {
                while (j <= right && nums[i] > 2L * nums[j]) j++;
                count += j - (mid + 1);
            }

            // Merge the two sorted halves
            int[] temp = new int[right - left + 1];
            int i = left, k = mid + 1, m = 0;
            while (i <= mid && k <= right) {
                if (nums[i] <= nums[k]) {
                    temp[m++] = nums[i++];
                } else {
                    temp[m++] = nums[k++];
                }
            }
            while (i <= mid) temp[m++] = nums[i++];
            while (k <= right) temp[m++] = nums[k++];

            System.arraycopy(temp, 0, nums, left, temp.length);
            return count;
        }


        public int reversePairs(int[] nums) {
            if(nums==null || nums.length<2) return 0;
            return mergeSortAndCount(nums,0,nums.length-1);
        }

        public int mergeSortAndCount(int[] nums,int left,int right){
            if(left>=right) return 0;
            int mid = left+(right-left)/2;
            int count = mergeSortAndCount(nums,left,mid)+mergeSortAndCount(nums,mid+1,right);
            count += countAndMerge(nums, left, mid, right);
            return count;
        }




}
