package src.tries;

public class Trie2 {

    private Node root;
    Trie2(){
        root = new Node();
    }

    public void insert(String word){
        Node node = root;
        for(char ch:word.toCharArray()){
            if(!node.containsKey(ch)){
                node.put(ch,new Node());
                node.increasePrefix();;
            }
        }
        node.increaseEnd();
    }

    public int countWordsEqualTo(String word){
        Node node = root;
        for(char ch:word.toCharArray()){
            if(node.containsKey(ch)){
                node = node.get(ch);
            }else{
                return 0;
            }
        }
        return node.getEnd();
    }

    public int countWordsStartingWith(String word){
         Node node = root;
         for(char ch:word.toCharArray()){
             if(node.containsKey(ch)) {
                 node = node.get(ch);

             }
             else return 0;
         }
         return node.getCntPrefix();
    }

    public void erase(String word){
        Node node = root;
        for(char ch:word.toCharArray()){
            if(node.containsKey(ch)){
                node = node.get(ch);
                node.reducePrefix();
            }else{
                return;
            }
        }
        node.reduceEnd();
    }
}
