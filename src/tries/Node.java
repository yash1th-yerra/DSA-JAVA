package src.tries;

public class Node {

    Node[] links = new Node[26];
    boolean flag;
    private int cntEndWith;
    private int cntPrefix;

    Node(){
        cntEndWith=0;
        cntPrefix=0;
    }

    boolean containsKey(char ch){
        return links[ch-'a']!=null;
    }

    public void increasePrefix(){
        cntPrefix++;
    }

    public void increaseEnd(){
        cntEndWith++;

    }

    public void reducePrefix(){
        cntPrefix--;
    }

    public void reduceEnd(){
        cntEndWith--;
    }

    public int getEnd(){
        return cntEndWith;
    }

    public int getCntPrefix(){
        return cntPrefix;
    }


    void put(char ch , Node node){
        links[ch-'a'] = node;
    }

    Node get(char ch){
        return links[ch-'a'];
    }

    void setEnd(){
        flag = true;
    }

    boolean isEnd(){
        return flag;
    }
}
