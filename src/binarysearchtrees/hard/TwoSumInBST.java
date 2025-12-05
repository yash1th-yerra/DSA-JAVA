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
    // using BST Iterator
    static boolean twoSumInBSTOptimal(Node root,int sum){
        if(root==null) return false;

        BSTIterator l = new BSTIterator(root,false);
        BSTIterator r = new BSTIterator(root,true);

        int i = l.next();
        int j = r.next();
        while(i<j){
            if(i+j==sum) return true;
            else if(i+j<sum) i = l.next();
            else j = r.next();
        }
        return false;
    }

}
