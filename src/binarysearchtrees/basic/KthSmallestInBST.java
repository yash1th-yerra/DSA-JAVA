package src.binarysearchtrees.basic;

public class KthSmallestInBST {

    // brute force can be using dfs and add items to list,sort them and return kth element.
    // which takes like O(N) + O(NlogN)

    // but if consider the property of BST , the inorder traversal of it will give us nodes in sorted order
    // also doing it in morris traversal makes it more efficient.


    static int morrisTraversal(Node root,int k){
        Node curr = root;
        int cnt= 0;
        while(curr!=null){
            if(curr.left==null){
                cnt++;
                if(cnt==k) return curr.data;
                curr = curr.right;
            }
            else{
                Node prev = curr.left;
                while(prev.right!=null && prev.right!=curr) prev = prev.right;
                if(prev.right==null){
                    prev.right = curr;
                    curr = curr.left;
                }else{
                    prev.right = null;
                    cnt++;
                    if(cnt==k) return curr.data;
                    curr = curr.right;
                }
            }
        }
        return -1;
    }
    static int kthSmallest(Node root,int k){
        return morrisTraversal(root,k);
    }
}
