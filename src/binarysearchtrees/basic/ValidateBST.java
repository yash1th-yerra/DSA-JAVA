package src.binarysearchtrees.basic;

public class ValidateBST {
    // to validate a binary search tree, we must have a range like min and max

    static boolean isValid(Node root,long min,long max){
        if(root==null) return true;
        if(root.data>=max || root.data<=min) return false;
        return isValid(root.left,min,root.data) && isValid(root.right,root.data,max);
    }

    static boolean isValid(Node root){
        return isValid(root,Long.MIN_VALUE,Long.MAX_VALUE);

    }

}
