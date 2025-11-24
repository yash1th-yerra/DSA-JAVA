package src.recursion.subsequencesPatterns;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {


    static void findCombinations(int sum,int last, List<Integer> curr,int k , List<List<Integer>> ans){
        if(sum==0 && curr.size()==k){
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(sum<0 && curr.size()>k) return;
        for(int i=last;i<=9;i++){
            if(i<=sum){
                curr.add(i);
                findCombinations(sum-i,i+1,curr,k,ans);
                curr.remove(curr.size()-1);
            }else break;
        }
    }


    static  List<List<Integer>> combinationSum3(int k,int n){
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        findCombinations(n,1,curr,k,ans);
        return ans;
    }
    static void main() {

        int k = 3; // Number of elements in the combination
        int n = 7; // Target sum
        List<List<Integer>> result = combinationSum3(k, n);

        // Print the result
        for (List<Integer> combination : result) {
            for (int num : combination) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
