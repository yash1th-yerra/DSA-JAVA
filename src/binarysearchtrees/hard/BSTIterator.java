package src.binarysearchtrees.hard;

import java.util.Stack;

public class BSTIterator {
    private Stack<Node> stack = new Stack<>();
    private boolean reverse=false;

    public BSTIterator(Node root){
        pushAll(root);
        this.reverse = false;
    }
    public BSTIterator(Node root,boolean reverse){
        pushAll(root);
        this.reverse = reverse;
    }

    public int next(){
        Node node = stack.pop();
        pushAll(node.right);
        return node.data;

    }

    public boolean hasNext(){
        return !stack.isEmpty();
    }

    private void pushAll(Node root){
        while(root!=null){
            stack.push(root);
            if(reverse) root = root.right;
            else root = root.left;
        }
    }
}
