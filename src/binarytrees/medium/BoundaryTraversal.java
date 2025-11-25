package src.binarytrees.medium;

import java.util.ArrayList;
import java.util.List;

public class BoundaryTraversal {


    static boolean isLeaf(Node root){
        return root.left==null && root.right==null;
    }

    static void addLeftBoundary(Node root,List<Integer> res){
        Node cur = root.left;
        while(cur!=null){
            if(!isLeaf(cur)) res.add(cur.data);
            if(cur.left!=null) cur = cur.left;
            else cur = cur.right;
        }
    }
    static void addLeaves(Node root,List<Integer> res){
        if(isLeaf(root)){
            res.add(root.data);
            return;
        }
        if(root.left!=null) addLeaves(root.left,res);
        if(root.right!=null) addLeaves(root.right,res);
    }
    static void addRightBoundary(Node root,List<Integer> res){
        Node cur = root.right;
        List<Integer> temp = new ArrayList<>();
        while(cur!=null){
            if(!isLeaf(cur)) temp.add(cur.data);
            if(cur.right!=null) cur = cur.right;
            else cur = cur.left;
        }
        for(int i=temp.size()-1;i>=0;i--){
            res.add(temp.get(i));
        }
    }


    static List<Integer> boundaryTraversal(Node root){
        List<Integer> res = new ArrayList<>();
        if(root==null) return res;
        if(!isLeaf(root)) res.add(root.data);
        addLeftBoundary(root,res);
        addLeaves(root,res);
        addRightBoundary(root,res);
        return res;
    }
    static void printResult(List<Integer> result) {
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    static void main() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        List<Integer> result = boundaryTraversal(root);

        // Print the result
        System.out.print("Boundary Traversal: ");
        printResult(result);

    }
}
