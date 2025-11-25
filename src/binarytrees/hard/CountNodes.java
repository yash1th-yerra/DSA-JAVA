package src.binarytrees.hard;

public class CountNodes {

    static int getLeftHeight(Node root){
        int count =0;
        while(root.left!=null){
            count++;
            root=root.left;
        }
        return count;
    }
    static int getRightHeight(Node root){
        int count =0;
        while(root.right!=null){
            count++;
            root=root.right;
        }
        return count;
    }
    static int countNode(Node root){
        if(root==null) return 0;
        int left = getLeftHeight(root);
        int right = getRightHeight(root);
        if(left==right) return (1<<left)-1;
        else return countNode(root.left)+countNode(root.right)+1;
    }


    static void main() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);



        // Count total nodes
        int totalNodes = countNode(root);

        // Print result
        System.out.println("Total number of nodes in the Complete Binary Tree: " + totalNodes);
    }


}
