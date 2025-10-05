package src.basicmath;

public class ReverseNumber {


    public static int reverse(int n){
        int rev = 0;
        while (n != 0) {
            int temp = n % 10;
            n /= 10;

            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && temp > 7)) {
                return 0; // overflow
            }
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && temp < -8)) {
                return 0; // underflow
            }

            rev = rev * 10 + temp;
        }
        return rev;
    }
    public static void main(String[] args) {
        int n = 2147483647;
        
        int reverseNumber = reverse(n);
        if(reverseNumber==0) System.out.println("Integer Overflow, Can't Reverse");
        else System.out.println(reverseNumber);
    }
}
