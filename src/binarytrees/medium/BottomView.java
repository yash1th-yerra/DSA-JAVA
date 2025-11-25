package src.binarytrees.medium;

import java.util.*;

public class BottomView {


    static class Pair{
        Node node;
        int index;

        Pair(Node node,int index){
            this.node = node;
            this.index = index;
        }
    }
    static List<Integer> bottomView(Node root){
        List<Integer> ans = new ArrayList<>();
        Map<Integer,Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));
        while(!q.isEmpty()){
            Pair it = q.remove();
            int index = it.index;
            Node temp = it.node;
            map.put(index,temp.data);
            if(temp.left!=null) q.add(new Pair(temp.left,index-1));
            if(temp.right!=null) q.add(new Pair(temp.right,index+1));


        }

        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
    }


    static void main() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(10);
        root.left.left.right = new Node(5);
        root.left.left.right.right = new Node(6);
        root.right = new Node(3);
        root.right.right = new Node(10);
        root.right.left = new Node(9);


        // Get the top view traversal
        List<Integer> bottomView = bottomView(root);

        // Print the result
        System.out.println("Bottom View Traversal: ");
        for (int node : bottomView) {
            System.out.print(node + " ");

        }
    }
}
