package src.bitmanipulation;

public class SwapNumbers {

    // Note: we know xor of two numbers is 0
    public static void main(String[] args) {
        int a = 5;
        int b = 6;

        a = a^b;    // a = 5^6
        b = a^b;    // b = 5^6^6 = 5^0 = 5
        a = a^b;    // a = 5^6^5 = 6^0 = 6

        System.out.println(a);
        System.out.println(b);
    }

}
