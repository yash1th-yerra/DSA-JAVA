package src.binarytrees.basic;

public class LongestDiameter {

    //bruteforce
//    public static int getHeight(Node root){
//        if(root==null) return 0;
//        int lh = getHeight(root.left);
//        int rh = getHeight(root.right);
//        return 1+Math.max(lh,rh);
//    }
//
//    public static void findDiameter(Node root,int maxi){
//        if(root==null) return ;
//        int lh = findHeight(root.left);
//        int rh = findHeight(root.right);
//        maxi = Math.max(maxi,lh+rh);
//        findDiameter(root.left,maxi);
//        findDiameter(root.right,maxi);
//
//    }

    // Optimal approach

    public static int findDiameter(Node root,int maxi){
        if(root==null) return 0;
        int lh = findDiameter(root.left,maxi);
        int rh = findDiameter(root.right,maxi);
        maxi = Math.max(maxi,lh+rh);
        return 1+Math.max(lh,rh);
    }


    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.right = new Node(7);
        root.right.right.right.right = new Node(7);

        System.out.println(findDiameter(root,0));
    }

}
