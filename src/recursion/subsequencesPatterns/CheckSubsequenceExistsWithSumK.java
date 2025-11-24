package src.recursion.subsequencesPatterns;

public class CheckSubsequenceExistsWithSumK {

    static boolean isExists(int index,int [] arr,int target){
        if(target==0) return true;
        if(target<0) return false;
        if(index==arr.length) return target==0;
        return isExists(index+1,arr,target-arr[index]) || isExists(index+1,arr,target);
    }
    static boolean isSubsequenceExistsWithSumK(int[] arr,int k){
        return isExists(0,arr,k);
    }

    static void main() {
        int[] arr = {4, 2, 10, 5, 1, 3};
        int k = 30;
        System.out.println(isSubsequenceExistsWithSumK(arr,k));
    }
}
