package src.binarytrees.hard;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class SerializeAndDeserialize {

    static String serialize(Node root){
        if(root==null) return "";
        Queue<Node> q = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        q.add(root);
        while(!q.isEmpty()){
            Node node = q.poll();
            if(node==null){
                res.append("# ");
                continue;
            }
            res.append(node.data).append(" ");
            q.add(node.left);
            q.add(node.right);
        }
        return res.toString();
    }

    static Node deSerialize(String s){
        if(Objects.equals(s, "")) return null;
        Queue<Node> q = new LinkedList<>();
        String[] values = s.split(" ");
        Node root = new Node(Integer.parseInt(values[0]));
        q.add(root);
        for(int i=1;i<values.length;i++){
            Node node = q.poll();
            if(!values[i].equals("# ")){
                Node left = new Node(Integer.parseInt(values[i]));
                node.left = left;
                q.add(left);
            }
            if(!values[++i].equals("# ")){
                Node right = new Node(Integer.parseInt(values[i]));
                node.right = right;
                q.add(right);
            }
        }
        return root;

    }
}
