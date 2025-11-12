package src.strings.medium;

public class LongestPalindromicSubstring {

    private static int expandFromCenter(String s,int left,int right){
        while(left>=0 && right< s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }

    private static String longestPalindromicSubstring(String s){

        int start=0,end=0;

        for(int center=0;center<s.length();center++){
            int lenOdd = expandFromCenter(s,center,center);
            int lenEven = expandFromCenter(s,center,center+1);
            int maxLen = Math.max(lenOdd,lenEven);

            if(maxLen > end-start){
                start = center-(maxLen-1)/2;
                end = center + maxLen/2;
            }


        }
        return s.substring(start,end+1);

    }
    static void main() {
        String input = "babad";
        System.out.println(longestPalindromicSubstring(input));
    }
}
