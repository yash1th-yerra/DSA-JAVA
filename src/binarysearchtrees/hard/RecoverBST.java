package src.binarysearchtrees.hard;

public class RecoverBST {
    // given root with two nodes swapped their positions mistakenly . so we need to recover
    // the binary search tree with correct node positions while keeping the structure of tree intact.

    private static  Node first;
    private static Node second;
    private static Node prev;

    static void inOrder(Node root){
        if(root==null) return;
        inOrder(root.left);
        if(prev!=null && root.data<prev.data){
            if(prev==null){
                first = prev;
                second = root;
            }else second = root;
        }
        prev = root;
        inOrder(root.right);
    }

    static void recoverTree(Node root){
        inOrder(root);
        int temp = first.data;
        first.data = second.data;
        second.data = temp;
    }



}
