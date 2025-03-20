package src.binarytrees.basic;

public class IdenticalTrees {

    public static boolean isIdentical(Node p,Node q){
        if(p==null || q==null ) return p==q;
        return (p.data==q.data) && isIdentical(p.left,q.left) && isIdentical(p.right,q.right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);


        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.left.left = new Node(4);
        root2.left.right = new Node(5);
        root2.right.left = new Node(6);
        root2.right.right = new Node(7);

        System.out.println(isIdentical(root,root2));
    }
}
