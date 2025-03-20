package src.binarytrees.basic;

public class RecursiveInorder {

    // Inorder : left -> root -> right  (root will at center starting from left and ending at right)


    public static void inOrder(Node node){
        if(node==null) return;

        inOrder(node.left);
        System.out.println(node.data);
        inOrder(node.right);
    }


    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        inOrder(root);
    }



}
