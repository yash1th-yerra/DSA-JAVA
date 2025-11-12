package src.strings.medium;

import java.util.HashMap;
import java.util.Map;

public class SumOfBeautyOfSubStrings {

    private static int beautySum(String s){
        int n = s.length();
        int sum =0;

        for(int i=0;i<n;i++){
            Map<Character,Integer> freq = new HashMap<>();
            for(int j=i;j<n;j++){
                freq.put(s.charAt(j),freq.getOrDefault(s.charAt(j),0)+1);
                int maxi = Integer.MIN_VALUE;
                int mini = Integer.MAX_VALUE;
                for(int val:freq.values()){
                    mini = Math.min(mini,val);
                    maxi = Math.max(maxi,val);
                }

                sum+=(maxi-mini);
            }

        }
        return sum;
    }

    static void main() {
        String s = "xyxxxx";
        System.out.println(beautySum(s));
    }
}
