package src.binarytrees.medium;




public class HeightOfBinaryTree {


    static class Node {
        int data;
        Node left;
        Node right;
        public Node(int key){
            this.data = key;
        }

    }

    static int height(Node root){
        if(root==null) return 0;
        int left = height(root.left);
        int right = height(root.right);
        return 1+Math.max(left,right);
    }

    static void main() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(6);
        root.left.right.right.right = new Node(7);
        int depth = height(root);
        System.out.println("Maximum depth of the binary tree: " + depth);
    }
}
