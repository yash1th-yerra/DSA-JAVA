package src.recursion.subsequencesPatterns;

import java.util.ArrayList;
import java.util.Collections;

public class SubSetSum1 {


    static void sumSubsetHelper(int index,int sum,ArrayList<Integer> arr,int n , ArrayList<Integer> sumSubset){
        if(index==arr.size()){
            sumSubset.add(sum);
            return;
        }

        sumSubsetHelper(index+1,sum+arr.get(index),arr,n,sumSubset);
        sumSubsetHelper(index+1,sum,arr,n,sumSubset);
    }
    static ArrayList<Integer> subsetSums1(ArrayList<Integer> arr,int n ){
        ArrayList<Integer> sumSubset = new ArrayList<>();
        sumSubsetHelper(0,0,arr,n,sumSubset);
        Collections.sort(sumSubset);
        return sumSubset;
    }

    static void main() {
        ArrayList < Integer > arr = new ArrayList < > ();
        arr.add(3);
        arr.add(1);
        arr.add(2);
        ArrayList < Integer > ans = subsetSums1(arr, arr.size());
        Collections.sort(ans);
        System.out.println("The sum of each subset is ");
        for (int i = 0; i < ans.size(); i++)
            System.out.print(ans.get(i) + " ");
    }
}
