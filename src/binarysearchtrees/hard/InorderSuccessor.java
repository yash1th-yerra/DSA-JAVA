package src.binarysearchtrees.hard;

import java.util.ArrayList;
import java.util.List;

public class InorderSuccessor {


    // Brute Force

    static void inOrderTraversal(Node root,List<Integer> inOrder){
        if(root==null) return;
        inOrderTraversal(root.left,inOrder);
        inOrder.add(root.data);
        inOrderTraversal(root.right,inOrder);
    }


    static int binarySearch(List<Integer> inOrder,int key){
        int left = 0,right = inOrder.size()-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(inOrder.get(mid)==mid) return mid;
            else if(inOrder.get(mid)<key) left = mid+1;
            else right = mid-1;
        }
        return left==inOrder.size()-1? -1:left;
    }
    static Node inOrderSuccessor(Node root,Node p){
        List<Integer> inOrder = new ArrayList<>();
        inOrderTraversal(root,inOrder);
        int idx = binarySearch(inOrder,p.data);
        if(idx==inOrder.size()-1 || idx==-1) return null;
        return new Node(inOrder.get(idx+1));
    }



    // better Solution (Morris Inorder Traversal)



    //Optimal Solution
    static Node inOrderSuccessorOptimal(Node root,Node p){
        Node successor = null;
        while(root!=null){
            if(root.data>p.data){
                successor = root;
                root = root.left;
            }else root = root.right;
        }
        return successor;
    }






    static void main() {

    }
}
