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
        if(root==null) return ans;
        st.push(root);
        while(!st.isEmpty()){
            root = st.pop();
            st2.push(root);
            if(root.left!=null) st.push(root.left);
            if(root.right!=null) st.push(root.right);
        }

        while(!st2.isEmpty()){
            ans.add(st2.pop().data);
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
