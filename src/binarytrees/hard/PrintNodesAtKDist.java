package src.binarytrees.hard;

import java.util.*;

public class PrintNodesAtKDist {

    // since we can't move upward direction in binary trees
    // we need to maintain parent hashmap to move upward
    // also we need visited hashmap to avoid revisiting of same node.
    // while adding answers to result.

    static void markParents(Node root,Map<Node,Node> parent_map){
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            Node current = q.poll();
            if(current.left!=null){
                parent_map.put(current.left,current);
                q.offer(current.left);
            }
            if(current.right!=null){
                parent_map.put(current.right,current);
                q.offer(current.right);
            }
        }
    }

    static List<Integer> distanceK(Node root,Node target,int k){
        List<Integer> result = new ArrayList<>();
        Map<Node,Node> parent_map = new HashMap<>();
        Map<Node,Boolean> visited = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        markParents(root,parent_map);
        q.offer(target);
        visited.put(target,true);
        int curr_level=0;
        while(!q.isEmpty()){
            int size = q.size();
            if(curr_level==k) break;
            curr_level++;
            for(int i=0;i<size;i++){
                Node curr = q.poll();
                if(curr.left!=null && visited.get(curr.left)==null){
                    q.offer(curr.left);
                    visited.put(curr.left,true);
                }
                if(curr.right!=null && visited.get(curr.right)==null){
                    q.offer(curr.right);
                    visited.put(curr.right,true);
                }
                if(parent_map.get(curr)!=null && visited.get(parent_map.get(curr))==null){
                    q.offer(parent_map.get(curr));
                    visited.put(parent_map.get(curr),true);
                }
            }
        }
        while(!q.isEmpty()){
            Node curr = q.poll();
            result.add(curr.data);
        }
        return result;

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

        // Choose a target node
        Node target = root.left; // Node with value 5

        int k = 2;

        System.out.println("Nodes at distance " + k + " from node " + target.data + ":");

        var ans = PrintNodesAtKDist.distanceK(root, target, k);

        for (int x : ans) {
            System.out.print(x + " ");
        }
    }
}
