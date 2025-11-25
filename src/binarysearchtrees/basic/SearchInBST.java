package src.binarysearchtrees.basic;

public class SearchInBST {
    static Node searchBST(Node root,int target){
        while(root!=null && root.data!=target){
            if(target<root.data) root = root.left;
            else root = root.right;
        }
        return root;
    }


    static void main() {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(7);
        root.left.left = new Node(1);
        root.left.right = new Node(3);


        Node result = searchBST(root, 2);

        if (result != null)
            System.out.println("Node found: " + result.data);
        else
            System.out.println("Node not found");
    }
}
