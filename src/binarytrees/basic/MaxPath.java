package src.binarytrees.basic;

public class MaxPath {

    public static int maxPath(Node root,int maxi){
        if(root==null) return 0;
        int leftSum = maxPath(root.left,maxi);
        int rightSum = maxPath(root.right,maxi);
        maxi = Math.max(maxi,leftSum+rightSum+root.data);
        return root.data + Math.max(leftSum,rightSum);

    }
}
