package src.array.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UnionArray {

//    public static List<Integer> hashMerge(int[] arr1, int[] arr2) {
//        HashMap<Integer, Integer> freq = new HashMap<>();
//        ArrayList<Integer> union = new ArrayList<>();
//        for (int i = 0; i < arr1.length; i++) {                 // Time Complexity - O((m+n)log(m+n)
//                                                                // Space Complexity - O(m+n)   which is not optimal
//            freq.put(arr1[i], freq.getOrDefault(arr1[i], 0) + 1);
//        }
//        for (int i = 0; i < arr2.length; i++) {
//            freq.put(arr2[i], freq.getOrDefault(arr2[i], 0) + 1);
//        }
//        for(int i:freq.keySet()){
//            union.add(i);
//        }
//        return union;
//    }



    public static List<Integer> pointerMerge(int[] arr1, int[] arr2) {
        ArrayList<Integer> union = new ArrayList<>();
        int i=0,j=0;
        while(i<arr1.length && j<arr2.length){          //Time Complexity - O(m+n)          assuming n = arr1.length, m= arr2.length
            if(arr1[i]<arr2[j]){
                if(union.isEmpty()|| union.getLast()!=arr1[i]){
                    union.add(arr1[i]);
                }
                i++;
            }
            else if(arr1[i]>arr2[j]){
                if(union.isEmpty() || union.getLast()!=arr2[j]){
                    {
                        union.add(arr2[j]);

                    }
                    j++;
                }
            }
            else{
                if(union.isEmpty() || union.getLast()!=arr1[i]){
                    union.add(arr1[i]);
                }
                i++;
                j++;
            }
        }
        while(i<arr1.length){                       //Time Complexity - O(n)
            if(union.getLast()!=arr1[i]){
                union.add(arr1[i]);
            }
            i++;
        }
        while(j<arr2.length){                       //TimeComplexity - O(m)
            if(union.getLast()!=arr2[j]){
                union.add(arr2[j]);
            }
            j++;
        }
        return union;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {3, 4, 6, 7, 8};

        //Naive Approach using hashmap
//        List<Integer> mergedArray = hashMerge(arr1, arr2);


        // Two Pointer Approach
        List<Integer> mergedArray = pointerMerge(arr1,arr2);

        System.out.println(mergedArray);


    }
}
