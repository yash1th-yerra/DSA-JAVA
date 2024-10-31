package src.basicmath;

public class GCDandLCM {

    public static int gcdN(int a,int b){
        if(b==0) return a;
        else return gcdN(b,a%b);

    }

    public static void main(String[] args) {

        int a=23;
        int b = 13;
        int gcd = 1;
        int lcm = 1;
        gcd = gcdN(a,b);
        lcm = a*b/gcd;
        System.out.println("LCM="+lcm);
        System.out.println("GCD="+gcd);


    }





}
