package src.binarytrees.basic;

import java.sql.SQLOutput;

public class CheckBalance {

    // function to get height at each node
    public static int getHeight(Node node){
        if(node==null) return 0;
        int leftt = getHeight(node.left);
        int rightt = getHeight(node.right);
        return Math.max(leftt,rightt)+1;
    }


    // bruteforce approach
    public static boolean isBalance(Node root){
        if(root==null) return true;
        int leftt = getHeight(root.left);
        int rightt = getHeight(root.right);

        if(Math.abs(rightt-leftt)<=1 && isBalance(root.left) && isBalance(root.right)) return true;

        return false;


    }


    // optimal approach
    public static int checkBalance(Node root){
        if(root==null) return 0;
        int lt = checkBalance(root.left);
        if(lt==-1) return -1;
        int rt = checkBalance(root.right);
        if(rt==-1) return -1;
        if(Math.abs(rt-lt)>1) return -1;
        return Math.max(rt,lt)+1;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
//        root.left = new Node(2);
        root.right = new Node(3);
//        root.left.left = new Node(4);
//        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(isBalance(root));
        if(checkBalance(root) ==-1) System.out.println("False");
        else System.out.println("True");
    }
}
