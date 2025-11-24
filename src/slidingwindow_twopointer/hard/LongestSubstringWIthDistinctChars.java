package src.slidingwindow_twopointer.hard;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWIthDistinctChars {

    static int lengthOfLongestSubstringWithDistinctChars(String s,int k){
        int maxLength=0;

        for(int i=0;i<s.length();i++){
            Map<Character,Integer> freqMap = new HashMap<>();
            for(int j=i;j<s.length();j++){
                freqMap.put(s.charAt(j), freqMap.getOrDefault(s.charAt(j),0)+1);
                if(freqMap.size()>k) break;
                maxLength = Math.max(maxLength,j-i+1);
            }
        }
        return maxLength;
    }

    static int lengthOfLongestSubstringWithDistinctCharsOptimal(String s,int k){
        int maxLength=0;

        if(k==0 || s.length()==0) return 0;

        Map<Character,Integer> freqMap = new HashMap<>();
        int left = 0;
        for(int right=0;right<s.length();right++){
            char c = s.charAt(right);
            freqMap.put(c,freqMap.getOrDefault(c,0)+1);
            while(freqMap.size()>k){
                char leftChar = s.charAt(left);
                freqMap.put(leftChar,freqMap.get(leftChar)-1);
                if(freqMap.get(leftChar)==0) freqMap.remove(leftChar);
                left++;
            }

            maxLength = Math.max(maxLength,right-left+1);
        }
        return maxLength;
    }


    static void main() {
        String s = "aababbcaacc";
        int k = 2;
        System.out.println(lengthOfLongestSubstringWithDistinctChars(s,k));
        System.out.println(lengthOfLongestSubstringWithDistinctCharsOptimal(s,k));
    }





}
