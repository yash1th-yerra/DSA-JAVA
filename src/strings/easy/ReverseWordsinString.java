package src.strings.easy;

import java.util.Stack;

public class ReverseWordsinString {


    private static String bruteReverseWords(String inputString){
        String builder = "";
        Stack<String> st = new Stack<>();
        int flag =0;
        for(int i=0;i<inputString.length();i++){
            if(inputString.charAt(i)==' '){
                if(flag==0) st.push(builder);
                builder="";
                flag=1;
            }else{
                builder+=inputString.charAt(i);
                flag=0;
            }
        }

        if(!builder.isEmpty()) st.push(builder);

        // since we don't have to add space at last we traverse till last before one.
        String result = "";
        while(st.size()!=1){
            result+=st.peek() + " ";
            st.pop();
        }
        // since we need to add last word as well
        result+=st.peek();
        return result;
    }

    private static String optimalReverseWords(String input){
        String result = "";
        int left =0,right=input.length()-1;
        while (left < input.length() && input.charAt(left) == ' ')
            left++;
        String temp ="";

        while(left<=right){
            char ch = input.charAt(left);
            if(ch!=' '){
                temp+=ch;
            }else{
                if (!temp.isEmpty()) {
                    if (result.isEmpty()) {
                        result = temp;
                    } else {
                        result = temp + " " + result;
                    }
                    temp = "";
                }
            }
            left++;
        }
        if(!temp.isEmpty()){
            if (result.isEmpty()) {
                result = temp;
            } else {
                result = temp + " " + result;
            }
        }
        return result;
    }


    static void main() {
        String inputString1 = "    a good    example";
        String inputString2 = "    sky is blue    ";
        String inputString3 = "rat and cat";

//        System.out.println(bruteReverseWords(inputString1));
        System.out.println(optimalReverseWords(inputString1));

//        String s1 = "good";
//        String s2 = "good1";
//        String s3 = "good2";
//
//        String output = s1 +" "+s2;
//        System.out.println(output);
    }
}
