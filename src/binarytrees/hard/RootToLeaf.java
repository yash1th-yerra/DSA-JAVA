package src.binarytrees.hard;

import java.util.ArrayList;
import java.util.List;

public class RootToLeaf {



    static void getPath(Node root,List<Integer> curr,List<List<Integer>> ans){
        if(root==null) return;
        curr.add(root.data);
        if(root.left==null && root.right==null) ans.add(new ArrayList<>(curr));
        else{
            getPath(root.left,curr,ans);
            getPath(root.right,curr,ans);
        }
        curr.remove(curr.size()-1);
    }

    static List<List<Integer>> rootToLeaf(Node root){
        List<List<Integer>> ans = new ArrayList<>();
        getPath(root,new ArrayList<>(),ans);
        return ans;
    }
    static void main() {
        Node root = new Node(3);
        root.left = new Node(5);
        root.right = new Node(1);
        root.left.left = new Node(6);
        root.left.right = new Node(2);
        root.right.left = new Node(0);
        root.right.right = new Node(8);
        root.left.right.left = new Node(7);
        root.left.right.right = new Node(4);





        // Get path from root to target
        List<List<Integer>> path = rootToLeaf(root);

        // Print the path
        System.out.print("Path from root to leaf " );
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i));
            if (i < path.size() - 1)
                System.out.print(" | ");
        }
    }
}
