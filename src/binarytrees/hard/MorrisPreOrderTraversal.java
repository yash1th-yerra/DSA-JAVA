package src.binarytrees.hard;

import java.util.ArrayList;
import java.util.List;

public class MorrisPreOrderTraversal {


    static List<Integer> morrisPreOrder(Node root){
        List<Integer> preOrder = new ArrayList<>();
        if(root==null) return preOrder;
        Node curr = root;
        while(curr!=null){
            if(curr.left==null){
                preOrder.add(curr.data);
                curr = curr.right;
            }
            else{
                Node prev = curr.left;
                while(prev.right!=null && prev.right!=curr) prev = prev.right;
                if(prev.right==null){
                    preOrder.add(curr.data);
                    prev.right=curr;
                    curr = curr.left;
                }else{
                    prev.right=null;
                    curr = curr.right;
                }
            }
        }
        return preOrder;
    }
}
