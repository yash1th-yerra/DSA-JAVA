package src.basicmath;

public class ReverseNumber {


    public static int reverse(int n){
        int rev = 0;
        while(n>0){
            int temp = n%10;
            
            if(temp>Integer.MAX_VALUE || (temp==Integer.MAX_VALUE && temp<7)){
                return 0;
            }
            if(temp<Integer.MIN_VALUE || (temp==Integer.MIN_VALUE && temp>-8)){
                return 0;
            }
            rev = rev *10 + temp;
            n = n/10;
        
        }
        return rev;
    }
    public static void main(String[] args) {
        int n = 234234234;
        
        int reverseNumber = reverse(n);
        System.out.println(reverseNumber);
    }
}
