package src.recursion.subsequencesPatterns;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum1 {


//    Given an array of distinct integers and a target, you have to return the list of all unique combinations where the chosen numbers sum to target. You may return the combinations in any order.
//    The same number may be chosen from the given array an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.
//    It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

    // Note : Same number can be chosen multiple times.

    static void findCombinations(int index,int[] arr,int target,List<List<Integer>> ans , List<Integer> curr){
        if(index==arr.length){
            if(target==0) ans.add(new ArrayList<>(curr));
            return;
        }

        if(arr[index]<=target){
            curr.add(arr[index]);
            findCombinations(index,arr,target-arr[index],ans,curr);
            curr.removeLast();
        }
        findCombinations(index+1,arr,target,ans,curr);
    }

    static List<List<Integer>> combinationSum(int[] arr,int target){
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(0,arr,target,ans,new ArrayList<>());
        return ans;
    }
    static void main() {
        int arr[] = {2,3,6,7};
        int target = 7;
        List <List< Integer >> ls = combinationSum(arr, target);
        System.out.println("Combinations are: ");
        for (int i = 0; i < ls.size(); i++) {
            for (int j = 0; j < ls.get(i).size(); j++) {
                System.out.print(ls.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }



}
