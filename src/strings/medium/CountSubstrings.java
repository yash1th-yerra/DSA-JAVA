package src.strings.medium;


import java.util.HashMap;
import java.util.Map;

public class CountSubstrings {

    private static int atmostKDistinct(String s,int k){
        int res=0;
        int left=0;
        Map<Character,Integer> freq = new HashMap<>();
        for(int right=0;right<s.length();right++){
            freq.put(s.charAt(right),freq.getOrDefault(s.charAt(right),0)+1);

            while(freq.size()>k){
                char leftChar = s.charAt(left);
                freq.put(leftChar,freq.get(leftChar)-1);
                if(freq.get(leftChar)==0) freq.remove(leftChar);
                left++;
            }
            res+=(right-left+1);
        }
        return res;
    }
    private static int countSubstrings(String s,int k){
        return atmostKDistinct(s,k) - atmostKDistinct(s,k-1);
    }
    static void main() {
        String s = "pqpqs";
        int k =2;

        System.out.println(countSubstrings(s,k));
    }

}
