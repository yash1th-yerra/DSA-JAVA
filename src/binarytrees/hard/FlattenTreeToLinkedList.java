package src.binarytrees.hard;

public class FlattenTreeToLinkedList {
    //recursive
    static Node prev = null;
    static void flatternRecursive(Node root){
        if(root==null) return;
        flatternRecursive(root.right);
        flatternRecursive(root.right);
        root.right = prev;
        root.left = null;
        prev = root;


    }

    static void flattenMorris(Node node){
        Node curr = node;
        while(curr!=null){
            if(curr.left!=null){
                Node prev = curr.left;
                while(prev.right!=null){
                    prev = prev.right;
                }
                prev.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }
}
