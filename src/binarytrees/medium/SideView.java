package src.binarytrees.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SideView {

    // To get left and right views of a binary tree, we use level order traversal (breadth first search)
    // we queue nodes level by level.for each level , we record all nodes in order
    // for left view we pick first element in each level.
    // for right view we pick last element in each level.

    static List<List<Integer>> levelOrder(Node root){
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) return ans;
        Queue<Node> q   =new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for(int i=0;i<size;i++){
                Node node = q.poll();
                level.add(node.data);
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);

            }
            ans.add(new ArrayList<>(level));

        }
        return ans;
    }

    static List<Integer> leftView(Node root){
        List<List<Integer>> levels = levelOrder(root);
        List<Integer> left = new ArrayList<>();

        for(List<Integer> level : levels){
            left.add(level.get(0));
        }
        return left;
    }

    static List<Integer> rightView(Node root){
        List<List<Integer>> levels = levelOrder(root);
        List<Integer> left = new ArrayList<>();

        for(List<Integer> level : levels){
            left.add(level.get(level.size()-1));
        }
        return left;
    }


    static void leftViewDfs(Node root,int level,List<Integer> res){
        if(root==null) return;
        if(res.size()==level) res.add(root.data);
        leftViewDfs(root.left,level+1,res);
        leftViewDfs(root.right,level+1,res);
    }

    static void rightViewDfs(Node root,int level,List<Integer> res){
        if(root==null) return;
        if(res.size()==level) res.add(root.data);
        rightViewDfs(root.right,level+1,res);
        rightViewDfs(root.left,level+1,res);
    }

    static List<Integer> leftViewRecursive(Node root) {
        List<Integer> res = new ArrayList<>();
        leftViewDfs(root, 0, res);
        return res;
    }

    // Wrapper for right view
    static List<Integer> rightViewRecursive(Node root) {
        List<Integer> res = new ArrayList<>();
        rightViewDfs(root, 0, res);
        return res;
    }

    static void main() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.right = new Node(5);


        List<List<Integer>> levelOrder = levelOrder(root);
        System.out.println("Level Order Traversal:");
        for (List<Integer> level : levelOrder) {
            for (int val : level) System.out.print(val + " ");
            System.out.println();
        }

        // Print left view
        System.out.println("Left View: " + leftView(root));
        System.out.println("Left View: " + leftViewRecursive(root));

        // Print right view
        System.out.println("Right View: " + rightView(root));
        System.out.println("Right View: " + rightViewRecursive(root));
    }

}
