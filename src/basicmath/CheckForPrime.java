package src.basicmath;

public class CheckForPrime {

    // we can check prime number from 1 to N in a linear time complexity
    /*
        n = 8
        1*8
        2*4
        // below two are just repetition of above in reverse order so we need to till above numbers only to reduce some time complexity

        4*2
        8*1

        how to do that?

        if we look carefully
        square root of 8 is between 2.5 and 3
        so we need to move i from 2 to till sqrt(N) and check if number is divisible by i
        if at any point it becomes true then it is not prime we just break out of it

    * */
    public static void main(String[] args) {
        int n = 23;
        boolean isPrime = true;
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0){
                isPrime = false;
                break;
            }
        }

        if(isPrime) System.out.println("Prime");
        else System.out.println("Not Prime");

    }
}
