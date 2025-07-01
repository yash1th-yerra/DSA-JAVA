package src.recursion.getstronghold;

/*
    given a number so that you have to return total number of good digit strings of length n.
    a digit string is good if the digits at even indices are even and odd indices are prime
    0,2,4,6,8 -> 0,2,4,6,8
    1,3,5,7 -> 2,3,5,7


    i.e. for n length of string
    (n+1)/2 positions are even indices
    n/2 positions are odd indices

    and for each position of even indices there will 5 options i.e. 0,2,4,6,8 hence no of ways
    a string can have good digit string for even indices will be 5^(n+1)/2

    similarly for prime there will be 4 options 2,3,5,7 and positions are n/2

    hence answer for prime will be 4^(n/2)

    so the total no of ways will be 5^(n+1)/2 * 4^(n/2)
 */
public class CountGoodNumbers {

    static final long mod = 1000000007;

    private static long pow(long base,long exp){
        base%=mod;
        long result = 1;

        while(exp>0){
            if((exp&1)==1){
                result = (result*base)%mod;
            }
            base = (base*base)%mod;
            exp>>=1;
        }
        return result;

    }
    public static int countGoodNumber(long n){
        long evenPositions = (n+1)/2;
        long oddPositions = (n)/2;

        long evenWays = pow(5,evenPositions);
        long primeWays = pow(4,oddPositions);

        return (int)((evenWays*primeWays)%mod);
    }

    public static void main(String[] args) {
        System.out.println(countGoodNumber(2));
    }
}
