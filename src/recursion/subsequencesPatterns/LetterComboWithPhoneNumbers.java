package src.recursion.subsequencesPatterns;

import java.util.ArrayList;
import java.util.List;

public class LetterComboWithPhoneNumbers {

    private static final String[] map = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    static void helper(String digits,List<String> ans,int index,String current){
        if(index==digits.length()){
            ans.add(current);
            return;
        }

        String s = map[digits.charAt(index)-'0'];
        for(int i=0;i<s.length();i++){
            helper(digits,ans,index+1,current+s.charAt(i));
        }
    }

    static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>(); // List to store results

        // Return empty list if digits string is empty
        if (digits.length() == 0) return ans;

        // Initiate recursive function
        helper(digits, ans, 0, "");
        return ans; // Return the result
    }
    static void main() { String digits = "23"; // Input digits
        List<String> result =letterCombinations(digits); // Get combinations

        // Print the results
        for (String combination : result) {
            System.out.print(combination + " "); // Display each combination
        }
    }


}
