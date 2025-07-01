package src.recursion.getstronghold;

public class PowXN {
    public static double myPow(double x,int n){
        if(n==0) return 1;
        long N = n;
        if(N<0){
            x = 1/x;
            N = -N;

        }
        double result =1.0;
        while(N>0){
            if((N&1)==1){
                result = result*x;
            }
            x = x*x;
            N>>=1;
        }

        return result;

    }


    public static void main(String[] args) {
        System.out.println(myPow(2.0,3));
    }

}
