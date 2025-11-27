package src.tries;

public class LargestStringWithAllPrefixes {

    static String longestStringWithAllPrefix(String[] arr){
        Trie trie = new Trie();
        for(String s:arr){
            trie.insert(s);;
        }

        String longest = " ";
        for(String s :arr){
            // call the function in trie which will check if prefix exists or not .
            if(trie.checkIfPrefixExists(s)){
                if(s.length()>longest.length()) longest = s;
                else if(s.length() == longest.length() && s.compareTo(longest)<0) longest = s;
            }
        }
        if(longest==" ") return "None";
        return longest;
    }
}
