package src.strings.easy;

import java.util.Arrays;

public class ValidAnagram {


    private static String sortString(String s){
        char c[] = s.toCharArray();
        Arrays.sort(c);
        return new String(c); // toString() will only return array reference
    }

    private static boolean validAnagram(String s1,String s2){

        if(s1.length()!=s2.length()) return false;

//        s1 = sortString(s1);
//        s2 = sortString(s2);
//
//        for(int i=0;i<s1.length();i++){
//            if(s1.charAt(i)!=s2.charAt(i)) return false;
//        }

        int[] freq = new int[26];
        for(int i=0;i<s1.length();i++){
            freq[s1.charAt(i)-'a']++;
        }
        for(int i=0;i<s2.length();i++){
            freq[s2.charAt(i)-'a']--;
        }

        for(int i=0;i<26;i++){
            if(freq[i]!=0) return false;
        }

        return true;
    }

    static void main() {
        String s1 = "eat";
        String s2 = "ate";

        if(validAnagram(s1.toLowerCase(),s2.toLowerCase())) System.out.println(true);
        else System.out.println(false);
    }
}
