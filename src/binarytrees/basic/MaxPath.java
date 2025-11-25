package src.binarytrees.basic;

public class MaxPath {

    public static int maxPath(Node root,int[] maxi){
        if(root==null) return 0;
        //get maxpath from left childs
        int leftSum = maxPath(root.left,maxi);
        //get maxpath from right childs
        int rightSum = maxPath(root.right,maxi);
        // update maxSum
        maxi[0] = Math.max(maxi[0],leftSum+rightSum+root.data);
        // return maxPath for both parts.
        return root.data + Math.max(leftSum,rightSum);

    }

    static int maxSum(Node root){
        int[] maxi=new int[1];
        maxPath(root,maxi);
        return maxi[0];
    }


    static void main() {
        Node root = new Node(-10);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);


        System.out.println(
                "Maximum Path Sum: " +
                        maxSum(root)
        );
    }

}
