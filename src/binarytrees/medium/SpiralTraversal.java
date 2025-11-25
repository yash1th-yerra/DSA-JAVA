package src.binarytrees.medium;



import java.util.*;

public class SpiralTraversal {

    static List<List<Integer>> zigzagTraversal(Node root){
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        boolean flag=true;
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> row = new ArrayList<>();
            for(int i=0;i<size;i++){
                Node node = q.poll();
                row.add(node.data);
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
            if(!flag) Collections.reverse(row);
            flag = !flag;
            ans.add(row);
        }
        return ans;
    }

    static void printResult(List<List<Integer>> result) {
        for (List<Integer> row : result) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    static void main() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        List<List<Integer>> result = zigzagTraversal(root);

        // Print the result
        printResult(result);
    }
}
