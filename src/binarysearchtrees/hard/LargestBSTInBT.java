package src.binarysearchtrees.hard;

public class LargestBSTInBT {

    // bruteforce
    // traverse through BT and validate BST till that node
    // if it returns true update largest BST till that node.


    static class NodeValue{
        int maxNode,minNode,maxSize;

        NodeValue(int maxNode,int minNode,int maxSize){
            this.maxNode = maxNode;
            this.minNode = minNode;
            this.maxSize = maxSize;
        }
    }
    static NodeValue largestBSTSubtreeHelper(Node root){
        if(root==null) return new NodeValue(Integer.MAX_VALUE,Integer.MIN_VALUE,0);
        NodeValue left = largestBSTSubtreeHelper(root.left);
        NodeValue right = largestBSTSubtreeHelper(root.right);

        if(left.maxNode<root.data && root.data<right.minNode)
            return new NodeValue(Math.min(left.minNode,root.data),Math.max(right.maxNode,root.data),1+left.maxSize+right.maxSize);
        return new NodeValue(Integer.MIN_VALUE,Integer.MAX_VALUE,Math.max(left.maxSize,right.maxSize));
    }

    static int largestBSTInBT(Node root){
        return largestBSTSubtreeHelper(root).maxSize;
    }
}
