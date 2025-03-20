package src.binarytrees.basic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {


    // Here first we will take queue datastructure to maintain nodes level wise.
    // we add root at start of queue. from then we check if it has left and right if so we add them into queue.
    // after adding left and right we just poll root element from queue and add it into sublist.

    public static List<List<Integer>> levelOrder(Node root){
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> sublist = new ArrayList<>();
            for(int i=0;i<levelNum;i++){
                try{
                    if (queue.peek().left != null) queue.offer(queue.peek().left);
                    if (queue.peek().right != null) queue.offer(queue.peek().right);
                    sublist.add(queue.poll().data);
                }catch (NullPointerException e){
                    System.out.println(e.getMessage());
                }
            }
            ans.add(sublist);
        }





        return ans;

    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        List<List<Integer>> ans = levelOrder(root);

        for(List<Integer> list:ans){
            System.out.println(list);
        }
    }
}
