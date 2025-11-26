package src.binarysearchtrees.hard;

import src.binarysearchtrees.basic.Node;

public class LCAInBST {
    static Node lca(Node root, Node p, Node q){
        if(root==null) return null;
        int curr = root.data;
        if(curr<p.data && curr<q.data) return lca(root.right,p,q);
        if(curr>p.data && curr>q.data) return lca(root.left,p,q);
        return root;
    }


}
