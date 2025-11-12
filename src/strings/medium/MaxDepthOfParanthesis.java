package src.strings.medium;

public class MaxDepthOfParanthesis{

    private static int maxDepth(String s){
        if (s.length()<=1) return 0;
        int ans=0;
        int counter=0;
        for(char ch:s.toCharArray()){
            if(ch=='(') counter++;
            else if (ch==')') counter--;
            ans = Math.max(ans,counter);
        }

        return ans;
    }
    static void main() {
        String s = "(1+(2*3)+((8)/4))+1";
        System.out.println(maxDepth(s));
    }
}
