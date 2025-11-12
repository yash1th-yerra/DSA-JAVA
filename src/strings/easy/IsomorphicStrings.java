package src.strings.easy;

public class IsomorphicStrings {



    private static boolean isIsomorphic(String s1,String s2){
        if(s1.length()!=s2.length()) return false;
        int[] map1 = new int[256],map2 = new int[256];
        for(int i=0;i<s1.length();i++){

            // if the char in string 1 points to particular index then character in string 2 must point to same index if it is not then
            // it is inconsistent to map hence not isomorphic
            if(map1[s1.charAt(i)]!=map2[s2.charAt(i)]) return false;
            map1[s1.charAt(i)] = i+1;
            map2[s2.charAt(i)] = i+1;

        }
        return true;
    }
    static void main() {
        String s1 = "foo";
        String s2 = "bar";



        if(isIsomorphic(s1,s2)) System.out.println(true);
        else System.out.println(false);
    }
}
