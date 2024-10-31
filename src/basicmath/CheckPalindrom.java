package src.basicmath;

public class CheckPalindrom {

    public static boolean checkPalindrome(int n){
        
        int rev = 0;
        int temp = n;
        while(n>0){
            temp = n%10;
            rev = rev * 10 + temp ;
            n = n/10;
        
        }
        
        if(rev==temp ){
            return true;
        }
        else{
            return false;
        }
        

    }

    public static void main(String[] args) {
        int n = 12121;
        if(checkPalindrome(n)){
            System.out.println("Palindrome");
        }
        else{
            System.out.println("Not a Palindrome");
        }
    }
    
}
