package src.array.hard;

import java.util.Arrays;

public class MergeSortedArrays {

    // Merge Sorted Arrays with extra space
    //Given two sorted arrays arr1[] and arr2[] of sizes n and m in non-decreasing order. Merge them in sorted order. Modify arr1 so that it contains the first N elements and modify arr2 so that it contains the last M elements.
    /*

    Example 1:

        Input:
        n = 4, arr1[] = [1 4 8 10]
        m = 5, arr2[] = [2 3 9]

        Output:
        arr1[] = [1 2 3 4]
        arr2[] = [8 9 10]

        Explanation:
        After merging the two non-decreasing arrays, we get, 1,2,3,4,8,9,10.

        Example2:

        Input:
        n = 4, arr1[] = [1 3 5 7]
        m = 5, arr2[] = [0 2 6 8 9]

        Output:
        arr1[] = [0 1 2 3]
        arr2[] = [5 6 7 8 9]

        Explanation:
        After merging the two non-decreasing arrays, we get, 0 1 2 3 5 6 7 8 9.
    */

    private static void bruteMerge(long[] arr1, long[] arr2, int n, int m) {
        // bruteforce approach includes extra space
        long[] ans = new long[n+m];
        int left = 0;
        int right = 0;
        int index=0;
        while(left<n && right<m){
            if(arr1[left]<=arr2[right]){
                ans[index++] = arr1[left++];

            }else{
                ans[index++] = arr2[right++];
            }
        }
        while(left<n){
            ans[index++] = arr1[left++];

        }
        while(right<m){
            ans[index++] = arr2[right++];
        }
        for(int i=0;i<n+m;i++){
            if(i<n) arr1[i] = ans[i];
            else arr2[i-n] = ans[i];
        }
    }


    private static void optimalMerge1(long[] arr1, long[] arr2, int n, int m) {

        int left = n-1;
        int right =0;
        while(left>=0 && right<m){
            if(arr1[left]>=arr2[right]){
                long temp = arr1[left];
                arr1[left] = arr2[right];
                arr2[right] = temp;
                right++;
                left--;
            }
            else{
                break;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }

    public static void swapIfGreater(long[] arr1, long[] arr2, int ind1, int ind2) {
        if (arr1[ind1] > arr2[ind2]) {
            long temp = arr1[ind1];
            arr1[ind1] = arr2[ind2];
            arr2[ind2] = temp;
        }
    }


    // Shell Sort technique
    // use gap and within that gap if we found anything lesser on right side ,swap
    // else continue to find lesser element on right side
    private static void optimalMerge2(long[] arr1, long[] arr2, int n, int m) {
        int len = n + m;
        int gap = (len / 2) + (len % 2); // initial gap

        while (gap > 0) {
            int left = 0;
            int right = left + gap;

            while (right < len) {
                if (left < n && right >= n) {
                    // comparing arr1[left] and arr2[right - n]
                    swapIfGreater(arr1, arr2, left, right - n);
                } else if (left >= n) {
                    // both in arr2
                    swapIfGreater(arr2, arr2, left - n, right - n);
                } else {
                    // both in arr1
                    swapIfGreater(arr1, arr1, left, right);
                }
                left++;
                right++;
            }

            // reduce the gap
            if (gap == 1) gap = 0;
            else gap = (gap / 2) + (gap % 2);
        }
    }

    public static void main() {
        long[] arr1 = {1, 4, 8, 10};
        long[] arr2 = {2, 3, 9};
        int n = 4, m = 3;
        optimalMerge2(arr1, arr2, n, m);
        System.out.println("The merged arrays are:");
        System.out.print("arr1[] = ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.print("\narr2[] = ");
        for (int i = 0; i < m; i++) {
            System.out.print(arr2[i] + " ");
        }
        System.out.println();

    }
}
