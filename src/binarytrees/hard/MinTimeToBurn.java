package src.binarytrees.hard;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MinTimeToBurn {
    // from start node we have to move radially
    // calculate distance till it reaches all nodes
    // to have upward flow , we will create parent pointers.


    static Node markParents(Node root,Map<Node,Node> parent_map,int start){
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        Node res = new Node(0);
        while(!q.isEmpty()){
            Node node = q.poll();
            if(node.data==start) res = node;
            if(node.left!=null){
                parent_map.put(node.left,node);
                q.offer(node.left);
            }
            if(node.right!=null){
                parent_map.put(node.right,node);
                q.offer(node.right);
            }
        }
        return res;
    }

    static int findMaxDistance(Map<Node,Node> parent_map,Node target){
        Queue<Node> q = new LinkedList<>();
        q.offer(target);
        Map<Node,Boolean> visited = new HashMap<>();
        visited.put(target,true);
        int time = 0;
        while(!q.isEmpty()){
            int size = q.size();
            boolean burned = false;
            for(int i=0;i<size;i++){
                Node node = q.poll();
                if(node.left!=null && visited.get(node.left)==null){
                    burned = true;
                    q.offer(node.left);
                    visited.put(node.left,true);
                }
                if(node.right!=null && visited.get(node.right)==null){
                    burned = true;
                    q.offer(node.right);
                    visited.put(node.right,true);
                }
                Node parent = parent_map.get(node);
                if(parent!=null && visited.get(parent)==null){
                    burned = true;
                    q.offer(parent);
                    visited.put(parent,true);
                }

            }
            if(burned) time++;

        }
        return time;

    }
    static int minTimeToBurn(Node root,int start){
        Map<Node,Node> parent_map = new HashMap<>();
        Node target = markParents(root,parent_map,start);
        return findMaxDistance(parent_map,target);
    }

    static void main() {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int start = 5;

        int time = MinTimeToBurn.minTimeToBurn(root, start);

        System.out.println("Time to burn the tree = " + time);
    }


}
