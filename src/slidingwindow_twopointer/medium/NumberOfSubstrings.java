package src.slidingwindow_twopointer.medium;

public class NumberOfSubstrings {


    static int numberOfSubstringsBrute(String s){
        int count=0;
        int n = s.length();
        for(int i=0;i<n;i++){
            int[] freq = new int[3];
            for(int j=i;j<n;j++){
                freq[s.charAt(j)-'a']++;
                if(freq[0]>0 && freq[1]>0 && freq[2]>0) count++;
            }
        }
        return count;
    }


    static int numberOfSubstringsOptimal(String s){
        int[] freq = new int[3];
        int left = 0;
        int res = 0;
        for(int right=0;right<s.length();right++){
            freq[s.charAt(right)-'a']++;
            while(freq[0]>0 && freq[1]>0 && freq[2]>0){
                res+=(s.length()-right);
                freq[s.charAt(left)-'a']--;
                left++;
            }
        }
        return res;
    }

    static void main() {
        String s = "abcabc";
        System.out.println(numberOfSubstringsBrute(s));
        System.out.println(numberOfSubstringsOptimal(s));
    }
}
