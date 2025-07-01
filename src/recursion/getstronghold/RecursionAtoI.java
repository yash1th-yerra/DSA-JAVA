package src.recursion.getstronghold;


/*
    Given function myAtoI(String s) where it converts string into 32 bit signed integer

    if string contains whitespace ignore it
    if string contains sign use it in answer
    continue convert string into integer until non digit character
    if answer is less than -2^31 and greater than 2^31-1 then clip them to -2^31 and 2^31-1 respectively

 */
public class RecursionAtoI {

    public static int myAtoI(String s){
        int i=0,n = s.length();
        int sign =1;
        long result = 0;

        while(i<n && s.charAt(i)==' '){
            i++;
        }

        if(i<n && (s.charAt(i)=='-'|| s.charAt(i)=='+')){
            sign = s.charAt(i)=='-'?-1:1;
            i++;
        }

        while(i<n && Character.isDigit(s.charAt(i))){
            result = result*10 + (s.charAt(i)-'0');
            if(result*sign<Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
            if(result*sign>Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            i++;
        }

        return (int)(result*sign);

    }



    public static void main(String[] args){
        String s = "-03";

        System.out.println(myAtoI(s));
    }

}
