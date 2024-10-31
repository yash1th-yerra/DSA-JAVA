package src.basicmath;

public class CheckForPrime {


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
