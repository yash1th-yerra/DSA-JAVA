package src.recursion.subsequencesPatterns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSetSum2 {
    static void printAns(List <List<Integer>>  ans) {
        System.out.println("The unique subsets are ");
        System.out.println(ans.toString().replace(","," "));
    }


    static void findSubsets(int index,int[] arr,List<Integer> curr,List<List<Integer>> ans){
        ans.add(new ArrayList<>(curr));
        for(int i=index;i<arr.length;i++){
            if(i!=index && arr[i]==arr[i-1]) continue;
            curr.add(arr[i]);
            findSubsets(index+1,arr,curr,ans);
            curr.remove(curr.size()-1);
        }
    }
    static List < List<Integer>>  subsetsWithDup(int[] arr){
        Arrays.sort(arr);
        List<List<Integer>> ansList = new ArrayList<>();
        findSubsets(0, arr, new ArrayList<>(), ansList);
        return ansList;
    }

    static void main() {
        int nums[]={1,2,2};
        List < List<Integer>> ans = subsetsWithDup(nums);
        printAns(ans);
    }
}
