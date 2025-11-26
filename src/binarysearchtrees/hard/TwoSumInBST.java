package src.binarysearchtrees.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TwoSumInBST {

    //BruteForce

    static void inOrderTraversal(Node root, List<Integer> inOrder){
        if(root==null) return;
        inOrderTraversal(root.left,inOrder);
        inOrder.add(root.data);
        inOrderTraversal(root.right,inOrder);

    }

    static boolean isTwoSumExists(List<Integer> inOrder,int k){
        int left =0,right = inOrder.size()-1;
        while(left<=right){
            if(inOrder.get(left)+inOrder.get(right)==k) return true;
            else if(inOrder.get(left)+inOrder.get(right)<k) left++;
            else right++;
        }
        return false;
    }


    static boolean twoSumInBST(Node root,int k){
        List<Integer> inOrder = new ArrayList<>();
        inOrderTraversal(root,inOrder);
        Collections.sort(inOrder);
        return isTwoSumExists(inOrder,k);
    }



    // Optimal
    // init two pointers

}
