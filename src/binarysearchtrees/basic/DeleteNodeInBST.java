package src.binarysearchtrees.basic;

public class DeleteNodeInBST {


    static Node findLastRight(Node node){
        if(node.right==null){
            return node;
        }
        return findLastRight(node.right);
    }
    static Node helper(Node root){
        if(root.left==null) return root.right;
        else if(root.right==null) return root.left;
        else {
            Node rightChild = root.right;
            Node lastRight = findLastRight(root.left);
            lastRight.right = rightChild;
            return root.left;
        }
    }
    static Node deleteNode(Node root,int key){
        if(root==null) return root;
        if(root.data==key) return helper(root);
        Node dummy = root;
        while(root!=null){
            if(root.data>key){
                if(root.left!=null && root.left.data==key){
                    root.left = helper(root.left);
                    break;
                }else root = root.left;
            }else{
                if(root.right!=null && root.right.data==key){
                    root.right = helper(root.right);
                    break;
                }else root = root.right;
            }
        }
        return dummy;
    }


//    static void main() {
//        Node root = new Node(4);
//        root.left = new Node(2);
//        root.right = new Node(7);
//        root.left.left = new Node(1);
//        root.left.right = new Node(3);
//
//
//        Node result = deleteNode(root, 2);
//
//
//    }
}
