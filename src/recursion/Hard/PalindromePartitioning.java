package src.recursion.Hard;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {


    /*
        Test Case - 1:
        s = "aab"
        [a , a , b ], [aa , b]

        Test Case - 2:
        s = 'aabb'
        [a,a,b,b],[aa,bb].[aa,b,b],[a,a,bb]



    */

    static boolean isPalindrome(String s ,int start,int end){
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    static void backTrack(int index,String s,List<String> path,List<List<String>> ans){
        if(index==s.length()){
            ans.add(new ArrayList<>(path));
            return;
        }

        for(int i=index;i<s.length();i++){
            if(isPalindrome(s,index,i)){
                path.add(s.substring(index,i+1));
                backTrack(i+1,s,path,ans);
                path.remove(path.size()-1);
            }
        }

    }
    static List<List<String>> partition(String s){
        List<List<String>> ans = new ArrayList<>();
        List<String> path = new ArrayList<>();
        backTrack(0,s,path,ans);
        return ans;
    }
    static void main() {
        String s = "aabb";
        List<List<String>> ans = partition(s);
        for(List<String> part : ans){
            for(String str:part){
                System.out.print(str+" ");
            }
            System.out.println();
        }
    }
}
