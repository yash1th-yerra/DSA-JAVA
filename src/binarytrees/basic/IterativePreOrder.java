package src.binarytrees.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativePreOrder {
    // preOrder  : root->left->right
    // here we use stack data structure since we need to get root from left popped
    public static List<Integer> preOrder(Node root){
        Stack<Node> st = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        st.push(root);

        while(!st.isEmpty()){
            root = st.pop();
            ans.add(root.data);

            if(root.right!=null) st.push(root.right);
            if(root.left!=null) st.push(root.left);


        }


        return ans;

    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        List<Integer> ans  =preOrder(root);

        System.out.println(ans);
    }
}
