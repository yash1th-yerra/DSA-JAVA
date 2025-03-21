package src.array.medium;

import java.util.Arrays;

public class NextPermuteInArray{
    // Next permutation in array -> 1. In a given array you will be given integers of size n
    // 2. you have to generate the next sequence to that sequence of elements in array (i.e., out of all permutations we have to get next permutation to current that exists as elements

    // arr = [1,2,3]
    /*      no .of permutations for an array of size n will be n!
    *       i.e. here in this case size = 3 , no.of permutations will be 3! = 6
    *       and the permutations of arr will be
    *       1. [1,2,3]
    *       2. [1,3,2]  --> this will be the next permutation for given array
    *       3. [2,1,3]
    *       4. [2,3,1]
    *       5. [3,1,2]
    *       6. [3,2,1]
    *
    *  */

    /* similarly for [3,1,2] the next permutation will be [3,2,1]
        for [3,2,1] -> [1,2,3] it should fallback to first permutation
     */

    // Brute Force Approach
    // 1. Generate all permuations of elements in the array in sorted array
    // 2. Do linear search for the element in array
    // 3. Go for next element after search
    // Time Complexity - O(N!*N)    traverse through permutations and compare it with the elements in the array



    // Optimal Approach
    /*  lets say we are searching for a word in dictionary how the words are permuted . by the longest fixed prefix
    *   if we apply same here then we can find the next permutation.
    *   fix the longest prefix such that at a point anyone element on its right should be greater than only next permutation will exist
    *   after that interchange elements further as example below.
    *   let's take an array [2,1,5,4,3,0,0].
    *   2>1<5>4>3>0>0
    *   here 1 is breakpoint consider it as i.
    *   then check for element from right which is greater that i. i.e closest greater of i (3 for 1).
    *   consider that element as j.
    *   so now 1 is i and 3 is j.
    *   replace i with j and sort the elements from i+1 to end.
    *   this will give the next permutation.
    *
    *   there will be few edge cases in this problem
    *   1. consider [5,4,3,2,1] here there is no breakpoint since it is last permutation in the array
    *   - in such cases just sort all elements and return
    *
    *
    *
    *
    * */

    public static int[] NextPermute(int[] arr){
        int index = -1;
        for(int i=arr.length-2;i>=0;i--){
            if(arr[i]<arr[i+1]){
                index = i;
                break;
            }



        }

        if(index==-1) {
            reverse(arr,0,arr.length-1);
            return arr;
        }

        for(int i=arr.length-1;i>index;i--){
            if(arr[i]>arr[index]){
               swap(arr,i,index);
                break;
            }
        }

        reverse(arr,index+1,arr.length-1);








        return arr;
    }
    private static void reverse(int[] arr,int i,int j){
        while(i<j){
            swap(arr,i,j);
            i++;
            j--;
        }
    }

    private static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }





    public static void main(String[] args) {
        int[] nums  = {2,1,5,4,3,0,0};

        //Optimal Approach
        nums=NextPermute(nums);
        for(int i:nums){
            System.out.print(i+" ");
        }



    }


}
