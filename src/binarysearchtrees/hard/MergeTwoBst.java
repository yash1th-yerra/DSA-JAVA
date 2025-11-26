package src.binarysearchtrees.hard;

import java.util.ArrayList;
import java.util.List;

public class MergeTwoBst {


    static void inOrderTraversal(Node root, List<Integer> inOrder){
        if(root==null) return;
        inOrderTraversal(root.left,inOrder);
        inOrder.add(root.data);
        inOrderTraversal(root.right,inOrder);
    }

    static List<Integer> mergeArrays(List<Integer> arr1, List<Integer> arr2){
        List<Integer> merged = new ArrayList<>();
        int i=0,j=0;
        while(i<arr1.size() && j<arr2.size()){
            if(arr1.get(i) < arr2.get(j)) merged.add(arr1.get(i++));
            else merged.add(arr2.get(j++));
        }

        while(i<arr1.size()){
            merged.add(arr1.get(i++));
        }
        while(j<arr2.size()){
            merged.add(arr2.get(j++));
        }
        return merged;
    }


    static List<Integer> mergeBsts(Node root1,Node root2){
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        inOrderTraversal(root1,arr1);
        inOrderTraversal(root2,arr2);
        return mergeArrays(arr1,arr2);
    }
}
