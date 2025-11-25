package src.binarytrees.hard;

public class LowestCommonAncestor {

    static Node lowestCommonAncestor(Node root,Node p,Node q){

        if(root==null || root==p || root==q) return root;
        Node left = lowestCommonAncestor(root.left,p,q);
        Node right =lowestCommonAncestor(root.right,p,q);
        if(left==null) return right;
        else if(right==null) return left;
        else return root;

    }

    static void main() {
        Node root = new Node(3);
        root.left = new Node(5);
        root.right = new Node(1);
        root.left.left = new Node(6);
        root.left.right = new Node(2);
        root.right.left = new Node(0);
        root.right.right = new Node(8);

        Node p = root.left;       // Node with value 5
        Node q = root.right;      // Node with value 1

        Node lca = lowestCommonAncestor(root, p, q);
        System.out.println("Lowest Common Ancestor: " + lca.data);
    }
}
