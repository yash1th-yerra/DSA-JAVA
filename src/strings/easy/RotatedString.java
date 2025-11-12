package src.strings.easy;

public class RotatedString {



    private static boolean rotated(String s,String goal){
        if(s.length()!=goal.length()) return false;

//        for(int i=0;i<s.length();i++){
//            String rotated = s.substring(i) + s.substring(0,i);
//            if(rotated.equals(goal)) return true;
//        }

        s = s+s;
        return s.contains(goal);

//        return false;






    }

    static void main() {
        String s= "abcde";
        String goal = "bcdea";

        if(rotated(s,goal)) System.out.println(true);
        else System.out.println(false);
    }
}
