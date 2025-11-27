package src.tries;

public class NoOfDistinctSubstrings {
    // brute force can be having two loops to generate substrings.
    // and a set data structure to store results.

    //optimal can be using trie data structure reducing space

    static int noOfDistinctSubStrings(String word){
        int count=0;
        Node root = new Node();
        for(int i=0;i<word.length();i++){
            Node node = root;
            for(int j=i;j<word.length();j++){
                if(!node.containsKey(word.charAt(j))){
                    count++;
                    node.put(word.charAt(j),new Node());

                }
                node = node.get(word.charAt(j));
            }
        }
        return count;
    }



}
