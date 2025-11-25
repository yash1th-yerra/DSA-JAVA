package src.binarytrees.hard;

import java.util.HashMap;
import java.util.Map;

public class ConstructFromInAndPost {

    static Node buildTree(int[] inOrder,int inStart,int inEnd,int[] postOrder,int postStart,int postEnd,Map<Integer,Integer> inMap){
        if(inStart>inEnd || postStart>postEnd) return null;
        Node root = new Node(postOrder[postEnd]);
        int inRoot = inMap.get(root.data);
        int numsLeft = inRoot-inStart;
        root.left = buildTree(inOrder,inStart,inRoot-1,postOrder,postStart,postStart+numsLeft-1,inMap);
        root.right = buildTree(inOrder,inRoot+1,inEnd,postOrder,postStart+numsLeft,postEnd-1,inMap);
        return root;

    }
    static Node constructTree(int[] inOrder,int[] postOrder){
        if(inOrder==null || postOrder==null || inOrder.length!=postOrder.length) return null;
        Map<Integer,Integer> inMap = new HashMap<>();
        for(int i=0;i<inOrder.length;i++){
            inMap.put(inOrder[i],i);
        }
        Node root = buildTree(inOrder,0,inOrder.length-1,postOrder,0,postOrder.length-1,inMap);
        return root;

    }

    public static void printInorder(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        printInorder(root.left);
        printInorder(root.right);
    }

    public static void main(String[] args) {
        int[] inorder = {40, 20, 50, 10, 60, 30};
        int[] postorder = {40, 50, 20, 60, 30, 10};


        Node root = constructTree(inorder, postorder);

        System.out.println("Inorder of Unique Binary Tree Created:");
        printInorder(root);
    }
}
