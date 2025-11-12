package src.strings.easy;

import java.util.Arrays;

public class LongestCommionPrefix {


    private static String longestCommonPrefix(String[] input){
        StringBuilder ans = new StringBuilder();
        Arrays.sort(input);
        String first =input[0];
        String last = input[input.length-1];
        for(int i=0;i<Math.min(first.length(),last.length());i++){
            if(first.charAt(i)!=last.charAt(i)) return ans.toString();
            ans.append(first.charAt(i));
        }
        return ans.toString();
    }
    static void main() {
        String[] input = {"interview","internet","internal","interval"};
        String result = longestCommonPrefix(input);
        System.out.println(result);
    }
}
