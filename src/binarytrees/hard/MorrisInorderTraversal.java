package src.binarytrees.hard;

import java.util.ArrayList;
import java.util.List;

public class MorrisInorderTraversal {


    static List<Integer> morrisInorder(Node root){
        List<Integer> inOrder = new ArrayList<>();
        if(root==null) return inOrder;
        Node curr = root;
        while(curr!=null){
            if(curr.left==null){
                inOrder.add(curr.data);
                curr = curr.right;
            }
            else{
                Node prev = curr.left;
                while(prev.right!=null && prev.right!=curr) prev = prev.right;
                if(prev.right==null){
                    prev.right=curr;
                    curr = curr.left;
                }else{
                    prev.right=null;
                    inOrder.add(curr.data);
                    curr = curr.right;
                }
            }
        }
        return inOrder;
    }
}
