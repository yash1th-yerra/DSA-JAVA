package src.recursion.subsequencesPatterns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {


    static void findCombinations(int index, int[] arr, int target, List<List<Integer>> ans , List<Integer> curr){

        if(target==0) {
            ans.add(new ArrayList<>(curr));
            return;
        }


        for(int i=index;i<arr.length;i++){
            if(i>index && arr[i]==arr[i-1]) continue;
            if(arr[i]>target) break;
            curr.add(arr[i]);
            findCombinations(i+1,arr,target-arr[i],ans,curr);
            curr.remove(curr.size() - 1);

        }

    }

    static List<List<Integer>> combinationSum2(int[] arr,int target){
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        findCombinations(0,arr, target,ans,new ArrayList<>());
        return ans;
    }

    static void main() {
        int[] v ={10,1,2,7,6,1,5};
        int target=8;
        List < List < Integer >> comb = combinationSum2(v,target);
        System.out.println(comb.toString().replace(",", " "));
    }
}
