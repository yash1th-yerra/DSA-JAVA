package src.slidingwindow_twopointer.medium;

import java.util.Arrays;

public class LongestSubstringWithoutRepeatingChars {


    static int longestSubstringWithoutRepeatingCharsBrute(String s){
        int n = s.length();
        if(n == 0) return -1;

        int maxLen=0;
        for(int i=0;i<n;i++){
            int[] hash = new int[256];
            Arrays.fill(hash,0);
            for(int j=i;j<n;j++){
                if(hash[s.charAt(j)]==1) break;
                hash[s.charAt(j)]=1;
                int len = j-i+1;

                maxLen = Math.max(maxLen,len);
            }
        }

        return maxLen;

    }

    static int longestSubstringWithoutRepeatingCharsOptimal(String s){
        int maxLen=0;
        int n = s.length();
        int l = 0,r=0;
        int[] hash = new int[256];
        Arrays.fill(hash,-1);
        while(r<n){
            if(hash[s.charAt(r)]>=l){
                l = Math.max(hash[s.charAt(r)]+1,l);
            }

            int len = r-l+1;
            maxLen = Math.max(maxLen,len);
            hash[s.charAt(r)]=r;
            r++;
        }



        return maxLen;



    }


    static void main() {
        String s = "abcsesabcbb";
        System.out.println("Longest Substring without duplicates is: "+longestSubstringWithoutRepeatingCharsBrute(s));
        System.out.println("Longest Substring without duplicates is: "+longestSubstringWithoutRepeatingCharsOptimal(s));
    }


}
