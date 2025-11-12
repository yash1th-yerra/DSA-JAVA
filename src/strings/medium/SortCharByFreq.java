package src.strings.medium;

import java.util.Arrays;

public class SortCharByFreq {

    static class Pair{
        int freq;
        char ch;
        Pair(int freq,char ch){
            this.freq = freq;
            this.ch = ch;
        }
    }

    private static String freqSort(String s){

        StringBuilder ans = new StringBuilder();
        Pair[] freq = new Pair[26];

        for(int i=0;i<26;i++){
            freq[i] = new Pair(0,(char)(i+'a'));
        }

        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a'].freq++;
        }

        Arrays.sort(freq,(p1,p2)->{
            if(p1.freq!=p2.freq) return p2.freq-p1.freq;
            return p2.ch-p1.ch;
        });

        for(Pair p: freq){
            for (int i = 0; i < p.freq; i++) {
                ans.append(p.ch);
            }
        }


        return ans.toString();
    }
    static void main() {

        String s = "tree";

        System.out.println(freqSort(s));

    }
}
