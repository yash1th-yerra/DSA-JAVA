package src.greedy;

public class ValidParanthesisString {


    /*

        you are given a string which only contains (,),*
        you need to check if string is valid or not
        valid conditions:
        1. left paranthesis must have right paranthesis
        2. their order must be in ()
        3. * can be anything (,),"" we can use it as per requirement

        There are three approaches
        1. brute force using recursion tc- O(3^n) since * has three possibilites to explore
        2. better solution is dp tabulation
        3. using range of open and closed paranthesis


        lets look into optimal third approach

        lets given s = (*)*()

        we need to take open and closed as a range so anything else we can't take as a range
        so for that we can use minimum considerations as variable (min)


        similarly we can also maintain a variable to consider all possibilities (max)


        ( -> min = 1 max = 1
        * -> min = 0 max = 2
        ) -> min = 0 max = 1
        * -> min = 0 max = 2
        ( -> min = 1 max = 3
        ) -> min = 0 max = 2

        if max is not less than 0 since we are considering * so we can decrement it even though it is <=0
        in min we are not considering * so occurance  ) or * these can not be decremented if min<=0
        to track such * considerations we use max variable
        if at any moment max<0 i.e. string having more ) so we can return false
        if min!=0 then also we are mssing some value there hence we return false
        else return true


    * */


    public static boolean checkValidString(String s){
        if(s.length()==0) return true;
        int min  =0,max=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                min++;
                max++;
            }
            else if(s.charAt(i)==')'){
                if(min>0) min--;
                max--;
            }
            else{
                if(min>0) min--;
                max++;
            }
            if(max<0) return false;
        }
        return min==0;

    }

    public static void main(String[] args) {
        String s1 = "(*))";
        System.out.println("Input: " + s1 + " → Output: " + checkValidString(s1)); // True

        // Test Case 2: Unbalanced with extra opening parenthesis
        String s2 = "(*()";
        System.out.println("Input: " + s2 + " → Output: " + checkValidString(s2)); // False

        // Test Case 3: All * treated as empty
        String s3 = "***";
        System.out.println("Input: " + s3 + " → Output: " + checkValidString(s3)); // True

        // Test Case 4: Unbalanced with extra closing parenthesis
        String s4 = "())";
        System.out.println("Input: " + s4 + " → Output: " + checkValidString(s4)); // False

        // Test Case 5: Complex case with nested brackets and *
        String s5 = "(*)";
        System.out.println("Input: " + s5 + " → Output: " + checkValidString(s5)); // True

    }
}
