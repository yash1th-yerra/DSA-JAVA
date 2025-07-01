package src.recursion.subsequencesPatterns;


import java.util.ArrayList;
import java.util.List;

/*
    you are given a number n , so that you are destined to generate pair of valid parenthesis
    of each pair considered as length 1 . you have to generate upto length n

    so a pair is called valid only if ( comes before ) and no of ( comes before is greater than ) comes later.
    and there should be equal number of ( and )

 */
public class GenerateValidPairParenthesis {

    public static void generateParenthesis(int n ){
        List<String> result = new ArrayList<>();
        backTrack(n,0,0,new StringBuilder(),result);
        int i=1;
        for(String s:result){
            System.out.println(s+"->"+i++);
        }

    }


    private static void backTrack(int n,int open,int close,StringBuilder current,List<String> result){
        if(current.length()==2*n){
            result.add(current.toString());
            return ;
        }

        if(open<n){
            current.append('(');
            backTrack(n,open+1,close,current,result);
            current.deleteCharAt(current.length()-1);
        }
        if(close<open){
            current.append(')');
            backTrack(n,open,close+1,current,result);
            current.deleteCharAt(current.length()-1);
        }
    }

    public static void main(String[] args) {
        generateParenthesis(3);


    }
}
