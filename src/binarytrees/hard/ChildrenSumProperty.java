package src.binarytrees.hard;

public class ChildrenSumProperty {

    static void changeTree(Node root){
        if(root==null) return;
        int child = 0;
        if(root.left!=null) child+=root.left.data;
        if(root.right!=null) child+=root.right.data;
        if(child>=root.data) root.data = child;
        else{
            if(root.left!=null) root.left.data = root.data;
            if(root.right!=null) root.right.data = root.data;
        }
        changeTree(root.left);
        changeTree(root.right);

        int total = 0;
        if(root.left!=null) total+=root.left.data;
        if(root.right!=null) total+=root.right.data;
        if(root.left!=null || root.right!=null) root.data = total;
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


        // Print the inorder traversal
        // of tree before modification
        System.out.print("Binary Tree before modification: ");
        System.out.println();

        // Call the changeTree function
        // to modify the binary tree
        changeTree(root);

        // Print the inorder traversal
        // after modification
        System.out.print("Binary Tree after Children Sum Property: ");
        System.out.println();
    }
}
