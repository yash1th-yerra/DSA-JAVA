package src.slidingwindow_twopointer.medium;

public class LongestRepeatingCharacterReplacement {

    static int longestRepeatingCharacterBrute(String s,int k){
        int maxLength = 0;
        for(int i=0;i<s.length();i++){
            int[] freq = new int[26];
            int maxFreq = 0;
            for(int j=i;j<s.length();j++){
                freq[s.charAt(j)-'A']++;
                maxFreq = Math.max(maxFreq,freq[s.charAt(j)-'A']);
                int windowSize = j-i+1;
                int replacements = windowSize-maxFreq;
                if(replacements<=k) maxLength = Math.max(maxLength,windowSize);

            }
        }
        return maxLength;
    }


    static int longestRepeatingCharacterOptimal(String s,int k){
        int[] freq = new int[26];
        int left = 0;
        int maxFreq = 0;
        int maxLen = 0;
        for(int right=0;right<s.length();right++){
            freq[s.charAt(right)-'A']++;
            maxFreq = Math.max(maxFreq,freq[s.charAt(right)-'A']);
            while((right-left+1)-maxFreq>k){
                freq[s.charAt(left)-'A']--;
                left++;
            }

            maxLen = Math.max(maxLen,right-left+1);
        }
        return maxLen;
    }



    static void main() {
        String s = "AABABBAB";
        int k = 2;
        System.out.println(longestRepeatingCharacterBrute(s,k));
        System.out.println(longestRepeatingCharacterOptimal(s,k));
    }

}
