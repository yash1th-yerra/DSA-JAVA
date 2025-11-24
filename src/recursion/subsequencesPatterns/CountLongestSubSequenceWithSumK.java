package src.recursion.subsequencesPatterns;

public class CountLongestSubSequenceWithSumK {


    static int func(int index,int[] arr,int target){
        if(target==0) return 1;
        if(index==arr.length || target<0) return 0;
        return func(index+1,arr,target-arr[index]) + func(index+1,arr,target);
    }
    static int countLongestSubsequenceWithSumK(int[] arr,int k){
        return func(0,arr,k);
    }

    static void main() {
        int[] arr = {4, 2, 10, 5, 1, 3};
        int target = 10;
        int target2 = 5;

        System.out.println(countLongestSubsequenceWithSumK(arr,target));
        System.out.println(countLongestSubsequenceWithSumK(arr,target2));
    }
}
