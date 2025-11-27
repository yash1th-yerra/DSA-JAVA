package src.tries;

public class Trie {

    private Node root;

    public Trie(){
        root = new Node();
    }

    public void insert(String word){
        Node node = root;
        for(char ch:word.toCharArray()){
            if(!node.containsKey(ch)){
                node.put(ch,new Node());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }

    public boolean search(String word){
        Node node = root;
        for(char ch:word.toCharArray()){
            if(!node.containsKey(ch)){
                return false;
            }
            node = node.get(ch);
        }
        return node.isEnd();
    }

    public boolean startsWith(String prefix){
        Node node = root;
        for(char ch: prefix.toCharArray()){
            if(!node.containsKey(ch)) return false;
            node = node.get(ch);
        }
        return true;
    }

    public boolean checkIfPrefixExists(String word){
        Node node = root;
        boolean flag = true;
        for(char ch:word.toCharArray()){
            if(node.containsKey(ch)){
                node = node.get(ch);
                flag = flag & node.isEnd();
            }else{
                return false;
            }
        }
        return true;
    }
}
