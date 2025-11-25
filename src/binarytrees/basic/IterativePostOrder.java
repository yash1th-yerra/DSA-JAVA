package src.binarytrees.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativePostOrder {

    // Two Stack Approach
    public static List<Integer> postOrder(Node root){
        List<Integer> ans = new ArrayList<>();
        Stack<Node> st = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        Node node = root;
        st.push(root);
        while(!st.isEmpty()){
            node = st.pop();
            st2.push(node);
            if(node.left!=null) st.push(node.left);
            if(node.right!=null) st.push(node.right);

        }

        while(!st2.isEmpty()){
            ans.add(st2.peek().data);
            st2.pop();

        }

        return ans;


    }



    //Single Stack Approach

    public static List<Integer> postOrder2(Node root){
        Stack<Node> st = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        Node curr = root;
//        st.push(root);
        while(curr!=null || !st.isEmpty()){
            if(curr!=null){
                st.push(curr);
                curr = curr.left;
            }
            else{
                Node temp = st.peek().right;
                if(temp==null){
                    temp = st.pop();
                    ans.add(temp.data);
                    while(!st.isEmpty() && temp == st.peek().right){
                        temp = st.pop();
                        ans.add(temp.data);
                    }
                }
                else{
                    curr = temp;
                }

            }
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

        List<Integer> ans = postOrder(root);
        System.out.println(ans);

        List<Integer> ans2 = postOrder2(root);
        System.out.println(ans2);
    }
}
