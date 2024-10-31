package src.basicmath;

public class ArmStrong {
    public static int countDigits(int n){
        int count = 0;
        while(n>0){
            n = n/10;
            count++;

        }
        return count;
    }


    public static int power(int n,int p){
        int sum = 1;
        for(int i=0;i<p;i++){
            sum = sum * n;
        }
        return sum;
    }
    public static boolean checkArmStrong(int n){
        int sum = 0;
        int temp = n;
        int p = countDigits(n);
        while(n>0){
            int rem = n%10;
            sum = sum + power(rem,p);
            n = n/10;
        }
        if(temp==sum){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int n = 153;
        if(checkArmStrong(n)){
            System.out.println("Armstrong");
        }
        else{
            System.out.println("Not Armstrong");
        }

    }


}
