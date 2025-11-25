package src.binarytrees.hard;


import java.util.LinkedList;
import java.util.Queue;

public class MaxWidthOfTree {
    // To determine the maximum width of tree , an effective startegy would be to assign and identify
    // indexes for leftmost nodes and rightmost nodes at each level.
    // using these indexes, we can calculate the width for each level by subtracting the index of the leftMost
    // from that of rightMost node
    // we need to indexing , but normal indexing like we do in arrays is not suitable. why?
    // if any node is missing then it will index incorrectly
    // so we need to come up with better idea
    // there is , if we consider current node with index i, then its left will 2*i+1 and its right can be 2*i+2
    // 0 ->1 (on left) and -> 2 (on right)
    // similarly if we are on 1 -> 3(on left) -> 4 (on right) . if we are on 2 -> 5 on left -> 6 on right
    // but there is problem with this kind of indexing . if tree is skewed then calculating indexes
    // for childs will always double . so for a 10^5 length binary tree size will index size will become 10^10
    // causing memory overflow.
    // so we need to normalize indexes.how?
    // when we are on index i , we take i-minIndex where minIndex is minimum index in that level.
    // once done that we do 2*i+1 and 2*i+2
    // then we do sub min in that level with child indexes recursively.

    static int width(Node root){
        if(root==null) return 0;
        int ans = 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root,0));
        while(!q.isEmpty()){
            int size = q.size();
            int min = (int) q.peek().getValue();
            int first = 0,last=0;
            for(int i=0;i<size;i++){
                Pair<Node,Integer> p = q.poll();
                Node node = p.getKey();
                int currIndex = p.getValue() - min;

                if(i==0) first = currIndex;
                if(i==size-1) last = currIndex;

                if(node.left!=null) q.offer(new Pair(node.left,currIndex*2+1));
                if(node.right!=null) q.offer(new Pair(node.right,currIndex*2+2));

            }
            ans = Math.max(ans,last-first+1);
        }
        return ans;
    }

    static void main() {
        Node root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(2);

        root.left.left = new Node(5);
        root.left.right = new Node(3);

        root.right.right = new Node(9);

        // Tree representation:
        //            1
        //        /       \
        //       3         2
        //     /   \         \
        //    5     3         9

        int ans = MaxWidthOfTree.width(root);
        System.out.println("Maximum width of the Binary Tree is: " + ans);
    }
}
