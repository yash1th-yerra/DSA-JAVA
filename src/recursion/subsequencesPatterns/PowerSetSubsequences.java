package src.recursion.subsequencesPatterns;

import java.util.ArrayList;
import java.util.List;

public class PowerSetSubsequences {


    static void helper(String s,int index,StringBuilder current,List<String> result){
        if(index==s.length()){
            result.add(current.toString());
            return;
        }

        helper(s,index+1,current,result);
        current.append(s.charAt(index));
        helper(s,index+1,current,result);
        current.deleteCharAt(current.length()-1);
    }
    static List<String> getSubsequences(String s){
        List<String> result = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        helper(s,0,current,result);
        return result;
    }

    static void main() {
        String s = "abc";
        List<String> res = getSubsequences(s);
        for (String seq : res) {
            System.out.println("\"" + seq + "\"");
        }
    }
}
