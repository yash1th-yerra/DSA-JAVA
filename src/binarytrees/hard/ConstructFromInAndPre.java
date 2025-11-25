package src.binarytrees.hard;

import java.util.HashMap;
import java.util.Map;

public class ConstructFromInAndPre {

    static Node buildTree(int[] preOrder,int preStart,int preEnd,int[] inOrder,int inStart,int inEnd,Map<Integer,Integer> inMap){
        if(preStart>preEnd ||inStart>inEnd) return null;
        Node root = new Node(preOrder[preStart]);
        int inRoot = inMap.get(root.data);
        int numsLeft = inRoot-inStart;
        root.left = buildTree(preOrder,preStart+1,preStart+numsLeft,inOrder,inStart,inRoot-1,inMap);
        root.right = buildTree(preOrder,preStart+numsLeft+1,preEnd,inOrder,inRoot+1,inEnd,inMap);
        return root;

    }
    static Node constructTree(int[] inOrder,int[] preOrder){
        Map<Integer,Integer> inMap = new HashMap<>();
        for(int i=0;i<inOrder.length;i++){
            inMap.put(inOrder[i],i);
        }
        Node root = buildTree(preOrder,0,preOrder.length-1,inOrder,0,inOrder.length-1,inMap);
        return root;
    }

    public static void printInorder(Node root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] preorder = {3, 9, 20, 15, 7};

        Node root =constructTree( inorder,preorder);

        System.out.println("Inorder of Unique Binary Tree Created:");
        printInorder(root);
    }

}
